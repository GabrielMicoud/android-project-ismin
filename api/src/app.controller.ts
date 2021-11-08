import { Controller, Get, Put, Param, Body, Query } from '@nestjs/common';
import { Monument } from './Monument';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  async getAllMonuments(@Query('imei') imei: string) : Promise<Monument[]> {
    return await this.appService.getAllMonuments(imei);
  }

  @Get(':objectid')
  async getMonument(@Param('objectid') objectid : string, @Query('imei') imei: string) : Promise <Monument> {
    return await this.appService.getMonument(objectid, imei);
  }

  //mettre un monument en favori (bordel ça va être chiant)
  @Put(':objectid')
  async favMonument(@Param('objectid') objectid : string, @Body() imei: string ) : Promise<void> {
    await this.appService.favMonument(objectid, imei);
  }
}
