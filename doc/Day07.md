# 🎄 Advent of Code 2025 – Day 7: Laboratories

You thank the cephalopods for the help and exit the trash compactor, finding yourself in the familiar halls of a North Pole research wing. Based on the large sign that says **"teleporter hub"**, it seems the Elves have been experimenting with teleportation… and something has gone wrong.

---

## 🧩 Descripción del problema

El laboratorio contiene un **manifold de taquiones** representado como una cuadrícula (tu *puzzle input*).

* El haz de taquiones entra por la posición marcada con `S`.
* Los haces **siempre se mueven hacia abajo**.
* El espacio vacío (`.`) no afecta al haz.
* Un **splitter** (`^`) detiene el haz entrante y genera **dos nuevos haces**:

    * Uno continúa desde la **izquierda inmediata** del splitter.
    * Otro continúa desde la **derecha inmediata** del splitter.

El proceso se repite hasta que todos los haces alcanzan un splitter o salen del manifold.

---

## 🌟 Parte 1 — Classical Tachyon Manifold

En la primera parte, el objetivo es **contar cuántas veces se produce una división de haz**.

Cada vez que un haz encuentra un splitter (`^`) y genera nuevos haces, se cuenta **una división**, incluso si varios haces acaban coincidiendo en la misma posición más adelante.

En el ejemplo proporcionado en el enunciado, tras simular completamente el recorrido del haz, se producen **21 divisiones** en total.

**Objetivo:**

> Analizar el diagrama del manifold y contar el número total de veces que un haz es dividido.

---

## 🌟 Parte 2 — Quantum Tachyon Manifold

Al desmontar el teletransportador, descubres que el manifold no es clásico, sino **cuántico**.

En este nuevo modelo:

* Solo **una partícula de taquión** entra en el manifold.
* Al llegar a un splitter, la partícula toma **ambos caminos simultáneamente**.
* Según la interpretación de *many-worlds*, **el tiempo se divide** en dos líneas temporales distintas:

    * En una, la partícula va a la izquierda.
    * En la otra, va a la derecha.

Cada splitter **duplica las líneas temporales activas**, pero diferentes trayectorias pueden acabar en la misma posición final.

El objetivo ahora no es contar divisiones, sino **contar cuántas líneas temporales distintas existen al final del recorrido completo**.

En el ejemplo del enunciado, el resultado final es **40 timelines diferentes**.

**Objetivo:**

> Aplicar la interpretación cuántica y calcular el número total de timelines posibles tras completar todos los recorridos.

---

[▶ Ir al día 7](../src/main/java/software/aoc/day07)

---

## 🏗️ Estructura del día

```text
day06/
├─ a/
│  └─ BFSBeamStrategy
│  └─ Main
├─ b/
│  └─ DPBeamStrategy
│  └─ Main
├─ BeamStrategy
├─ Loader
├─ TachyonLoader
└─ TachyonManifold
```

- **TachyonManifold**: clase inmutable que representa una matriz bidimensional de caracteres, encapsulando la manifestación/rejilla y proporcionando métodos para construirla de forma incremental.
- **BeamStrategy**: interfaz que define el contrato para distintas estrategias de búsqueda/recorrido sobre la manifestación.
- **BFSBeamStrategy**: implementación de `BeamStrategy` que utiliza búsqueda en amplitud (BFS) para recorrer la manifestación.
- **DPBeamStrategy**: implementación de `BeamStrategy` que utiliza programación dinámica (DP) para calcular caminos en la manifestación.
- **TachyonLoader**: clase responsable de cargar y transformar líneas desde el fichero de texto de entrada, construyendo la manifestación de forma incremental en un `TachyonManifold`.
- **Loader**: interfaz que define el contrato para la carga de manifestaciones, permitiendo desacoplar el origen de los datos.


## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Modelado matemático explícito**: `TachyonManifold` representa una grid bidimensional de caracteres con semántica clara.
- **Inmutabilidad del estado del manifold**: `TachyonManifold` es inmutable, garantizando que transformaciones no afecten el estado original.
- **Abstracción**: la interfaz `BeamStrategy` abstrae los algoritmos de búsqueda, ocultando detalles específicos de BFS y DP.
- **Algoritmos intercambiables**: la separación permite usar distintas estrategias sin modificar el modelo.
- **Separación de conceptos**: `TachyonLoader` está completamente desacoplado del dominio y las estrategias.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `TachyonManifold`: representa y encapsula el estado de la manifestación.
  - `BeamStrategy`: define el contrato de algoritmos de recorrido.
  - `BFSBeamStrategy`: implementa búsqueda en amplitud.
  - `DPBeamStrategy`: implementa programación dinámica.
  - `TachyonLoader`: se encarga de la carga de datos.
- **Open / Closed Principle (OCP)**:
  - Nuevas estrategias de búsqueda pueden añadirse implementando `BeamStrategy` sin tocar el dominio.
- **Dependency Inversion Principle (DIP)**:
  - Las implementaciones de `BeamStrategy` dependen de la abstracción, no de clases concretas.
- **Bajo acoplamiento**:
  - Estrategias independientes del loader y del modelo.
- **Alta cohesión**:
  - Cada clase agrupa comportamiento estrechamente relacionado.

### Patrones de diseño
- **Strategy**:
  - `BFSBeamStrategy` y `DPBeamStrategy` implementan distintas estrategias de recorrido intercambiables.
- **Dynamic Programming**:
  - Implementado explícitamente en `DPBeamStrategy` para optimización.
- **Value Object**:
  - `TachyonManifold` es un objeto de valor inmutable que encapsula la grid.
- **Builder Pattern (ligero)**:
  - `TachyonManifold` se construye incrementalmente mediante el método `with()`, permitiendo composición fluida.

