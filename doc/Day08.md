# 🎄 Advent of Code 2025 – Day 8: Playground

You step off the teleporter and arrive in a vast underground playground, where the Elves are preparing an ambitious Christmas decoration project. Suspended throughout the space are many electrical junction boxes, waiting to be connected with strings of lights.

---

## 🧩 Descripción del problema

Each junction box is located at a specific point in **3D space**, given as `X,Y,Z` coordinates (your puzzle input). Most boxes do not provide electricity on their own, but once two junction boxes are connected by a string of lights, electricity can flow between them.

When junction boxes are connected directly or indirectly, they form a **circuit**.

To minimize the amount of string lights used, the Elves connect junction boxes by repeatedly choosing the **closest pair of boxes** according to straight-line (Euclidean) distance.

If two boxes that are already part of the same circuit are connected again, nothing changes.

---

## 🌟 Parte 1 — Building Circuits

The Elves first decide to connect together the **1000 closest pairs** of junction boxes.

As connections are added:

* Some circuits grow larger as boxes join together.
* Some connections may link boxes already in the same circuit and have no effect.

After making the 1000 shortest connections, you must:

> Determine the sizes of all resulting circuits and **multiply together the sizes of the three largest circuits**.

---

## 🌟 Parte 2 — One Big Circuit

Unfortunately, the Elves still don’t have enough extension cables. This time, they decide to keep connecting junction boxes until **all boxes belong to a single circuit**.

Connections are still made in order of increasing distance between junction boxes.

The final piece of information they need is related to the **last connection** that causes all junction boxes to merge into one circuit.

> Take the **X coordinates** of the two junction boxes connected in that final step and **multiply them together**.

---

[▶ Ir al día 8](../src/main/java/software/aoc/day08)

---

## 🏗️ Estructura del día

```text
day08/
├─ a/
│  └─ Main
├─ b/
│  └─ Main
├─ BoxConnector
├─ Circuit
├─ CircuitConnector
├─ CircuitLoader
├─ Loader
├─ PairBox
└─ Position
```

- **Position**: clase inmutable que representa una coordenada 2D (x, y) dentro del circuito.
- **Circuit**: clase inmutable que encapsula un conjunto de `Position` que forman un circuito eléctrico conectado.
- **PairBox**: clase que representa un par de posiciones/cajas, encapsulando la relación entre dos puntos.
- **BoxConnector**: clase que genera todas las combinaciones posibles de pares de posiciones desde un conjunto de circuitos, ordenándolas por distancia euclidiana.
- **CircuitConnector**: clase que conecta pares de posiciones en circuitos, fusionando circuitos cuando sus cajas se interconectan, y proporcionando métodos para analizar la estructura resultante. 
- **CircuitLoader**: clase responsable de cargar y transformar las coordenadas desde el fichero de texto de entrada, construyendo circuitos iniciales con un `Position` por línea. 
- **Loader**: interfaz que define el contrato para la carga de circuitos, permitiendo desacoplar el origen de los datos.


## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Composición de estructuras**: `Circuit` compone múltiples `Position` en una unidad coherente.
- **Inmutabilidad**: `Position` y `Circuit` son inmutables, garantizando consistencia del estado.
- **Uso de métricas geométricas**: ordenación por distancia euclidiana para optimizar conexiones.
- **Abstracción**: la interfaz `Loader` abstrae el origen de los datos.
- **Separación de conceptos**: modelo de datos (`Position`, `Circuit`) separado de lógica de conexión (`BoxConnector`, `CircuitConnector`).

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `Position`: representa una coordenada 2D.
  - `Circuit`: encapsula un conjunto de posiciones conectadas.
  - `BoxConnector`: genera pares de posiciones ordenados por distancia.
  - `CircuitConnector`: fusiona circuitos cuando sus cajas se interconectan.
  - `CircuitLoader`: carga datos desde fichero.
- **Open / Closed Principle (OCP)**:
  - Nuevas estrategias de conexión pueden añadirse sin modificar el modelo existente.
- **Dependency Inversion Principle (DIP)**:
  - `CircuitLoader` depende de la abstracción `Loader`.
- **Bajo acoplamiento**:
  - `BoxConnector` y `CircuitConnector` son independientes del origen de datos.
- **Alta cohesión**:
  - Cada clase agrupa comportamiento estrechamente relacionado.

### Patrones de diseño
- **Value Object**:
  - `Position` y `Circuit` representan valores del dominio sin identidad propia.
- **Builder implícito**:
  - Construcción progresiva de circuitos mediante fusión iterativa.
- **Greedy Algorithm**:
  - Selección de pares por distancia mínima euclidiana en `BoxConnector`.
- **Strategy Pattern (implícito)**:
  - La lógica de conexión podría abstraerse como estrategia intercambiable.

