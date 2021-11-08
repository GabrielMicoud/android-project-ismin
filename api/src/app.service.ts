import { Injectable, Logger, OnModuleInit } from '@nestjs/common';
import { readFile } from 'fs/promises';
import { HttpService } from '@nestjs/axios';
import { Monument } from './Monument';
import { ExternalMonuments } from './ExternalMonuments';
import { firstValueFrom, map } from 'rxjs';

@Injectable()
export class AppService {
  private readonly monumentStorage = new Map<string, Monument>();
  private readonly logger = new Logger(AppService.name);

  constructor(private readonly httpService: HttpService) {}

  async onModuleInit(): Promise<void> {
    //Call external API
    //link = https://data.opendatasoft.com/api/records/1.0/search/?dataset=monuments-historiques-classes-ou-inscrits-de-type-industriel-en-ile-de-france-do%40datailedefrance&q=
    const externalMonuments = await firstValueFrom(
      this.httpService
        .get<ExternalMonuments>('https://data.opendatasoft.com/api/records/1.0/search/?dataset=monuments-historiques-classes-ou-inscrits-de-type-industriel-en-ile-de-france-do%40datailedefrance&q=')
        .pipe(
          map((response) =>
            response.data.records.map((extMonument) => ({
              datasetid : extMonument.datasetid,
              recordid : extMonument.recordid,
              //fields
              fields: {
                insee : extMonument.fields.insee,
                objectid_1 : extMonument.fields.objectid_1,
                lien_merim : extMonument.fields.lien_merim,
                objectid : extMonument.fields.objectid,
                dep : extMonument.fields.dep,
                type_archi : extMonument.fields.type_archi,
                nomcom : extMonument.fields.nomcom,
                geo_point_2d : extMonument.fields.geo_point_2d,
                st_lengthshape : extMonument.fields.st_lengthshape,
                protection : extMonument.fields.protection,
                immeuble : extMonument.fields.immeuble,
                date_prot : new Date(extMonument.fields.date_prot),
                st_areashape : extMonument.fields.st_areashape,
                ref_merim : extMonument.fields.ref_merim,
                type_prot : extMonument.fields.type_prot,
              },
              //geometry
              geometry : {
                type : extMonument.geometry.type,
                coordinates : extMonument.geometry.coordinates,
              },
              record_timestamp : new Date(extMonument.record_timestamp),
            })),
          ),
        ),
    );
    [...externalMonuments].forEach((monument) => this.addMonument(monument));
  }

  addMonument(monument : Monument): void {
    this.monumentStorage.set(monument.fields.objectid, monument);
  }

  getAllMonuments(): Monument[] {
    return Array.from(this.monumentStorage.values()).sort((monument1, monument2) => monument1.fields.immeuble.localeCompare(monument2.fields.immeuble));
  }

  getMonument(objectid : string): Monument {
    const foundMonument = this.monumentStorage.get(objectid);
    if(!foundMonument) throw new Error(`No monument found with identifier : ${objectid}`);
    return foundMonument;
  }

  favMonument(objectid : string): void {

  }
}
