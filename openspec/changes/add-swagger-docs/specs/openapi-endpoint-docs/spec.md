## ADDED Requirements

### Requirement: Cada controlador SHALL estar anotado con `@Tag`
Todos los controladores REST SHALL tener la anotación `@Tag(name = "...", description = "...")` para agrupar sus endpoints en la UI de Swagger bajo un nombre de dominio legible.

#### Scenario: Agrupación por controlador en Swagger UI
- **WHEN** se carga Swagger UI
- **THEN** SHALL mostrarse un grupo/tag por cada controlador (Artists, Contacts, DjLists, Genres, Home, Items, Networks, Themes, Users, Videos)

### Requirement: Cada método de endpoint SHALL estar anotado con `@Operation`
Todos los métodos de los controladores REST SHALL tener la anotación `@Operation(summary = "...", description = "...")` describiendo el propósito del endpoint.

#### Scenario: Descripción visible en Swagger UI
- **WHEN** el usuario expande un endpoint en Swagger UI
- **THEN** SHALL mostrarse el `summary` del `@Operation` como título del endpoint

### Requirement: Las respuestas de error SHALL estar documentadas con `@ApiResponse`
Los endpoints SHALL anotar al menos las respuestas HTTP relevantes (200, 201, 404, 400) usando `@ApiResponse`.

#### Scenario: Respuestas documentadas
- **WHEN** el usuario expande un endpoint en Swagger UI
- **THEN** SHALL visualizarse al menos la respuesta de éxito con su código HTTP correspondiente
