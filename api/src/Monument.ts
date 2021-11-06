export interface Monument {
    readonly datasetid : string,
    readonly recordid : string,
    readonly fields : {
        readonly insee : string,
        readonly objectid_1 : string,
        readonly lien_merim : string,
        readonly objectid : string,
        dep : string,
        type_archi : string,
        nomcom : string,
        geo_point_2d : number[],
        st_lengthshape : string,
        geo_shape : {
            type : string,
            //coordinates, c'est un tableau contenant d'autres tableaux de nombres
        }
        protection : string,
        immeuble : string,
        date_prot : string, //maybe Date
        st_areashape : string,
        ref_merim : string,
        type_prot : string,
    }
    geometry : {
        type : string,
        coordinates : number[],
    }
    record_timestamp : string, //maybe Date
}