# Defensa: Interfaz Biblioteca

**Autor:** [Tu nombre]
**Asignatura:** POO
**Fecha:** 8 de noviembre de 2025

---

## Resumen (30s)
Presento una interfaz Swing para gestionar una biblioteca: alta/baja de socios y libros, préstamos y devoluciones. Mostraré diseño, problemas detectados, soluciones aplicadas y una demo en vivo que pruebe la sincronización de vistas.

---

## Estructura (10–12 min sugeridos)
- 1. Título + objetivo (30s)
- 2. Requerimientos funcionales (60s)
- 3. Arquitectura y componentes (90s)
- 4. Flujo de UI (90s)
- 5. Problemas detectados (90s)
- 6. Cambios aplicados y por qué (90s)
- 7. Demo en vivo (120s)
- 8. Pruebas / verificación (60s)
- 9. Limitaciones y mejoras futuras (60s)
- 10. Preguntas (resto)

---

## Diapositivas (texto para cada una)

### 1) Título
- Interfaz Biblioteca — Defensa
- Tu nombre, materia, fecha

### 2) Objetivo de la aplicación
- Gestionar libros y socios.
- Permitir préstamos y devoluciones con visualización inmediata.
- Requisitos no funcionales: app desktop (Swing), simple y didáctica.

### 3) Arquitectura y componentes principales
- `InterfazBiblioteca.java` — UI central (CardLayout).
- `Biblioteca.java` — Lógica de dominio (libros, socios, préstamos).
- Entidades: `Socio`, `Libro`, `Prestamo`.
- UI: `DefaultListModel`, `JList`, `JTextArea`, `JScrollPane`.

### 4) Flujo de interacción / pantallas
- Menu → Gestionar Libros / Gestionar Socios.
- GestionLibros: listar, quitar, ver quien tiene.
- GestionSocios: listar, seleccionar socio → opciones (pedir / ir a devolver).
- Devolver: lista de préstamos del socio y botón Devolver.
- CardLayout para navegación.

### 5) Problemas detectados
- Algunas pantallas no se actualizaban tras prestar/devolver.
- Causas:
  - Mezcla de modelos globales y locales.
  - Reutilización de `JScrollPane` que provocaba revalidaciones incorrectas.
  - `quienTieneElLibro()` y `catLibrosPrestados()` consideraban todo el historial.
  - Pantalla Devolver mostraba el historial completo y no se reconstruía desde el estado fresco.

### 6) Soluciones aplicadas
- `refrescarTodo()` central para actualizar modelos globales, títulos y `areaLibros`.
- `crearPantallaDevolverLibro` ahora:
  - Recupera el `Socio` fresco desde `biblioteca`.
  - Filtra solo préstamos activos (fechaDevolucion == null).
  - Reconstruye la pantalla tras una devolución.
- `Biblioteca.quienTieneElLibro(...)` y `Socio.catLibrosPrestados()` modificados para considerar solo préstamos activos.
- `scrollLibrosGestion` y `scrollSociosGestion` añadidos para evitar reasignaciones peligrosas.
- Uso de `revalidate()` y `repaint()` y reconstrucción de pantallas locales cuando es necesario.

### 7) Demo (guion)
1. Abrir app y mostrar `Menu`.
2. Ir a `GestionLibros`: mostrar cantidad de libros y título actualizado.
3. Ir a `GestionSocios`: seleccionar o crear un socio.
4. `Seleccionar Socio` → `Prestar Libro`: seleccionar libro disponible y pedirlo.
   - Observar: desaparece de disponibles, contador y `ListarLibros` actualizan, socio muestra +1 préstamos.
5. `Ir a devolver libro`: la pantalla Devolver lista sólo préstamos activos.
6. Devolver el libro:
   - Observar: libro desaparece de la lista Devolver, vuelve a listado de disponibles, contadores actualizan.

### 8) Pruebas y verificación
- Escenarios: prestar -> verificar en 3 vistas; devolver -> verificar lo mismo.
- Casos límite: devolver libro ya devuelto; intentar eliminar libro prestado; quitar socio con préstamos -> debe bloquear.

### 9) Limitaciones y mejoras futuras
- Implementar Observer para notificaciones automáticas de modelo -> vistas.
- Migrar a MVC: separar controladores y servicios.
- Añadir tests unitarios (JUnit) y pruebas de UI (AssertJ Swing).
- Evitar reconstrucción de paneles y preferir actualizar modelos.

### 10) Cierre
- Resumen: detecté problemas de sincronización, apliqué cambios no destructivos y verifiqué la coherencia en las vistas.

---

## Notas del orador (detalladas)

- Diapositiva 1 (10–20s): "Buenas, soy [tu nombre]..."

- Diapositiva 2 (40–60s): Explicar objetivo y contexto educativo.

- Diapositiva 3 (60–90s): Detallar clases y responsabilidades brevemente.

- Diapositiva 4 (60–90s): Mostrar navegación y CardLayout. Comentar sobre pantallas temporales por socio.

- Diapositiva 5 (60–90s): "Durante pruebas detectamos que al prestar o devolver, algunas pantallas no reflejaban el cambio...."

- Diapositiva 6 (60–90s): Explicar los cambios y por qué son seguros (no rompen APIs, minimizan cambios globales).

- Diapositiva 7 (demo, 2 min): Seguir el guion. Pedir al jurado que observe contadores y listados.

- Diapositiva 8 (60s): Mencionar escenarios probados y resultados.

- Diapositiva 9 (60s): Enumerar mejoras técnicas a futuro.

- Diapositiva 10: Invitá a preguntas.

---

## Preguntas frecuentes y respuestas (para ensayar)

1) ¿Por qué reconstruir pantallas en lugar de usar Observers?
- Respuesta corta: Corrección rápida y segura sin re-arquitectura; Observer es mejora a mediano plazo.

2) ¿Qué pasa con el EDT y la concurrencia?
- Respuesta corta: UI en EDT; operaciones de dominio rápidas. Si algo es costoso, mover a hilo en background.

3) ¿Fugas de memoria al recrear paneles?
- Respuesta corta: Eliminamos paneles con mismo nombre antes de añadir; ideal reutilizar modelos y paneles.

4) ¿Cómo testearías automáticamente?
- Respuesta corta: JUnit para dominio; AssertJ Swing para UI.

5) Mejoras para producción?
- Respuesta corta: MVC, persistencia, capas de servicio y pruebas.

---

## Checklist antes de la defensa (2 min)
- Abrir el proyecto en el IDE y compilar.
- Ejecutar la app (`InterfazBiblioteca.main`).
- Asegurar que hay al menos 1 socio y 1 libro disponible.
- Practicar demo una vez con cronómetro.

---

## Archivos a citar durante la defensa
- `tp7Integrador/InterfazBiblioteca.java`
- `tp7Integrador/Biblioteca.java`
- `tp7Integrador/Socio.java`

---

*Fin del documento.*
