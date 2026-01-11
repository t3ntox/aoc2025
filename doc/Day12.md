# 🎄 Advent of Code 2025 – Day 12: Christmas Tree Farm

Ya casi sin tiempo, te adentras por un conducto de ventilación que te lleva a una enorme caverna iluminada, repleta de **árboles de Navidad**. Aquí, los Elfos están preocupados por un problema muy concreto: **cómo colocar los regalos bajo los árboles sin que se queden sin espacio**.

Los regalos tienen formas extrañas y rígidas, y deben colocarse con cuidado siguiendo una **rejilla bidimensional**, sin apilarse ni solaparse.

---

## 🧩 Descripción del problema

El *input* se divide en **dos secciones** bien diferenciadas:

### 🎁 Formas de los regalos

Primero se listan las **formas estándar de los regalos**, cada una identificada por un índice numérico. Las formas se representan con caracteres:

* `#` indica una celda ocupada por el regalo
* `.` indica espacio vacío dentro de la plantilla

Las formas pueden **rotarse y voltearse**, pero siempre deben alinearse perfectamente con la rejilla.

---

### 🌲 Regiones bajo los árboles

La segunda parte describe las **regiones rectangulares** bajo cada árbol y los regalos que deben encajar en ellas.

Cada línea tiene el formato:

```text
<ancho>x<alto>: <cantidad forma 0> <cantidad forma 1> ...
```

Esto indica una región de 12×5 unidades donde deben colocarse:

* 1 regalo de la forma 0
* 1 regalo de la forma 2
* 3 regalos de la forma 4
* 2 regalos de la forma 5

---

## 🌟 Parte 1 — Fitting the Presents

El objetivo principal es determinar **en cuántas regiones es posible colocar todos los regalos requeridos**, cumpliendo las siguientes reglas:

* Los regalos **no pueden solaparse**
* Los regalos **no pueden salirse de la región**
* Los regalos **pueden rotarse y voltearse**
* Solo las celdas marcadas con `#` ocupan espacio

Cada región se evalúa de forma independiente.

En el ejemplo del enunciado, de las 3 regiones analizadas, **solo 2 pueden acomodar correctamente todos los regalos**.

🔍 **Objetivo:**

> Contar cuántas regiones permiten encajar todos los regalos listados.

---

## 🌟 Parte 2 — A Familiar Sight

La segunda parte del enunciado continúa la narrativa, con la llegada de más Elfos y la aparición mágica de estrellas sobre los árboles.

📌 **Nota:**

> En este día, la segunda parte **no introduce un nuevo problema computacional**. Resolver la Parte 1 es suficiente para completar el desafío.

---

[▶ Ir al día 12](../src/main/java/software/aoc/day12)

---

## 🏗️ Estructura del día

```text
day12/
├─ Cell
├─ Loader
├─ Main
├─ OffsetConverter
├─ PiecePlacer
├─ Present
├─ PresentRotator
├─ Region
├─ RegionFiller
├─ RegionValidator
├─ Situation
└─ SituationLoader
```

- **Cell**: clase inmutable que representa una coordenada (x, y) en una región.
- **Present**: clase inmutable que encapsula una forma (matriz 2D) de un presente/pieza, proporcionando métodos para obtener todas las rotaciones como offsets y calcular su área.
- **Region**: clase inmutable que representa una región con dimensiones y cantidad de presentes a colocar, proporcionando cálculo del área total.
- **PresentRotator**: clase que genera todas las rotaciones y reflexiones posibles de una forma (4 rotaciones × 2 orientaciones), retornando un conjunto de variantes.
- **OffsetConverter**: clase de utilidad que convierte una matriz de caracteres a una lista de `Cell` como offsets relativos.
- **PiecePlacer**: clase que determina si un conjunto de piezas/presentes puede colocarse en una región dada, utilizando un algoritmo de backtracking.
- **RegionFiller**: clase que rellena una región con presentes colocados, actualizando su estado.
- **RegionValidator**: clase que valida si un conjunto de presentes puede llenar completamente una región, verificando área y posibilidad de colocación.
- **Situation**: clase inmutable que encapsula una situación del problema (probablemente región y presentes).
- **SituationLoader**: clase responsable de cargar y transformar situaciones desde el fichero de texto de entrada, construyendo objetos `Situation`.
- **Loader**: interfaz que define el contrato para la carga de situaciones, permitiendo desacoplar el origen de los datos.

## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Modelado explícito del dominio**:
  - El problema se representa mediante conceptos claros del dominio:
  - `Present` como pieza con forma.
  - `Region` como área a rellenar.
  - `Cell` como unidad espacial inmutable.
  - `Situation` como agregado raíz del problema.
- **Inmutabilidad**:
  - `Cell`, `Present`, `Region` y `Situation` son objetos inmutables (`record`).
  - Las rotaciones generan nuevas estructuras sin modificar el estado original.
- **Abstracción**:
  - La interfaz `Loader` abstrae el origen de datos, ocultando detalles del parsing.
- **Separación de responsabilidades**:
  - `SituationLoader` se encarga únicamente del parsing.
  - `PresentRotator` gestiona transformaciones geométricas.
  - `OffsetConverter` traduce formas a offsets.
  - `PiecePlacer` contiene el algoritmo de backtracking.
  - `RegionValidator` valida la factibilidad lógica.
- **Diseño orientado a datos**:
  - El uso de `Cell` reemplaza estructuras primitivas (`int[]`), haciendo explícita la semántica espacial.
- **Claridad algorítmica**:
  - El flujo del algoritmo (validación → generación de piezas → backtracking) es directo y legible.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - Cada clase tiene una única razón para cambiar.
- **Open / Closed Principle (OCP)**:
  - Nuevas transformaciones, validaciones o estrategias de colocación pueden añadirse sin modificar las existentes.
- **Dependency Inversion Principle (DIP)**:
  - `SituationLoader` depende de la abstracción `Loader`.
- **Bajo acoplamiento**:
  - Las clases colaboran mediante datos simples (`List<Cell>`, `Region`, `Present`) sin dependencias innecesarias.
- **Alta cohesión**:
  - Cada clase agrupa lógica estrechamente relacionada con su propósito.
- **Eliminación de números mágicos**:
  - Las rotaciones están acotadas explícitamente a las transformaciones geométricas válidas (4 rotaciones + simetría).
- **Expresividad del código**:
  - El uso de `Cell` y métodos bien nombrados elimina ambigüedad semántica.

### Patrones de diseño
- **Backtracking**:
  - `PiecePlacer` implementa un algoritmo de búsqueda con retroceso para probar combinaciones válidas.
- **Value Object**:
  - `Cell`, `Region`, `Present` y `Situation` representan valores sin identidad propia.
- **Generator / Transformer**:
  - `PresentRotator` genera y transforma variantes válidas de una pieza mediante rotaciones y reflexiones.
- **Composite**:
  - Las piezas se componen de múltiples `Cell` que forman estructuras mayores.
- **Pipeline de transformación de datos**:
  - Forma → rotaciones → offsets → colocación en tablero, cada paso transformando datos sin efectos colaterales.

