## Context

`azucar-server` es un API REST construida con Spring Boot 4.0.2 y Java 21. Tiene 10 controladores REST con más de 40 endpoints y ya menciona Swagger/OpenAPI como tarea pendiente en `openspec/specs/project.md`. La seguridad está configurada con `DatabaseWebSecurity` usando `permitAll()` para todas las rutas, lo que simplifica la integración. No hay ninguna dependencia de Swagger/Springdoc en el `pom.xml` actualmente.

## Goals / Non-Goals

**Goals:**
- Exponer una UI interactiva de Swagger en `/swagger-ui.html`.
- Exponer el contrato OpenAPI en JSON en `/v3/api-docs`.
- Documentar todos los endpoints con `@Tag`, `@Operation` y `@ApiResponse`.
- Configurar metadatos del proyecto (título, versión, descripción) via `OpenApiConfig`.
- Garantizar acceso sin autenticación a las rutas de Swagger.

**Non-Goals:**
- No se generarán DTOs ni se cambiarán los modelos de respuesta.
- No se versionará la API (v1, v2).
- No se configurará autenticación en Swagger UI (no hay JWT ni OAuth en el proyecto actualmente).
- No se agregarán anotaciones `@Schema` a los modelos en esta iteración.

## Decisions

### Usar Springdoc OpenAPI en lugar de Springfox
Spring Boot 4.x ya no es compatible con Springfox (que requiere Spring MVC 5.x). Springdoc OpenAPI (`springdoc-openapi-starter-webmvc-ui`) es la librería estándar y activamente mantenida para Spring Boot 3/4.

_Alternativa considerada_: Springfox 3 — descartada por incompatibilidad con Spring Boot 4.

### Clase `OpenApiConfig` separada
Se crea una clase `@Configuration` dedicada para centralizar metadatos de la API (título, versión, contacto, licencia). Esto evita contaminar la clase principal `AzucardjApplication`.

### Anotar controladores con `@Tag` y métodos con `@Operation`
Las anotaciones se aplican directamente en los controladores existentes, sin modificar la lógica de negocio. Es el enfoque estándar de Springdoc y evita archivos YAML adicionales.

### Rutas de Swagger en lista blanca de seguridad
Aunque actualmente `/**` tiene `permitAll()`, se agrega explícitamente `/swagger-ui/**` y `/v3/api-docs/**` como buena práctica para cuando la seguridad se endurezca en el futuro.

## Risks / Trade-offs

- **[Risk] Spring Boot 4.x + Springdoc**: Springdoc 2.x soporta Spring Boot 3.x; para Boot 4.x puede requerirse la versión más reciente (2.8+). → _Mitigación_: Verificar compatibilidad al agregar la dependencia y usar `springdoc-openapi-starter-webmvc-ui:2.8.x` o superior.
- **[Trade-off] Verbosidad de anotaciones**: Anotar 40+ endpoints añade código boilerplate. → _Mitigación_: Limitar `@Operation` a descripción y `summary`; `@ApiResponse` solo para casos no obvios.
