## Context

El paquete `com.mrando.azucardj.model` contiene 11 entidades JPA. Todos los campos `id` están declarados como `Integer` (wrapper), lo que permite valores `null` innecesariamente y añade boxing/unboxing automático en cada acceso. Además, el campo `theme` en `Item` está declarado como `Integer` pero tiene la anotación `@OneToOne(targetEntity = Theme.class)`, lo que es un bug: JPA no puede mapear una relación de entidad a un tipo escalar.

## Goals / Non-Goals

**Goals:**
- Cambiar `id` de `Integer` a `int` en los 11 modelos del paquete.
- Cambiar `Item.initTime` e `Item.endTime` de `Integer` a `int`.
- Cambiar `User.status` de `Integer` a `int`.
- Corregir `Item.theme` de `Integer` a `Theme` (corrección de bug).
- Actualizar todos los getters y setters afectados.

**Non-Goals:**
- No se modificará el esquema de base de datos (los tipos de columna no cambian).
- No se cambiará el contrato de la API REST (la serialización JSON de primitivos y wrappers es idéntica).
- No se agregarán validaciones adicionales (p. ej. `@NotNull`, `@Positive`).
- No se refactorizarán clases fuera de `model/` en esta iteración.

## Decisions

### Usar `int` en lugar de `long` para `id`
Los IDs actuales son `Integer`, y el esquema MySQL usa columnas INT. Cambiar a `long`/`Long` requeriría cambios en el esquema de base de datos y en todos los repositorios. Se mantiene `int` para minimizar el alcance del cambio.

_Alternativa considerada_: `long` — descartada por implicar cambios de esquema fuera de alcance.

### Corregir `Item.theme` a tipo `Theme`
El campo `theme` tiene `@OneToOne(targetEntity = Theme.class)` y `@JoinColumn(name = "id_theme")`, lo que indica claramente que debe ser de tipo `Theme`. Declararlo como `Integer` impide que JPA resuelva la relación correctamente.

_Alternativa considerada_: Remover la anotación y manejar el FK manualmente — descartada por romper la intención del diseño ORM.

### `User.status` permanece como `int` (no `boolean`)
El campo `status` puede representar múltiples estados (activo, inactivo, suspendido, etc.), por lo que un `boolean` sería insuficiente. Se mantiene como entero primitivo.

## Risks / Trade-offs

- **[Risk] Uso de `int` primitivo en JPA**: JPA puede manejar `int` primitivo para `@Id` con `GenerationType.IDENTITY` sin problemas en Spring Boot / Hibernate. Sin embargo, antes de la primera persistencia el id valdrá `0`, lo que podría confundirse con un id válido.  
  → _Mitigación_: No hay lógica que use `id == 0` como condición; el riesgo es bajo.

- **[Risk] `Item.theme` cambia de `Integer` a `Theme`**: Cualquier código que llame a `item.getIdTheme()` esperando un `Integer` deberá actualizarse.  
  → _Mitigación_: Buscar y actualizar todos los usos en servicios y controladores como parte de esta tarea.

- **[Trade-off] Boxeo automático eliminado**: Eliminar `Integer` puede romper comparaciones `== null` en código existente.  
  → _Mitigación_: Revisar que no haya comprobaciones de nulidad sobre `id` en capas de servicio.
