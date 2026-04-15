# Contexto del Proyecto: AzucarDJ

## Overview
Este proyecto en un servidor que proporciona listas de videos musicales y la forma en que se mezclan imitando a un DJ profesional.

El objetivo es una ambientación donde la imagen del video proyectado en pantallas coincida con la música.

## Tareas pendientes
- Autenticación
- instalar y aplicar test
- instalar y aṕlicar swagger
- conección a youtube api

## 1. Stack Tecnológico
- **Lenguaje**: Java 21 (LTS)
- **Framework Principal**: Spring Boot 4.x
- **Gestor de Dependencias**: Maven (pom.xml)
- **Base de Datos**: mysql
- **Entorno**: Desarrollo en Linux (Ubuntu 22.04) con Visual Studio Code.

## 2. Arquitectura
- **Estilo**: Arquitectura de capas
    - Capa de Presentación (Controller)
    - Capa de Negocio (Service)
    - Capa de Persistencia (Model)
    - Capa de Base de datos (Repository)
- **Estructura**:
    - `com.mrando.controller`: Endpoints REST.
    - `com.mrando.service`: Lógica de negocio e interfaces.
    - `com.mrando.infrastructure`: Implementaciones externas (como la futura API de YouTube).
    - `com.mrando.model`: Entidades y DTOs.
    - `com.mrando.security`: Accesos a rutas.0
    <!-- - `com.mrando.auth`: -->

## 3. Convenciones Técnicas
- **JSON**: Uso de Json para serialización.
- **Documentación**: Swagger/OpenAPI habilitado en `/swagger-ui.html`.
- **Testing**: JUnit 5 y Mockito para pruebas unitarias.
- **Variables de Entorno**: Gestionadas a través de `application.properties`.

## 4. Glosario del Dominio
<!-- - **VideoData**: Objeto que unifica la respuesta de la API externa con nuestro modelo interno.
- **YouTubeClient**: Interfaz que define el contrato de comunicación con Google. --> -->



