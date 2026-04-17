## 1. Dependencia y configuración base

- [x] 1.1 Agregar `springdoc-openapi-starter-webmvc-ui` (versión 2.8.x o superior) al `pom.xml`
- [x] 1.2 Crear la clase `OpenApiConfig` con `@Bean` de tipo `OpenAPI` que defina título "AzucarDJ API", versión "0.0.1" y descripción del proyecto
- [x] 1.3 Agregar en `application.properties` la propiedad `springdoc.swagger-ui.path=/swagger-ui.html` para fijar la ruta de la UI
- [x] 1.4 Agregar en `DatabaseWebSecurity.filterChain` los matchers `/swagger-ui/**` y `/v3/api-docs/**` con `permitAll()` explícito

## 2. Anotar controladores con `@Tag`

- [x] 2.1 Anotar `ArtistsController` con `@Tag(name = "Artists", description = "Gestión de artistas")`
- [x] 2.2 Anotar `ContactsController` con `@Tag(name = "Contacts", description = "Gestión de contactos de perfil")`
- [x] 2.3 Anotar `DjListsController` con `@Tag(name = "DjLists", description = "Gestión de listas de reproducción DJ")`
- [x] 2.4 Anotar `GenresController` con `@Tag(name = "Genres", description = "Gestión de géneros musicales")`
- [x] 2.5 Anotar `HomeController` con `@Tag(name = "Home", description = "Endpoints de bienvenida y utilidades")`
- [x] 2.6 Anotar `ItemsController` con `@Tag(name = "Items", description = "Gestión de ítems de una DjList")`
- [x] 2.7 Anotar `NetworksController` con `@Tag(name = "Networks", description = "Gestión de redes sociales")`
- [x] 2.8 Anotar `ThemesController` con `@Tag(name = "Themes", description = "Gestión de temas musicales")`
- [x] 2.9 Anotar `UserController` con `@Tag(name = "Users", description = "Gestión de usuarios")`
- [x] 2.10 Anotar `VideosController` with `@Tag(name = "Videos", description = "Gestión de videos musicales")`

## 3. Anotar endpoints con `@Operation` y `@ApiResponse`

- [x] 3.1 Anotar todos los endpoints de `ArtistsController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.2 Anotar todos los endpoints de `ContactsController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.3 Anotar todos los endpoints de `DjListsController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.4 Anotar todos los endpoints de `GenresController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.5 Anotar todos los endpoints de `HomeController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.6 Anotar todos los endpoints de `ItemsController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.7 Anotar todos los endpoints de `NetworksController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.8 Anotar todos los endpoints de `ThemesController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.9 Anotar todos los endpoints de `UserController` con `@Operation` y respuestas `@ApiResponse`
- [x] 3.10 Anotar todos los endpoints de `VideosController` con `@Operation` y respuestas `@ApiResponse`

## 4. Verificación

- [ ] 4.1 Compilar el proyecto (`mvn compile`) sin errores
- [ ] 4.2 Iniciar la aplicación y verificar que `http://localhost:8080/swagger-ui.html` carga correctamente
- [ ] 4.3 Verificar que `http://localhost:8080/v3/api-docs` retorna JSON válido con todos los endpoints documentados
- [ ] 4.4 Verificar que los 10 grupos/tags aparecen en la UI de Swagger
