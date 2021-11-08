import { Controller, Get, Put, Param } from '@nestjs/common';
import { Monument } from './Monument';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getAllMonuments() : Monument[] {
    return this.appService.getAllMonuments();
  }

  @Get(':objectid')
  getMonument(@Param('objectid') objectid : string) : Monument {
    return this.appService.getMonument(objectid);
  }

  //mettre un monument en favori (bordel ça va être chiant)
  @Put(':objectid')
  favMonument(@Param('objectid') objectid : string) : void {
    this.appService.favMonument(objectid);
  }
}
