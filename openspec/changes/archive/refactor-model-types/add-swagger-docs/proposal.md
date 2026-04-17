## Why

El proyecto `azucar-server` expone una API REST con más de 40 endpoints distribuidos en 10 controladores, pero no cuenta con documentación interactiva. Integrar Springdoc OpenAPI (Swagger UI) permite a los desarrolladores explorar, entender y probar los endpoints sin necesidad de herramientas externas, acelerando la integración y el desarrollo.

## What Changes

- Agregar la dependencia `springdoc-openapi-starter-webmvc-ui` al `pom.xml`.
- Crear una clase de configuración `OpenApiConfig` con metadatos del proyecto (título, versión, descripción, contacto).
- Anotar todos los controladores REST con `@Tag` para agruparlos por dominio en la UI.
- Anotar los métodos de cada controlador con `@Operation` y `@ApiResponse` para documentar cada endpoint.
- Exponer la UI de Swagger en `/swagger-ui.html` y el JSON de la spec en `/v3/api-docs`.
- Configurar Spring Security para permitir acceso público a las rutas de Swagger sin autenticación.

## Capabilities

### New Capabilities
- `swagger-ui`: Interfaz interactiva de documentación de la API disponible en `/swagger-ui.html`.
- `openapi-endpoint-docs`: Anotaciones OpenAPI en controladores que describen operaciones, parámetros y respuestas.

### Modified Capabilities
<!-- Sin cambios en especificaciones existentes -->

## Impact

- **`pom.xml`**: Se agrega una dependencia nueva (`springdoc-openapi-starter-webmvc-ui`).
- **Controladores** (10 clases en `com.mrando.azucardj.controller`): Anotaciones `@Tag`, `@Operation`, `@ApiResponse`.
- **Seguridad** (`DatabaseWebSecurity`): Permitir rutas `/swagger-ui/**`, `/v3/api-docs/**` sin autenticación.
- **Nueva clase**: `OpenApiConfig` en `com.mrando.azucardj` o sub-paquete de configuración.
- **`application.properties`**: Configuración opcional de Springdoc (path de la UI, habilitado/deshabilitado por perfil).
