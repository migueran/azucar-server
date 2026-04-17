## Why

Los modelos del paquete `com.mrando.azucardj.model` usan `Integer` (tipo wrapper) para los campos `id` y otros campos numéricos, cuando deberían usar tipos primitivos (`int`). Esto introduce boxing/unboxing innecesario, permite valores `null` donde semánticamente no corresponde, y reduce la claridad del código. Adicionalmente, se detectó un bug en `Item`: el campo `theme` está declarado como `Integer` pero tiene la anotación `@OneToOne(targetEntity = Theme.class)`, lo que es incorrecto.

## What Changes

- Cambiar el campo `id` de `Integer` a `int` en todos los modelos: `Artist`, `Contact`, `DjList`, `Genre`, `Item`, `Network`, `Profile`, `Role`, `Theme`, `User`, `Video`.
- Actualizar los getters y setters correspondientes a `id` en cada modelo.
- Cambiar `Item.initTime` e `Item.endTime` de `Integer` a `int`.
- Cambiar `User.status` de `Integer` a `int`.
- **BREAKING** Corregir `Item.theme` de `Integer` a `Theme` (es un bug: la anotación `@OneToOne` lo requiere de tipo `Theme`).

## Capabilities

### New Capabilities
- `model-primitive-types`: Refactorización del sistema de tipos en los modelos de dominio para usar tipos primitivos donde corresponde y corregir el tipo erróneo del campo `theme` en `Item`.

### Modified Capabilities
<!-- No hay specs existentes que cubran el comportamiento de tipos de los modelos -->

## Impact

- **Afecta**: Todos los archivos en `src/main/java/com/mrando/azucardj/model/` (11 clases).
- **Riesgo de ruptura**: El cambio de `Item.theme` de `Integer` a `Theme` es un breaking change interno que puede afectar a servicios, repositorios o controladores que accedan a ese campo.
- **Sin impacto en API REST**: Los endpoints no cambian su contrato externo (JSON), ya que los tipos primitivos se serializan igual que los wrappers.
- **Sin cambios de esquema de base de datos**: Los tipos de columna en MySQL no cambian.
