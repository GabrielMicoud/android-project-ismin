# **API**

- Ce dossier est le dossier du backend de l'application Android. Il a été codé en Typescript, grâce à l'environnement Nest.

- En plus de tous les dossiers et fichiers Nest, il comporte deux dossiers principaux : [src](https://github.com/GabrielMicoud/android-project-ismin/tree/main/api/src) et [data](https://github.com/GabrielMicoud/android-project-ismin/tree/main/api/data).

### - ***[data](https://github.com/GabrielMicoud/android-project-ismin/tree/main/api/data)***
Ce dossier comporte le fichier ```favoris.json``` servant à identifier quels appareils ont défini quels monuments en favoris. Il se présente comme un tableau d'objets, chacun ayant cette forme: 
```json
{
  "objectid" : "identifiant du monument",
  "imeiList" : [
    "un imei random",
    "imei d'un appareil vraiment cool", 
    "etc, etc ..."
  ]
}
```
Les données de ce fichier sont lues dès que l'application doit afficher des données en favoris. Chaque objet représente un monument, ayant la liste de tous les appareils l'ayant mis en favori.

### - ***[src](https://github.com/GabrielMicoud/android-project-ismin/tree/main/api/src)***
Ce dossier est le dossier principal du code du backend. Il contient :

- Le controller ```app.controller.ts``` qui analyse et découpe les requêtes HTTP. 
- Le module de service ```app.service.ts```, appelé par le controller, et qui contient toutes les fonctions appelant l'api d'Opendatasoft et mettant en forme les données avant l'envoi vers l'application.
- Le module de l'application ```app.module.ts```, qui regroupe tous les autres modules, avant d'être lancé par le main.
- Les interfaces ```ExternalMonument.ts``` et ```Monument.ts```, qui mettent en forme les données. Le premier sert lors de la réception des données d'Opendatasoft, tandis que le second est utilisé pour l'envoi vers l'application, simplifiant les objets relatifs aux monuments.
- Enfin, le fichier principal ```main.ts```, qui lance l'application en initialisant le port d'écoute à ```8080```.

## **Fonctionnement**
Le controller dispose de 4 fonctions principales: 

- Un GET, gérant le lien général [https://project-gmd-npl.cleverapps.io/monuments](https://project-gmd-npl.cleverapps.io/monuments), éventuellement complété du paramètre ```imei``` à la fin. Il appelle la fonction ```getAllMonuments``` du module de service et retourne la liste complète des monuments.
- Un autre GET, gérant un lien spécifique (le lien du dessus, complété par ```/identifiant_du_monument```). Il appelle la fonction ```getMonument``` du module de service, qui utilise l'identifiant du monument choisi pour le retourner à l'application.
- Un PUT, utilisant un lien similaire à celui du GET précédent. La fonction ```favMonument``` appelée utilise un *body* fourni par l'utilisateur dans sa requête, de la forme ci-dessous. Cette fonction est utilisée pour mettre un monument en favori ou non.
```javascript
{imei : "l'imei de l'appareil"}
```
- Enfin, un POST, utilisé pour la recherche de monuments via la fonction ```searchMonuments```. Il est accessible via le lien [https://project-gmd-npl.cleverapps.io/monuments/search](https://project-gmd-npl.cleverapps.io/monuments/search) et nécessite également un *body* de cette forme: 
```javascript
{term : "les mots clés de la recherche"}
```

## Format des données des monuments

Les données des monuments venant d'Opendatasoft sont présentés comme suit:

```javascript
{
    datasetid : string,
    recordid : string,
    fields : {
        insee : string,
        objectid_1 : string,
        lien_merim : string,
        objectid : string,
        dep : string,
        type_archi : string,
        nomcom : string,
        geo_point_2d : number[],
        st_lengthshape : string,
        geo_shape : {
            type : string,
        }
        protection : string,
        immeuble : string,
        date_prot : Date,
        st_areashape : string,
        ref_merim : string,
        type_prot : string,
    },
    geometry : {
        type : string,
        coordinates : number[],
    },
    record_timestamp : Date,
}
```
L'identifiant de chaque monument est ```objectid```. L'objet contient également le nom, la commune, le département, les coordonnées, et d'autres données utiles à l'application.

Lors d'un appel par un appareil, le backend transforme cet objet en mettant tous les champs au même niveau, sans sous-objet. De plus, le backend ajoute un booléen ```favorite``` et le définit à ```true``` si le monument a été mis en favori.

# Nest

<p align="center">
  <a href="http://nestjs.com/" target="blank"><img src="https://nestjs.com/img/logo_text.svg" width="320" alt="Nest Logo" /></a>
</p>

[circleci-image]: https://img.shields.io/circleci/build/github/nestjs/nest/master?token=abc123def456
[circleci-url]: https://circleci.com/gh/nestjs/nest

  <p align="center">A progressive <a href="http://nodejs.org" target="_blank">Node.js</a> framework for building efficient and scalable server-side applications.</p>
    <p align="center">
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/v/@nestjs/core.svg" alt="NPM Version" /></a>
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/l/@nestjs/core.svg" alt="Package License" /></a>
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/dm/@nestjs/common.svg" alt="NPM Downloads" /></a>
<a href="https://circleci.com/gh/nestjs/nest" target="_blank"><img src="https://img.shields.io/circleci/build/github/nestjs/nest/master" alt="CircleCI" /></a>
<a href="https://coveralls.io/github/nestjs/nest?branch=master" target="_blank"><img src="https://coveralls.io/repos/github/nestjs/nest/badge.svg?branch=master#9" alt="Coverage" /></a>
<a href="https://discord.gg/G7Qnnhy" target="_blank"><img src="https://img.shields.io/badge/discord-online-brightgreen.svg" alt="Discord"/></a>
<a href="https://opencollective.com/nest#backer" target="_blank"><img src="https://opencollective.com/nest/backers/badge.svg" alt="Backers on Open Collective" /></a>
<a href="https://opencollective.com/nest#sponsor" target="_blank"><img src="https://opencollective.com/nest/sponsors/badge.svg" alt="Sponsors on Open Collective" /></a>
  <a href="https://paypal.me/kamilmysliwiec" target="_blank"><img src="https://img.shields.io/badge/Donate-PayPal-ff3f59.svg"/></a>
    <a href="https://opencollective.com/nest#sponsor"  target="_blank"><img src="https://img.shields.io/badge/Support%20us-Open%20Collective-41B883.svg" alt="Support us"></a>
  <a href="https://twitter.com/nestframework" target="_blank"><img src="https://img.shields.io/twitter/follow/nestframework.svg?style=social&label=Follow"></a>
</p>
  <!--[![Backers on Open Collective](https://opencollective.com/nest/backers/badge.svg)](https://opencollective.com/nest#backer)
  [![Sponsors on Open Collective](https://opencollective.com/nest/sponsors/badge.svg)](https://opencollective.com/nest#sponsor)-->

## Description

[Nest](https://github.com/nestjs/nest) framework TypeScript starter repository.

## Installation

```bash
$ npm install
```

## Running the app

```bash
# development
$ npm run start

# watch mode
$ npm run start:dev

# production mode
$ npm run start:prod
```

## Test

```bash
# unit tests
$ npm run test

# e2e tests
$ npm run test:e2e

# test coverage
$ npm run test:cov
```

## Support

Nest is an MIT-licensed open source project. It can grow thanks to the sponsors and support by the amazing backers. If you'd like to join them, please [read more here](https://docs.nestjs.com/support).

## Stay in touch

- Author - [Kamil Myśliwiec](https://kamilmysliwiec.com)
- Website - [https://nestjs.com](https://nestjs.com/)
- Twitter - [@nestframework](https://twitter.com/nestframework)

## License

Nest is [MIT licensed](LICENSE).
