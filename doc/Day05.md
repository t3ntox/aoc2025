# 🎄 Advent of Code 2025 – Day 5: Cafeteria

Cuando las carretillas elevadoras consiguen finalmente atravesar la pared, los Elfos descubren con alivio que **sí había una cafetería** al otro lado. Sin embargo, en la cocina reina el caos.

Un nuevo sistema de gestión de inventario, implementado justo antes de Navidad, ha hecho imposible distinguir entre ingredientes **frescos** y **estropeados**. Para salvar la situación, te entregan una copia completa de su base de datos.

---

## 🧩 Descripción del problema

El *input* consta de **dos secciones** separadas por una línea en blanco:

1. Una lista de **rangos de IDs de ingredientes frescos**.
2. Una lista de **IDs de ingredientes disponibles**.


### Reglas importantes

* Los rangos son **inclusivos** (`3-5` incluye 3, 4 y 5).
* Los rangos pueden **solaparse**.
* Un ingrediente se considera **fresco** si su ID pertenece a **al menos uno** de los rangos.

---

## 🌟 Parte 1 — Fresh Ingredients

**Objetivo:**

> Determinar cuántos de los IDs disponibles corresponden a ingredientes frescos.

---

## 🌟 Parte 2 — All Fresh IDs

En la segunda parte, los Elfos ya no necesitan comprobar ingredientes concretos. En su lugar, quieren saber **cuántos IDs distintos** consideran frescos los rangos del inventario.

En esta parte:

* La lista de ingredientes disponibles **ya no importa**.
* Un ID es fresco si pertenece a **cualquier rango**.
* Los rangos pueden solaparse y no deben contarse IDs repetidos.

**Objetivo:**

> Calcular cuántos IDs únicos son considerados frescos por el conjunto de rangos.

---

[▶ Ir al día 5](../src/main/java/software/aoc/day05)

---

## 🏗️ Estructura del día

```text
day05/
├─ a/
│  └─ IdLoader
│  └─ Main
├─ b/
│  └─ Main
├─ IdRange
├─ Loader
├─ RangeLoader
└─ RangeUnifier
```

- **IdRange**: clase inmutable que representa un rango de identificadores con límites inferior (`bottom`) y superior (`top`), proporcionando validación de pertenencia.
- **IdLoader**: clase responsable de cargar identificadores individuales desde el fichero de texto de entrada, parseando cada línea como un `Long`. 
- **RangeLoader**: clase responsable de cargar rangos de identificadores desde el fichero de texto de entrada, parseando pares de límites en objetos `IdRange`.
- **RangeUnifier**: clase que unifica y fusiona rangos superpuestos, ordenándolos y combinando aquellos que se solapan en intervalos continuos. 
- **Loader**: interfaz genérica que define el contrato para la carga de elementos de tipo `T`, permitiendo desacoplar el origen de los datos. 




## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Modelado explícito**: `IdRange` representa un intervalo válido con semántica clara.
- **Separación de parsing y lógica**: loaders manejan parsing, `RangeUnifier` la lógica de unificación.
- **Procesamiento por etapas**: cada etapa (carga, ordenación, unificación) tiene una responsabilidad específica.
- **Abstracción**: la interfaz genérica `Loader<T>` abstrae el origen de los datos.
- **Inmutabilidad**: `IdRange` es inmutable, reduciendo efectos colaterales.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `RangeLoader`: carga rangos desde fichero.
  - `IdLoader`: carga identificadores desde fichero.
  - `RangeUnifier`: unifica y fusiona rangos superpuestos.
- **Open / Closed Principle (OCP)**:
  - Nuevas estrategias de unificación pueden añadirse sin modificar las clases existentes.
- **Inversión de dependencias (DIP)**:
  - `RangeUnifier` depende de la abstracción `Loader<IdRange>`, no de implementaciones concretas.

### Patrones de diseño
- **Pipeline**:
  - Flujo de transformación: carga (`RangeLoader`) → ordenación → unificación (`RangeUnifier`).
- **Value Object**:
  - `IdRange` es un objeto de valor inmutable que encapsula un intervalo del dominio.
- **Generic/Template Pattern**:
  - `Loader<T>` es genérico, permitiendo reutilización para distintos tipos de datos.
