import { Controller, Get, Put, Param, Body, Query, Post } from '@nestjs/common';
import { Monument } from './Monument';
import { AppService } from './app.service';

@Controller("monuments")
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  async getAllMonuments(@Query('imei') imei: string) : Promise<Monument[]> {
    return await this.appService.getAllMonuments(imei);
  }

  @Get(':objectid')
  async getMonument(@Param('objectid') objectid : string, @Query('imei') imei: string) : Promise<Monument> {
    return await this.appService.getMonument(objectid, imei);
  }

  @Put(':objectid')
  async favMonument(@Param('objectid') objectid : string, @Body() imei: string ) : Promise<void> {
    await this.appService.favMonument(objectid, imei);
  }

  @Post('search')
  async searchMonuments(@Body() body : {term : string}, @Query('imei') imei : string) : Promise<Monument[]> {
    let searchterm;
    searchterm = body != undefined ? body.term : "";
    return await this.appService.searchMonumentByNameDepTypeArchi(searchterm, imei);
  }
}
