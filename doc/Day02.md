# 🎄 Advent of Code 2025 – Day 2: Gift Shop

Después de entrar al Polo Norte, tomas el ascensor hasta su única parada adicional: la **tienda de regalos**. Mientras exploras la sorprendentemente extensa selección, uno de los dependientes te reconoce y te pide ayuda.

Al parecer, uno de los Elfos más jóvenes estuvo jugando con un ordenador de la tienda y terminó añadiendo **IDs de producto inválidos** a la base de datos. Tu misión es encontrarlos antes de que causen problemas mayores.

---

## 🧩 Descripción del problema

El sistema de la tienda contiene una lista de **rangos de IDs de producto** (tu *input*). Cada rango aparece en una sola línea, separado por comas, y tiene el formato:

```text
inicio-fin
```

* Los rangos son **inclusivos**.
* Todos los IDs son números positivos **sin ceros a la izquierda**.
* Tu trabajo consiste en detectar qué IDs dentro de esos rangos siguen ciertos **patrones repetitivos**, considerados inválidos.

---

## 🌟 Parte 1 — Repeated Twice

En la primera parte, un ID se considera **inválido** si:

> Está formado únicamente por una secuencia de dígitos repetida **exactamente dos veces**.

**Objetivo:**

> Encontrar todos los IDs inválidos dentro de los rangos y calcular la **suma total**.

---

## 🌟 Parte 2 — Repeated At Least Twice

Tras revisar los resultados, el dependiente descubre que todavía hay IDs inválidos. El Elfo utilizó patrones más variados de lo esperado.

Ahora, un ID es **inválido** si:

> Está formado únicamente por una secuencia de dígitos repetida **al menos dos veces**.

**Objetivo:**

> Aplicar la nueva regla y calcular la **suma total** de todos los IDs inválidos.

---

[▶ Ir al día 2](../src/main/java/software/aoc/day02)

---

## 🏗️ Estructura del día

```text
day02/
├─ a/
│  └─ Main
├─ b/
│  └─ Main
├─ Range
├─ Loader
├─ RangeChecker
└─ RangeLoader
```

- **Range**: clase inmutable que representa un rango numérico con límites inferior (`bottom`) y superior (`top`), parseando strings en formato "número-número".
- **RangeChecker**: clase inmutable que verifica si los valores dentro de un rango cumplen una condición dada, acumulando los valores inválidos que no la satisfacen. 
- **RangeLoader**: clase responsable de cargar y transformar los rangos desde el fichero de texto de entrada, parseando cada línea en objetos `Range`. 
- **Loader**: interfaz que define el contrato para la carga de rangos, permitiendo desacoplar el origen de los datos. 




## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Inmutabilidad**: `Range` y `RangeChecker` no modifican estado existente.
- **Declaratividad**: validaciones expresadas con funciones.
- **Composición**: la lógica se construye combinando funciones.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `Range`: representa un intervalo.
  - `RangeChecker`: valida y acumula resultados.
  - `RangeLoader`: carga los datos.
- **Open / Closed Principle (OCP)**:
  - Nuevas validaciones se añaden pasando nuevas funciones sin modificar las clases existentes.
- **Principio de inversión de dependencias (DIP)**:
  - `RangeChecker` depende de abstracciones funcionales (`Function`), no de implementaciones concretas.

### Patrones de diseño
- **Strategy (funcional)**:
  - La condición de validación se inyecta como estrategia mediante `Function`.
