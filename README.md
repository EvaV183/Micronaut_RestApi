# 🎬 Sitio Web de Películas - Micronaut + Java + MySQL

Este proyecto es una API REST desarrollada en **Java** utilizando el framework **Micronaut**, que permite gestionar una base de datos de películas. 
La aplicación expone endpoints para consultar, agregar y eliminar películas. 
Todo el entorno se levanta con **Docker Compose**, incluyendo una base de datos **MySQL**. 
Además, se utiliza **Swagger/OpenAPI** para documentar e interactuar con los endpoints de forma visual.


## 🚀 Tecnologías utilizadas

- **Java 17+**
- **Micronaut Framework**
- **MySQL**
- **Swagger / OpenAPI**
- **Docker & Docker Compose**


## 📦 Estructura del proyecto

```
Application/
├── 📁 src/
│   ├── 📁 docs/
│   │   ├── asciidoc/
│   │       └── index.adoc
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │    └──📁 com/demo
│   │   │           ├── Application.java
│   │   │           ├── Pelicula.java
│   │   │           ├── PeliculasController.java
│   │   │           └── PeliculasRepository.java
│   │   ├── 📁 resources/
│   │       ├── application.properties
│   │       └── logback.xml
│   ├── 📁 test/
│       ├── 📁 groovy/
│       │   ├── 📁 com/
│       │       ├── 📁 application/
│       │       │   ├── Fixtures.groovy
│       │       │   ├── PeliculasControllerSpec.groovy
│       │       │   └── PeliculasRepositorySpec.groovy
│       │       ├── 📁 demo/
│       │           └── ApplicationSpec.groovy
│       ├── 📁 resources/
│           └── application-test.properties
├── README.md
├── build.gradle
├── docker-compose.yml
├── gradle.properties
├── gradlew
├── gradlew.bat
├── micronaut-cli.yml
├── openapi.properties
└── settings.gradle

```

## 🔧 Endpoints disponibles

| Método  | Ruta                  | Descripción                       |
|---------|-----------------------|-----------------------------------|
| GET     | `/peliculas`          | Obtiene todas las películas       |
| GETBYID | `/peliculas/{id}`     | Obtiene una película por ID       |
| POST    | `/peliculas`          | Crea una nueva película           |
| DELETE  | `/peliculas/{id}`     | Elimina una película por ID       |


