## ADDED Requirements

### Requirement: Los campos `id` de los modelos deben usar tipo primitivo `int`
Todos los modelos JPA en `com.mrando.azucardj.model` SHALL declarar su campo `id` como `int` en lugar de `Integer`. Los getters y setters correspondientes SHALL actualizarse para retornar y recibir `int`.

#### Scenario: Campo id declarado como primitivo
- **WHEN** se inspecciona cualquier clase del paquete `model` (Artist, Contact, DjList, Genre, Item, Network, Profile, Role, Theme, User, Video)
- **THEN** el campo `id` SHALL estar declarado como `int` y sus getters/setters SHALL usar `int`

### Requirement: Los campos numéricos de `Item` deben usar tipo primitivo `int`
Los campos `initTime` y `endTime` de la clase `Item` SHALL estar declarados como `int` en lugar de `Integer`. Los getters y setters SHALL actualizarse correspondientemente.

#### Scenario: initTime y endTime son primitivos en Item
- **WHEN** se inspecciona la clase `Item`
- **THEN** `initTime` y `endTime` SHALL ser de tipo `int` y sus getters/setters SHALL usar `int`

### Requirement: El campo `status` de `User` debe usar tipo primitivo `int`
El campo `status` de la clase `User` SHALL estar declarado como `int` en lugar de `Integer`. El getter y setter SHALL actualizarse correspondientemente.

#### Scenario: status es primitivo en User
- **WHEN** se inspecciona la clase `User`
- **THEN** `status` SHALL ser de tipo `int` y su getter/setter SHALL usar `int`

### Requirement: El campo `theme` de `Item` debe ser de tipo `Theme`
El campo `theme` de la clase `Item` SHALL estar declarado como `Theme` (entidad JPA) en lugar de `Integer`, en coherencia con la anotación `@OneToOne(targetEntity = Theme.class)` existente. El getter SHALL retornar `Theme` y el setter SHALL recibir `Theme`.

#### Scenario: theme es de tipo Theme en Item
- **WHEN** se inspecciona la clase `Item`
- **THEN** el campo `theme` SHALL ser de tipo `Theme`
- **THEN** el getter `getIdTheme()` SHALL retornar `Theme`
- **THEN** el setter `setIdTheme(Theme idTheme)` SHALL recibir un parámetro de tipo `Theme`
