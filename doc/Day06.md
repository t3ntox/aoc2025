# 🎄 Advent of Code 2025 – Day 6: Trash Compactor

Después de ayudar en la cocina, decides tomarte un descanso… pero acabas saltando con demasiado entusiasmo al **conducto de basura**. Tras una breve caída, despiertas dentro de una trituradora de residuos con la puerta sellada magnéticamente.

Mientras una familia de cefalópodos trabaja para abrir la salida, te piden ayuda con los **deberes de matemáticas** del más joven. Parece matemáticas normales… aunque presentadas de una forma bastante peculiar.

---

## 🧩 Descripción del problema

El *input* es una **hoja de ejercicios de matemáticas** representada como un bloque de texto muy ancho.

* Contiene varios **problemas colocados horizontalmente**.
* Cada problema está formado por varios números dispuestos **en vertical**.
* En la parte inferior de cada problema aparece el **operador**:

    * `+` para suma
    * `*` para multiplicación
* Los problemas están separados entre sí por **una columna completamente vacía**.
* La alineación horizontal de los números no es relevante.

Cada columna de números junto con su operador forma un problema independiente.

---

## 🌟 Parte 1 — Left-to-Right Math

En la primera parte, los problemas se leen **de arriba hacia abajo**, tomando los números tal como aparecen en cada columna.

**Objetivo:**

> Resolver todos los problemas y calcular la **suma total** de sus resultados.

---

## 🌟 Parte 2 — Cephalopod Math (Right-to-Left)

Los cefalópodos regresan y aclaran el error: su sistema de numeración se lee **de derecha a izquierda por columnas**.

En esta nueva interpretación:

* Cada **columna vertical representa un número**.
* El dígito más significativo está **arriba**.
* El dígito menos significativo está **abajo**.
* Los problemas siguen separados por columnas vacías.

**Objetivo:**

> Reinterpretar la hoja de ejercicios según las reglas cefalópodo y calcular la **nueva suma total**.

---

[▶ Ir al día 6](../src/main/java/software/aoc/day06)

---

## 🏗️ Estructura del día

```text
day06/
├─ a/
│  └─ Main
│  └─ StandardOperationParser
├─ b/
│  └─ Main
│  └─ ReverseOperationParser
├─ Loader
├─ Operation
├─ OperationLoader
├─ OperationParser
└─ Operator
```

- **Operation**: clase inmutable que representa una operación con un conjunto de operandos (strings) y un operador (`+` o `*`).
- **OperationParser**: interfaz que define el contrato para parsear líneas de texto en operaciones, permitiendo distintas estrategias de parsing. 
- **StandardOperationParser**: implementación de `OperationParser` que parsea operaciones en orden estándar.
- **ReverseOperationParser**: implementación de `OperationParser` que parsea operaciones invirtiendo el orden de los operandos.
- **OperationFinder**: clase de utilidad que encapsula la lógica de búsqueda y transformación de problemas (tokenización y transposición de matriz).
- **Operator**: clase que ejecuta operaciones evaluando cada una según su operador, sumando los resultados finales.
- **OperationLoader**: clase responsable de cargar y transformar las operaciones desde el fichero de texto, delegando el parsing a una estrategia inyectada.
- **Loader**: interfaz que define el contrato para la carga de operaciones, permitiendo desacoplar el origen de los datos.

---

## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Modelado explícito del dominio**:
  - `Operation` representa una operación aritmética con operandos y operador claramente separados.
  - El parsing y la ejecución están desacoplados conceptualmente.
- **Separación de conceptos**:
  - `OperationLoader` se encarga solo de la carga de datos.
  - `OperationParser` define la abstracción de parsing.
  - `StandardOperationParser` y `ReverseOperationParser` encapsulan variaciones del algoritmo.
  - `OperationFinder` centraliza utilidades comunes de parsing estructural.
  - `Operator` ejecuta la lógica de negocio.
- **Inmutabilidad**:
  - `Operation` es un objeto inmutable (`record`), reduciendo efectos colaterales.
- **Abstracción**:
  - La interfaz `OperationParser` abstrae las estrategias de parsing, ocultando detalles específicos.
- **Código expresivo**:
  - El flujo es lineal y explícito: carga → parseo → ejecución.
- **Reutilización de lógica común**:
  - `OperationFinder` evita duplicación de código entre parsers.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - Cada clase tiene una responsabilidad bien delimitada.
- **Open / Closed Principle (OCP)**:
  - Nuevos formatos de parsing pueden añadirse creando nuevas implementaciones de `OperationParser` sin modificar el resto del sistema.
- **Liskov Substitution Principle (LSP)**:
  - `StandardOperationParser` y `ReverseOperationParser` pueden sustituirse intercambiablemente sin afectar a `OperationLoader`.
- **Dependency Inversion Principle (DIP)**:
  - `OperationLoader` depende de la abstracción `OperationParser`, no de implementaciones concretas.
- **Bajo acoplamiento**:
  - Las clases colaboran mediante interfaces y estructuras simples.
- **Alta cohesión**:
  - Cada clase agrupa comportamiento estrechamente relacionado.
- **DRY (Don't Repeat Yourself)**:
  - La lógica compartida de extracción y transposición se centraliza en `OperationFinder`.

### Patrones de diseño
- **Strategy**:
  - `OperationParser` actúa como estrategia intercambiable de parsing.
- **Pipeline / Stream Processing**:
  - Uso de streams para transformar datos paso a paso de forma declarativa.
- **Value Object**:
  - `Operation` representa un valor del dominio sin identidad propia.
