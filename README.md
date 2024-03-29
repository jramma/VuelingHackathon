# VuelingHackathon

Solution for the Vueling Hackathon 2023 
(https://nuwe.io/dev/competitions/vueling-tech-hack/travel-search-backend-challenge) 

Los métodos POST son la solución a crear una API "que sea ampliable"
La web y el buscador son la solución al problema principal. La API no discrimina en idiomas, se puede añadir a la base de datos ciudades en el idioma que quieras así como Trips.


## Instalación

El proyecto puede ser descargado en un archivo .zip y hacerlo funcionar en tu IDE.

***Importante!:*** tengo instalado y uso lombok en mi IDE. Si no tienes lombok tendrás que crear setters, getters y constructores de las clases.

La API funciona con MongoDB, es necesario tener instalado previamente MongoDb porque utiliza el localHost por defecto. 
Una vez instalado, crear una base de datos con nombre "Vueling" que es la indicada en aplications.properties de la API. 

## Uso
1. Configurar la base de datos. Tienes mi base de datos inicial exportada en BDVuelingBackup. Puedes añadir más datos a la base de datos con los métodos Post que explicaré más alante o manualmente.
1. Ejecutar DemoApplication y se te abrirá en el navegador la interfaz, una vez abierta escribe la ciudad que quieras.
Hay pocos ejemplos, con Madrid te funciona. 

2. He considerado la opción de ampliar la API por ello he creado dos métodos POST.
Desde Postman puedes añadir ciudades y trips (en formato .json) en los idiomas que quieras y seguirá funcionando la API. 

## API Design
En la carpeta BDVuelingBackup tienes la base de datos Vueling exportada con unos pocos ejemplos para probar la API.

La estructura de los paquetes es la siguiente:

- Controller: aporta los endpoints con la inyección del repositorio de compañías.
- Domain: aquí se encuentra los document City y Trip que refieren a los de la bd.
- dto: dto.
- Repository: contiene los repositorios. EL CityRepo tiene un método de queries, el TripRepo las queries las he hecho en el service.
- Service: tiene el servicio que es inyectado en el controller.
- En resources tienes el html (la página web que ves al ejecutar la api) y 
en test>resources>json tienes los json que me he inventado para la base de datos.

## Capturas de la API funcionando


>> Tras ejecutar el programa en tu IDE:

![vueling](https://user-images.githubusercontent.com/107991714/217307228-03077013-b149-4dfb-aec5-d8d99e46bf65.gif)



>> Cómo subir una nueva ciudad en cualquier idioma:
> http://localhost:9797/vueling/api/addCity

<img width="1014" alt="Captura de pantalla 2023-02-07 a las 17 35 53" src="https://user-images.githubusercontent.com/107991714/217307092-fa7428a5-2fdb-4247-978f-9ba15e3de91b.png">

>> Cómo subir un Trip en cualquier idioma:
> http://localhost:9797/vueling/api/addTrip


<img width="1025" alt="Captura de pantalla 2023-02-07 a las 17 37 29" src="https://user-images.githubusercontent.com/107991714/217307053-1fd414f2-1612-48be-a5e4-db7ec84a96be.png">


