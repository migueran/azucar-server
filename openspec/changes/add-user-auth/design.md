## Context

`azucar-server` es una API REST con Spring Boot 4.0.2 / Java 21. Ya tiene `spring-boot-starter-security` en el `pom.xml` y una clase `DatabaseWebSecurity` con `SecurityFilterChain`, `PasswordEncoder` (BCrypt) y `JdbcUserDetailsManager`. El modelo `User` tiene campos `username`, `password`, `status` y una relación `ManyToMany` con `Role`. El `UserRepository` extiende `JpaRepository<User, Integer>`. Actualmente todas las rutas tienen `permitAll()` sin autenticación real.

## Goals / Non-Goals

**Goals:**
- Implementar autenticación JWT stateless siguiendo el estándar de Spring Security 6.x.
- Exponer `POST /auth/login` para obtener un token y `POST /auth/register` para crear usuario.
- Proteger todos los endpoints (excepto auth y Swagger) con validación de JWT en cada request.
- Reemplazar `JdbcUserDetailsManager` por una implementación propia que use `UserRepository`.

**Non-Goals:**
- No se implementará refresh token en esta iteración.
- No se implementará OAuth2 / SSO.
- No se agregarán roles granulares por endpoint (solo autenticado vs. no autenticado).
- No se modificarán los controladores existentes más allá de la config de seguridad.

## Decisions

### JWT stateless en lugar de sesiones HTTP
La API es consumida por clientes REST (futura app o Swagger), por lo que las sesiones HTTP no aplican. JWT permite escalar horizontalmente sin estado compartido.

_Alternativa considerada_: HTTP Basic / Form Login — descartada por no ser apropiada para APIs REST modernas.

### Librería `jjwt` (io.jsonwebtoken)
Es la librería JWT más usada en el ecosistema Spring. Compatible con Java 21 y Spring Boot 4.x a través de `jjwt-api` + `jjwt-impl` + `jjwt-jackson`.

_Alternativa considerada_: `spring-security-oauth2-resource-server` con `nimbus-jose-jwt` — descartada por mayor complejidad de configuración para este caso de uso simple.

### `UserDetailsServiceImpl` propio
El `JdbcUserDetailsManager` actual tiene un bug en la query de roles. Implementar `UserDetailsService` directamente sobre `UserRepository` es más simple, testeable y controlable.

### Paquete `com.mrando.azucardj.auth`
Se crea un paquete dedicado `auth` para agrupar `AuthController`, `AuthService`, `JwtUtils`, `JwtAuthFilter`, `LoginRequest` y `AuthResponse`. `UserDetailsServiceImpl` va en `security` por estar acoplado a Spring Security.

### Secret JWT en `application.properties`
La clave secreta se externaliza en `application.properties` como `jwt.secret` (base64 o string largo). Para producción se debe usar una variable de entorno.

## Risks / Trade-offs

- **[Risk] Spring Boot 4.x + jjwt**: Verificar que `jjwt 0.12.x` sea compatible con las clases de Spring Security 6.x incluidas en Boot 4. → _Mitigación_: Usar `jjwt 0.12.6` (última estable).
- **[Risk] `spring.jpa.hibernate.ddl-auto=create-drop`**: Al reiniciar la app se borran los datos incluyendo usuarios. → _Mitigación_: Documentar que en desarrollo se deben recrear usuarios al iniciar.
- **[Trade-off] Sin refresh token**: Los tokens expiran y el cliente debe re-autenticarse. → _Mitigación_: Configurar expiración larga en desarrollo (`jwt.expiration=86400000` = 24h).
- **[Risk] CSRF**: Al usar JWT stateless se deshabilita CSRF. → _Mitigación_: Esto es correcto para APIs REST sin formularios HTML.
