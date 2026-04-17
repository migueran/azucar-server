## ADDED Requirements

### Requirement: La UI de Swagger SHALL estar disponible en `/swagger-ui.html`
La aplicación SHALL exponer una interfaz interactiva de documentación de la API en la ruta `/swagger-ui.html` sin necesidad de autenticación.

#### Scenario: Acceso a Swagger UI
- **WHEN** un usuario navega a `http://localhost:8080/swagger-ui.html`
- **THEN** SHALL cargarse la interfaz Swagger UI con todos los grupos de endpoints visibles

#### Scenario: Acceso sin autenticación
- **WHEN** un usuario no autenticado accede a `/swagger-ui.html` o `/v3/api-docs`
- **THEN** el servidor SHALL responder con HTTP 200 sin redirigir a login

### Requirement: El contrato OpenAPI SHALL estar disponible en `/v3/api-docs`
La aplicación SHALL exponer el contrato de la API en formato JSON en la ruta `/v3/api-docs`.

#### Scenario: Obtención del contrato JSON
- **WHEN** se realiza un GET a `/v3/api-docs`
- **THEN** SHALL retornar un JSON válido con la especificación OpenAPI 3.x del proyecto

### Requirement: Los metadatos del proyecto SHALL estar configurados en la UI
La UI SHALL mostrar el título, versión y descripción del proyecto `azucar-server`.

#### Scenario: Metadatos visibles en Swagger UI
- **WHEN** se carga Swagger UI
- **THEN** SHALL mostrarse el título "AzucarDJ API", la versión "0.0.1" y una descripción del proyecto
