## ADDED Requirements

### Requirement: El endpoint `POST /auth/register` SHALL registrar nuevos usuarios
El sistema SHALL exponer `POST /auth/register` que recibe los datos de un nuevo usuario y lo persiste con la contraseña encriptada con BCrypt.

#### Scenario: Registro exitoso
- **WHEN** se hace `POST /auth/register` con `username`, `password` y `email` válidos
- **THEN** el servidor SHALL persistir el usuario con `password` encriptada y responder HTTP 201 con los datos del usuario creado (sin la contraseña)

#### Scenario: Registro con username ya existente
- **WHEN** se hace `POST /auth/register` con un `username` que ya existe en la base de datos
- **THEN** el servidor SHALL responder HTTP 409 Conflict

### Requirement: Las contraseñas SHALL almacenarse encriptadas con BCrypt
El sistema SHALL encriptar la contraseña del usuario usando `BCryptPasswordEncoder` antes de persistirla en la base de datos.

#### Scenario: Contraseña encriptada en base de datos
- **WHEN** se registra un nuevo usuario con contraseña en texto plano
- **THEN** la contraseña almacenada en la tabla `Users` SHALL comenzar con `$2a$` (formato BCrypt)
