[![Mines St Etienne](./logo.png)](https://www.mines-stetienne.fr/)

Part of Android & Web Development - ISMIN 2021

Course followed by students of Mines St Etienne, ISMIN - M2 Computer Science.

<p align="center">
  <a><img src="./intro_megumin.png" width="400" alt="Presentation" /></a>
</p>

<p align="center"><strong>Gabriel Micoud</strong> & <strong>Nicolas Planard Luong</strong></p>

# **Monumines**

- Ce projet est une application android qui affiche les monuments historiques classés ou inscrits de type industriel en Île de France. 
- Il utilise la base de données [Opendatasoft](https://data.opendatasoft.com/explore/dataset/monuments-historiques-classes-ou-inscrits-de-type-industriel-en-ile-de-france-do%40datailedefrance/information/), qui fournit un enregistrement de 46 monuments de ce type sous format JSON.

## **Features**

Cette application possède 5 fonctionnalités :

- Elle affiche une liste des monuments, et pour chacun d'entre eux l'application affiche leur nom, leur département et leur numéro de commune.
- Lorsqu'on clique sur un élément de la liste, un nouvel écran apparaît, affichant tous les détails de cette liste, comme une description, la date d'enregistrement dans la base de données, le type d'architecture, etc...
- Elle permet de mettre un monument en favori.
- Une carte montrant la localisation des monuments.
- Enfin, l'application affiche les informations générales des données utilisées pour l'affichage, comme le lien vers la base de données, ainsi que les librairies et les licences utilisées.

## **Développement**

Ce projet est divisé en deux parties : un API, déployé sur [Clevercloud](https://console.clever-cloud.com/organisations/orga_693c81f4-6d20-46f3-901b-29afc84a379d/applications/app_88092840-1fcd-48c8-bddb-eb023aa00f24), dont les données sont accessibles [ici](https://project-gmd-npl.cleverapps.io/monuments), et une application Android.

Ce projet comporte donc deux dossiers principaux, le dossier [api](https://github.com/GabrielMicoud/android-project-ismin/tree/main/api) et le dossier [android](https://github.com/GabrielMicoud/android-project-ismin/tree/main/android).

### - ***Dossier api :***

L'API a été codé en Typescript, et possède plusieurs fonctions principales :

- Une fonction ```getAllMonuments```, qui affiche tous les monuments dans une liste, certains monuments étant affichés en favoris.
- Une fonction ```getMonument```, qui affiche un monument en détail.
- Une fonction ```favMonument```, qui prend l'imei du téléphone qui envoie la requête, et qui l'associe à l'identifiant ```objectid``` du monument. Le monument s'affiche alors différemment sur l'appareil.
- Enfin, une fonction ```searchMonument```, qui prend en compte un champ ```term``` entré dans une recherche. La fonction renvoie tous les monuments dont le nom, le numéro de la commune ou le nom du département correspondent.

Le détail de ces fonctions est expliqué [ici, dans le readme](https://github.com/GabrielMicoud/android-project-ismin/tree/main/api).




 
