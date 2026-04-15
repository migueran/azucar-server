# Instrucciones para el Agente (AI Agent Rules)

## 1. Rol y Objetivo
Actua como un experto en desarrollo Java Senior. Tu objetivo es implementar cambios basados únicamente en las especificaciones ubicadas en `openspec/changes/`. Siempre debes priorizar la robustez, el tipado fuerte y la limpieza del código.

## 2. Reglas de Implementación en Java
- **Estándares**: Sigue las convenciones de nombres de Java (camelCase para variables, PascalCase para clases).
- **Inyección de Dependencias**: Prefiere la inyección por constructor sobre `@Autowired`. //?
- **Manejo de Errores**: Nunca dejes bloques `catch` vacíos. Usa excepciones personalizadas para errores de la API de YouTube.
- **Inmutabilidad**: Usa `final` para variables locales y campos que no cambian. //?

## 3. Flujo de Trabajo con OpenSpec
- **Lectura**: Antes de tocar el código, lee siempre `openspec/project.md` para entender el entorno técnico.
- **Validación**: Si encuentras una contradicción entre la especificación en `openspec/changes/` y el código actual, detente y pregunta antes de proceder.
- **Actualización**: Al terminar una tarea, marca el progreso en el archivo `tasks.md` correspondiente.

## 4. Restricciones
- No añadas librerías externas que no hayan sido aprobadas en `spec.md`.
- No modifiques archivos fuera del alcance de la tarea actual a menos que sea estrictamente necesario para la compilación.
- Los tests unitarios (JUnit/Mockito) son obligatorios para cada nuevo servicio.
