# 🎄 Advent of Code 2025 – Day 9: Movie Theater

Tras deslizarte por el tubo de bomberos del playground, aterrizas directamente en el **cine de la base del Polo Norte**. El suelo está cubierto por un enorme mosaico de baldosas cuadradas, y los Elfos están en pleno proceso de redecoración.

Algunas baldosas son **rojas**, y los Elfos quieren aprovecharlas para crear el **rectángulo más grande posible** usando baldosas rojas como esquinas opuestas.

---

## 🧩 Descripción del problema

El suelo del cine forma una gran **rejilla 2D**. Tu input consiste en una lista de coordenadas `X,Y` que indican la posición de las baldosas **rojas** dentro de la rejilla.

Puedes elegir **cualquier par de baldosas rojas** como esquinas opuestas de un rectángulo (no necesariamente alineado con otras baldosas rojas). El área del rectángulo se calcula como:

```
(ancho) × (alto)
```

El objetivo es encontrar el **rectángulo de mayor área posible**.

---

## 🌟 Parte 1 — Largest Red-Corner Rectangle

En la primera parte, **solo importa que las esquinas opuestas sean rojas**. El interior del rectángulo puede contener cualquier tipo de baldosa.

Esto significa que basta con:

* Probar pares de baldosas rojas
* Considerarlas como esquinas opuestas
* Calcular el área del rectángulo que forman
* Quedarse con el máximo

**Objetivo:**

> Encontrar el área máxima de un rectángulo cuyos vértices opuestos sean baldosas rojas.

---

## 🌟 Parte 2 — Red & Green Constraint

En la segunda parte, los Elfos recuerdan una restricción importante: **solo se pueden cambiar baldosas rojas o verdes**.

Las reglas adicionales son:

* Cada baldosa roja está conectada con la anterior y la siguiente de la lista mediante una **línea recta de baldosas verdes**.
* La lista es circular (la primera y la última también están conectadas).
* Las conexiones siempre son **horizontales o verticales**.
* Todas las baldosas **dentro del bucle cerrado** formado por rojas y verdes también son verdes.

Ahora, el rectángulo:

* Debe seguir teniendo **baldosas rojas en esquinas opuestas**
* **Solo puede contener baldosas rojas o verdes** en su interior

Esto reduce drásticamente el número de rectángulos válidos.

**Objetivo:**

> Encontrar el área máxima de un rectángulo válido formado únicamente por baldosas rojas y verdes.

---

[▶ Ir al día 9](../src/main/java/software/aoc/day09)

---

## 🏗️ Estructura del día

```text
day09/
├─ a/
│  └─ Main
├─ b/
│  └─ Main
├─ AreaCalculator
├─ Loader
├─ Point
├─ PointLoader
├─ Rectangle
└─ RectangleProvider
```

- **Point**: clase inmutable que representa una coordenada 2D (x, y) en el plano.
- **Rectangle**: clase inmutable que representa un rectángulo definido por dos puntos, proporcionando cálculos de área, dimensiones y propiedades geométricas.
- **RectangleProvider**: clase que genera todas las combinaciones posibles de rectángulos a partir de una lista de puntos, proporcionándolos como un stream.
- **AreaCalculator**: clase que calcula el área máxima válida entre rectángulos, verificando condiciones de validez geométrica como intersecciones de bordes y contención de puntos.
- **PointLoader**: clase responsable de cargar y transformar coordenadas desde el fichero de texto de entrada, construyendo objetos `Point` parsea línea.
- **Loader**: interfaz que define el contrato para la carga de puntos, permitiendo desacoplar el origen de los datos.


## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Modelado geométrico**: `Point` y `Rectangle` modelan conceptos geométricos del dominio.
- **Separación generación / validación**: `RectangleProvider` genera candidatos, `AreaCalculator` valida y calcula.
- **Inmutabilidad del dominio**: `Point` y `Rectangle` son inmutables, garantizando consistencia.
- **Abstracción**: la interfaz `Loader` abstrae el origen de datos.
- **Separación de conceptos**: modelo de datos separado de lógica de generación y validación.
- **Código expresivo**: métodos como `isValidRectangle`, `isPointInPolygon` hacen el propósito explícito.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `Point` y `Rectangle`: representan geometría.
  - `RectangleProvider`: genera todas las combinaciones de rectángulos.
  - `AreaCalculator`: valida rectángulos y calcula el área máxima.
  - `PointLoader`: carga datos desde fichero.
- **Open / Closed Principle (OCP)**:
  - Nuevos proveedores de rectángulos pueden añadirse sin modificar `AreaCalculator`.
  - Nuevas reglas de validación pueden agregarse extendiendo `AreaCalculator`.
- **Dependency Inversion Principle (DIP)**:
  - `AreaCalculator` depende de la abstracción `RectangleProvider`.
  - `PointLoader` depende de la interfaz `Loader`.
- **Bajo acoplamiento**:
  - Las clases colaboran a través de abstracciones e interfaces.
- **Alta cohesión**:
  - Cada clase agrupa comportamiento estrechamente relacionado.
- **Encapsulación**:
  - La lógica geométrica vive en sus clases específicas (`Rectangle`, `AreaCalculator`).

### Patrones de diseño
- **Value Object**:
  - `Point` y `Rectangle` representan valores inmutables del dominio.
- **Provider Pattern (implícito)**:
  - `RectangleProvider` encapsula la generación de candidatos.
- **Pipeline**:
  - Flujo: carga de puntos → generación de rectángulos → filtrado y validación → cálculo de área máxima.

