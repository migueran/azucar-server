## 1. Refactorizar campo `id` en todos los modelos

- [x] 1.1 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Artist`
- [x] 1.2 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Contact`
- [x] 1.3 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `DjList`
- [x] 1.4 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Genre`
- [x] 1.5 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Item`
- [x] 1.6 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Network`
- [x] 1.7 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Profile`
- [x] 1.8 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Role`
- [x] 1.9 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Theme`
- [x] 1.10 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `User`
- [x] 1.11 Cambiar `id` de `Integer` a `int` y actualizar getter/setter en `Video`

## 2. Refactorizar otros campos numéricos en modelos

- [x] 2.1 Cambiar `Item.initTime` de `Integer` a `int` y actualizar getter/setter
- [x] 2.2 Cambiar `Item.endTime` de `Integer` a `int` y actualizar getter/setter
- [x] 2.3 Cambiar `User.status` de `Integer` a `int` y actualizar getter/setter

## 3. Corregir bug: `Item.theme` debe ser de tipo `Theme`

- [x] 3.1 Cambiar `Item.theme` de `Integer` a `Theme`
- [x] 3.2 Actualizar `getIdTheme()` para retornar `Theme` en lugar de `Integer`
- [x] 3.3 Actualizar `setIdTheme()` para recibir `Theme` en lugar de `Integer`
- [x] 3.4 Buscar y actualizar todos los usos de `item.getIdTheme()` y `item.setIdTheme()` en servicios y controladores

## 4. Verificación

- [ ] 4.1 Compilar el proyecto (`mvn compile`) y verificar que no haya errores de compilación
- [ ] 4.2 Verificar que el contexto de Spring Boot levanta correctamente (`mvn spring-boot:run` o tests de integración)
