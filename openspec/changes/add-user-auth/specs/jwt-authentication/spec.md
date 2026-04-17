## ADDED Requirements

### Requirement: El endpoint `POST /auth/login` SHALL autenticar usuarios y devolver un JWT
El sistema SHALL exponer `POST /auth/login` que recibe `username` y `password` en el body y retorna un token JWT junto con el username y los roles del usuario autenticado.

#### Scenario: Login exitoso
- **WHEN** se hace `POST /auth/login` con credenciales válidas (`username`, `password`)
- **THEN** el servidor SHALL responder HTTP 200 con un JSON que contiene `token`, `username` y `roles`

#### Scenario: Login con credenciales inválidas
- **WHEN** se hace `POST /auth/login` con username o password incorrectos
- **THEN** el servidor SHALL responder HTTP 401 Unauthorized

### Requirement: Los endpoints protegidos SHALL requerir un JWT válido en el header `Authorization`
Todos los endpoints fuera de `/auth/**` SHALL rechazar requests sin un token válido en el header `Authorization: Bearer <token>`.

#### Scenario: Request con token válido
- **WHEN** se hace un request a un endpoint protegido con header `Authorization: Bearer <token_valido>`
- **THEN** el servidor SHALL procesar el request y responder normalmente

#### Scenario: Request sin token
- **WHEN** se hace un request a un endpoint protegido sin header `Authorization`
- **THEN** el servidor SHALL responder HTTP 401 Unauthorized

#### Scenario: Request con token expirado o inválido
- **WHEN** se hace un request con un token mal formado o expirado
- **THEN** el servidor SHALL responder HTTP 401 Unauthorized

### Requirement: Las rutas públicas SHALL ser accesibles sin token
Las rutas `/auth/**`, `/swagger-ui/**` y `/v3/api-docs/**` SHALL ser accesibles sin autenticación.

#### Scenario: Acceso a rutas públicas sin token
- **WHEN** se accede a `/auth/login`, `/auth/register`, `/swagger-ui.html` o `/v3/api-docs`
- **THEN** el servidor SHALL responder sin exigir Authorization header
