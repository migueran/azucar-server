## 1. Dependencias

- [x] 1.1 Agregar `jjwt-api` (0.12.6), `jjwt-impl` y `jjwt-jackson` al `pom.xml`

## 2. Configuración y propiedades

- [x] 2.1 Agregar `jwt.secret` (string base64 seguro, mínimo 256 bits) y `jwt.expiration=86400000` en `application.properties`

## 3. DTOs de autenticación

- [x] 3.1 Crear `LoginRequest` en `com.mrando.azucardj.auth` con campos `username` (String) y `password` (String)
- [x] 3.2 Crear `AuthResponse` en `com.mrando.azucardj.auth` con campos `token` (String), `username` (String) y `roles` (List<String>)

## 4. Repositorio

- [x] 4.1 Agregar `Optional<User> findByUsername(String username)` a `UserRepository`

## 5. Servicio de detalles de usuario

- [x] 5.1 Crear `UserDetailsServiceImpl` en `com.mrando.azucardj.security` implementando `UserDetailsService`
- [x] 5.2 Implementar `loadUserByUsername()` usando `UserRepository.findByUsername()` y mapeando `roles` de `User` a `GrantedAuthority`
- [x] 5.3 Lanzar `UsernameNotFoundException` si el usuario no existe

## 6. Utilidades JWT

- [x] 6.1 Crear `JwtUtils` en `com.mrando.azucardj.auth` con `@Value` para `jwt.secret` y `jwt.expiration`
- [x] 6.2 Implementar `generateToken(UserDetails userDetails)` que firma el JWT con la clave secreta e incluye username y roles como claims
- [x] 6.3 Implementar `extractUsername(String token)` para obtener el subject del token
- [x] 6.4 Implementar `isTokenValid(String token, UserDetails userDetails)` que valide firma, expiración y coincidencia de username

## 7. Filtro JWT

- [x] 7.1 Crear `JwtAuthFilter` en `com.mrando.azucardj.auth` extendiendo `OncePerRequestFilter`
- [x] 7.2 Implementar `doFilterInternal()`: extraer el header `Authorization`, obtener el token Bearer, validarlo con `JwtUtils`, cargar el `UserDetails` y setear el `SecurityContextHolder`
- [x] 7.3 Si el header no está presente o el token es inválido, continuar la cadena de filtros sin autenticar

## 8. Servicio de autenticación

- [x] 8.1 Crear `AuthService` en `com.mrando.azucardj.auth`
- [x] 8.2 Implementar `login(LoginRequest request)`: autenticar con `AuthenticationManager`, generar JWT y retornar `AuthResponse`
- [x] 8.3 Implementar `register(User user)`: verificar que el username no exista, encriptar contraseña con `PasswordEncoder`, persistir con `UserRepository` y retornar el usuario creado (sin contraseña)

## 9. Controlador de autenticación

- [x] 9.1 Crear `AuthController` en `com.mrando.azucardj.auth` con `@RequestMapping("/auth")`
- [x] 9.2 Implementar `POST /auth/login` que delega a `AuthService.login()` y retorna HTTP 200 con `AuthResponse`
- [x] 9.3 Implementar `POST /auth/register` que delega a `AuthService.register()` y retorna HTTP 201; responder HTTP 409 si el username ya existe

## 10. Configuración de seguridad

- [x] 10.1 Actualizar `DatabaseWebSecurity`: inyectar `UserDetailsServiceImpl` y eliminar `JdbcUserDetailsManager`
- [x] 10.2 Exponer `AuthenticationManager` como `@Bean` usando `AuthenticationConfiguration`
- [x] 10.3 Actualizar `SecurityFilterChain`: deshabilitar CSRF, configurar sesión stateless (`SessionCreationPolicy.STATELESS`), añadir `JwtAuthFilter` antes de `UsernamePasswordAuthenticationFilter`
- [x] 10.4 En `SecurityFilterChain`, aplicar `permitAll()` para `/auth/**`, `/swagger-ui/**`, `/v3/api-docs/**` y `authenticated()` para el resto

## 11. Verificación

- [x] 11.1 Compilar el proyecto (`mvn compile`) sin errores
- [ ] 11.2 Verificar que `POST /auth/register` crea un usuario con contraseña BCrypt
- [ ] 11.3 Verificar que `POST /auth/login` devuelve un token JWT válido con credenciales correctas
- [ ] 11.4 Verificar que `GET /users` retorna HTTP 401 sin token y HTTP 200 con token válido en el header
- [ ] 11.5 Verificar que Swagger UI sigue siendo accesible sin autenticación
