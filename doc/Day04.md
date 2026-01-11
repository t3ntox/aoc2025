# 🎄 Advent of Code 2025 – Day 4: Printing Department

Desciendes por la escalera mecánica hasta el **departamento de impresión**. Todo está listo para la Navidad: enormes rollos de papel por todas partes y una impresora gigantesca en una esquina.

Sin embargo, los ascensores siguen fuera de servicio. Los Elfos creen que hay una cafetería al otro lado de la pared trasera, pero no tienen tiempo para abrirse paso: sus carretillas elevadoras están ocupadas moviendo papel. Si consigues **optimizar su trabajo**, quizá puedan liberar tiempo para derribar la pared.

---

## 🧩 Descripción del problema

El input es un **mapa bidimensional** que representa la disposición de los rollos de papel:

* `@` → un rollo de papel
* `.` → espacio vacío

Las carretillas elevadoras pueden **acceder a un rollo de papel** si en sus **ocho posiciones adyacentes** (incluyendo diagonales) hay **menos de cuatro** rollos de papel.

El objetivo es determinar qué rollos cumplen esta condición.

---

## 🌟 Parte 1 — Accessible Rolls

En la primera parte, debes identificar **qué rollos de papel son accesibles** por una carretilla elevadora según la regla anterior.

Un rollo es accesible si:

> Tiene **menos de cuatro** rollos de papel en las ocho posiciones que lo rodean.

**Objetivo:**

> Contar cuántos rollos de papel pueden ser accedidos inicialmente por una carretilla elevadora.

---

## 🌟 Parte 2 — Cascading Removal

Una vez que un rollo de papel es accesible, puede ser **retirado**. Al retirarlo, el entorno cambia y otros rollos pueden volverse accesibles.

Este proceso se repite:

1. Identificar rollos accesibles.
2. Retirarlos del mapa.
3. Repetir hasta que no quede ningún rollo accesible.

**Objetivo:**

> Simular el proceso completo y contar cuántos rollos de papel pueden retirarse en total.

---

[▶ Ir al día 4](../src/main/java/software/aoc/day04)

---

## 🏗️ Estructura del día

```text
day04/
├─ a/
│  └─ Main
├─ b/
│  └─ Main
│  └─ RemoveChecker
├─ AccessChecker
├─ AccessRule
├─ FourConnectedAccessRule
├─ Grid
├─ Loader
└─ PaperLoader
```

- **Grid**: clase inmutable que representa una matriz 2D de caracteres, encapsulando operaciones de adición y eliminación de elementos. 
- **AccessRule**: interfaz que define el contrato para determinar si una posición en la cuadrícula es accesible según una regla específica. 
- **FourConnectedAccessRule**: implementación de `AccessRule` que verifica si una posición es accesible cuando tiene exactamente 4 papeleras adyacentes conectadas.
- **AccessChecker**: clase que verifica qué posiciones en la cuadrícula son accesibles según una regla, contando y acumulando las disponibles.
- **RemoveChecker**: clase que simula la eliminación iterativa de papeleras accesibles, contando cuántas pueden ser removidas hasta que ninguna más sea accesible.
- **PaperLoader**: clase responsable de cargar y transformar las líneas desde el fichero de texto de entrada, construyendo la matriz en un `Grid`. 
- **Loader**: interfaz que define el contrato para la carga de cuadrículas, permitiendo desacoplar el origen de los datos. 




## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Inmutabilidad estructural**: `Grid` devuelve nuevas instancias al modificarse, reduciendo efectos colaterales.
- **Separación de reglas y datos**: reglas de acceso (`AccessRule`) desacopladas del modelo del grid.
- **Abstracción**: la interfaz `AccessRule` abstrae la lógica de accesibilidad, ocultando detalles específicos.
- **Composición sobre herencia**: se usa composición para inyectar estrategias en lugar de herencia.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `Grid`: representa el estado del tablero.
  - `AccessRule`: define la regla de accesibilidad.
  - `AccessChecker`: evalúa qué posiciones son accesibles.
  - `RemoveChecker`: simula el proceso iterativo de eliminación.
- **Open / Closed Principle (OCP)**:
  - Nuevas reglas de acceso se añaden implementando `AccessRule` sin modificar las clases existentes.
- **Bajo acoplamiento**:
  - `AccessChecker` y `RemoveChecker` dependen de la abstracción `AccessRule`, no de implementaciones concretas.
- **Inversión de dependencias (DIP)**:
  - Los checkers dependen de la interfaz `AccessRule`, no de sus implementaciones.

### Patrones de diseño
- **Strategy**:
  - `AccessRule` define distintas estrategias de acceso (`FourConnectedAccessRule` para parte 1, potencialmente otras para parte 2).
- **Value Object (Grid)**:
  - `Grid` actúa como un objeto de valor inmutable que encapsula la matriz bidimensional.
