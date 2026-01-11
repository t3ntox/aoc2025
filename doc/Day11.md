# 🎄 Advent of Code 2025 – Day 11: Reactor

Tras escuchar una serie de pitidos alarmantes bajo la fábrica, desciendes por una escotilla hasta llegar a un enorme **reactor toroidal** que suministra energía a toda la instalación. Los Elfos acaban de instalar un nuevo *server rack*, pero algo va mal: el reactor no consigue comunicarse correctamente con él.

Para diagnosticar el problema, te entregan un listado de **dispositivos conectados entre sí**, junto con las salidas de cada uno. El flujo de datos es **unidireccional**, y el fallo parece depender de **rutas concretas** que siguen los datos a través del sistema.

---

## 🧩 Descripción del problema

El sistema está compuesto por dispositivos identificados por nombres cortos (como `aaa`, `bbb`, `out`, etc.). Cada línea del input describe un dispositivo y a qué otros dispositivos envía datos:

* Los datos **solo fluyen hacia adelante**, siguiendo las conexiones indicadas.
* No existen flujos inversos.
* El dispositivo inicial depende de la parte del problema.
* El dispositivo final siempre es `out`.

El objetivo es **analizar todas las rutas posibles** que siguen los datos bajo distintas condiciones.

---

## 🌟 Parte 1 — Paths to the Reactor

En la primera parte, debes centrarte en los caminos que siguen los datos **desde el dispositivo `you` hasta el dispositivo `out`**.

🔍 **Objetivo:**

> Encontrar **todas las rutas posibles** que conectan `you` con `out` siguiendo las conexiones del sistema.

Cada ruta es una secuencia válida de dispositivos conectados, sin retrocesos.

En el ejemplo del enunciado, existen **5 caminos distintos** desde `you` hasta `out`.

---

## 🌟 Parte 2 — Critical Signal Path

Con más análisis, los Elfos descubren que el fallo solo ocurre cuando el flujo de datos pasa **por dos dispositivos clave**:

* `dac` (digital-to-analog converter)
* `fft` (fast Fourier transform)

Ahora el punto de inicio cambia.

🔍 **Nuevo objetivo:**

> Encontrar **todas las rutas desde `svr` hasta `out`** que **pasen obligatoriamente por `dac` y `fft`**, en cualquier orden.

Aunque existen muchas rutas posibles entre `svr` y `out`, solo unas pocas cumplen esta condición adicional.

---

[▶ Ir al día 11](../src/main/java/software/aoc/day11)

---

## 🏗️ Estructura del día

```text
day11/
├─ a/
│  └─ Main
├─ b/
│  └─ Main
├─ Graph
├─ Loader
├─ PathCounter
├─ PathState
└─ TagLoader
```

- **Graph**: clase inmutable que encapsula un grafo dirigido como mapa de adyacencia, proporcionando acceso a los nodos vecinos de cada nodo.
- **PathState**: clase inmutable que representa el estado de un camino durante el recorrido, incluyendo el nodo actual y flags de visitación (`dacVisited`, `fftVisited`), con métodos factory para diferentes condiciones iniciales.
- **PathCounter**: clase que cuenta todos los caminos válidos desde un nodo origen, utilizando recursión con memoización, soportando dos estrategias: permitir todos los nodos o requerir visita de `dac` y `fft`.
- **TagLoader**: clase responsable de cargar el grafo desde el fichero de texto de entrada, parseando líneas en pares nodo-vecinos y construyendo la estructura de adyacencia.
- **Loader**: interfaz que define el contrato para la carga de grafos, permitiendo desacoplar el origen de los datos.

## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Modelado del dominio**: el problema se representa explícitamente mediante un grafo dirigido (`Graph`) y un estado de recorrido (`PathState`).
- **Inmutabilidad**:
  - `Graph` realiza una copia defensiva de la estructura de adyacencia para evitar mutaciones externas.
  - `PathState` es una clase inmutable (campos `final`, sin mutadores) con factorías estáticas que controlan su creación, manteniendo semántica de valor.
- **Separación de conceptos**:
  - El grafo solo conoce relaciones entre nodos (`childrenOf`).
  - El conteo de caminos se delega a `PathCounter`, separado de la carga de datos y del modelo del grafo.
- **Abstracción**:
  - El origen de los datos se abstrae mediante la interfaz `Loader`, que oculta el detalle de cómo se construye el `Graph`.
- **Claridad algorítmica**:
  - El algoritmo recursivo expresa de forma directa el problema del conteo de caminos y su estado, haciendo el flujo fácil de seguir.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `Graph`: representa la estructura del grafo y sus relaciones.
  - `PathCounter`: contiene la lógica de conteo de caminos.
  - `PathState`: encapsula el estado lógico de un recorrido (nodo y tags visitados).
  - `TagLoader`: se encarga exclusivamente del parsing del input y construcción del grafo.
- **Open / Closed Principle (OCP)**:
  - Nuevas variantes de conteo o reglas de validación pueden añadirse extendiendo `PathCounter` (nuevos métodos) o evolucionando `PathState` sin modificar `Graph` ni `TagLoader`.
- **Bajo acoplamiento**:
  - `PathCounter` depende de `Graph` y no del origen de datos, que queda aislado en `Loader`/`TagLoader`.
- **Alta cohesión**:
  - Cada clase agrupa responsabilidades estrechamente relacionadas: estructura, estado, conteo o carga de datos.

### Patrones de diseño
- **Dynamic Programming / Memoization**:
  - El método `count` implementa programación dinámica top-down sobre el grafo, almacenando resultados por `PathState` en una caché para evitar recomputaciones.
- **Value Object**:
  - `PathState` actúa como objeto de valor inmutable, representando un estado del dominio sin identidad propia.
- **Graph Traversal (DFS)**:
  - El conteo se basa en un recorrido en profundidad (DFS) del grafo dirigido a partir de un nodo inicial.
- **Factory Method**:
  - `PathState` encapsula la creación del estado inicial del camino a través de métodos estáticos (`startRequiringDacFft`, `startAllowingAll`), evitando la construcción directa y haciendo más expresivas las intenciones.
