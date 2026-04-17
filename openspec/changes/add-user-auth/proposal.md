## Why

`azucar-server` expone una API REST pero actualmente todas las rutas tienen `permitAll()` sin ningún mecanismo de autenticación real. La configuración de `DatabaseWebSecurity` usa `JdbcUserDetailsManager` con una query de roles incorrecta (bug de joins). Es necesario implementar autenticación estándar con JWT para proteger los endpoints y seguir el patrón stateless esperado en APIs REST con Spring Boot.

## What Changes

- Agregar la dependencia `jjwt` (Java JWT) al `pom.xml` para generación y validación de tokens.
- Crear un DTO `LoginRequest` (username, password) y `AuthResponse` (token, username, roles).
- Crear `UserDetailsServiceImpl` que implemente `UserDetailsService` de Spring Security cargando el usuario desde `UserRepository`.
- Crear `JwtUtils` para generación, validación y extracción de claims de tokens JWT.
- Crear `JwtAuthFilter` (`OncePerRequestFilter`) para interceptar requests y validar el token en el header `Authorization: Bearer <token>`.
- Crear `AuthController` con endpoints `POST /auth/login` y `POST /auth/register`.
- Crear `AuthService` con la lógica de autenticación y registro.
- **BREAKING** Reemplazar `JdbcUserDetailsManager` en `DatabaseWebSecurity` por `UserDetailsServiceImpl`.
- **BREAKING** Actualizar `SecurityFilterChain` para aplicar protección JWT a las rutas (excepto `/auth/**`, `/swagger-ui/**`, `/v3/api-docs/**`).
- Agregar `findByUsername` a `UserRepository`.

## Capabilities

### New Capabilities
- `jwt-authentication`: Autenticación stateless con JWT — login devuelve token, rutas protegidas validan el Bearer token.
- `user-registration`: Registro de usuarios nuevos vía `POST /auth/register` con contraseña encriptada.

### Modified Capabilities

## Impact

- **`pom.xml`**: Nuevas dependencias `jjwt-api`, `jjwt-impl`, `jjwt-jackson`.
- **`DatabaseWebSecurity`**: Reemplaza `JdbcUserDetailsManager` por `UserDetailsServiceImpl`; configura JWT filter y reglas de autorización.
- **`UserRepository`**: Agrega `findByUsername(String username)`.
- **Nuevas clases**: `AuthController`, `AuthService`, `UserDetailsServiceImpl`, `JwtUtils`, `JwtAuthFilter`, `LoginRequest`, `AuthResponse`.
- **`application.properties`**: Propiedad `jwt.secret` y `jwt.expiration`.
