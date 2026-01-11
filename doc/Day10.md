# 🎄 Advent of Code 2025 – Day 10: Factory

Al cruzar el pasillo llegas a una enorme **fábrica** llena de Elfos… con mucho tiempo libre. No porque todo vaya bien, sino porque **todas las máquinas están apagadas** y nadie recuerda cómo inicializarlas. El manual existe, pero la parte importante fue devorada por un Shiba Inu.

Lo único que queda son diagramas de luces indicadoras, esquemas de botones y requisitos de voltaje. Con eso tendrá que bastar.

---

## 🧩 Descripción del problema

Cada línea del *input* describe **una máquina independiente**, compuesta por tres elementos:

* Un **diagrama de luces indicadoras** (entre `[]`)
* Una lista de **botones** y qué luces/contadores afectan (entre `()`)
* Una lista de **requisitos de voltaje** (entre `{}`)


Las máquinas siempre empiezan en estado inicial (luces apagadas o contadores a 0), y los botones pueden pulsarse cualquier número entero de veces.

---

## 🌟 Parte 1 — Indicator Lights

En la primera parte, los **requisitos de voltaje se ignoran por completo**.

Cada máquina tiene un conjunto de **luces indicadoras** que empiezan apagadas. El objetivo es que coincidan exactamente con el patrón indicado, donde:

* `.` significa luz apagada
* `#` significa luz encendida

Cada botón alterna el estado (on/off) de un subconjunto de luces.

🔍 **Objetivo:**

> Determinar el **mínimo número total de pulsaciones** necesarias para configurar correctamente **todas las máquinas**.

Cada máquina se resuelve de forma independiente y luego se suman los mínimos.

---

## 🌟 Parte 2 — Joltage Configuration

Con las luces ya configuradas, llega el momento de preocuparse por el **voltaje**.

Ahora:

* Se ignoran los diagramas de luces
* Cada máquina tiene varios **contadores de voltaje**, todos iniciando en 0
* El objetivo es alcanzar exactamente los valores indicados en `{}`

En este modo, los botones ya no alternan estados: **cada pulsación incrementa en 1** los contadores indicados.

🔍 **Objetivo:**

> Calcular el **mínimo número de pulsaciones** necesarias para ajustar correctamente todos los contadores de todas las máquinas.

De nuevo, cada máquina se resuelve por separado y los resultados se suman.

---

[▶ Ir al día 10](../src/main/java/software/aoc/day10)

---

## 🏗️ Estructura del día

```text
day10/
├─ a/
│  └─ LightTester
│  └─ Main
├─ b/
│  └─ JoltageTester
│  └─ Main
├─ Button
├─ Loader
├─ Machine
└─ MachineLoader
```

- **Button**: clase inmutable que representa un botón con un conjunto de posiciones afectadas, proporcionando métodos para cambiar luces o joltajes.
- **Machine**: clase inmutable que encapsula el diagrama de luces objetivo, la lista de botones disponibles y los joltajes actuales.
- **LightTester**: clase que resuelve el problema de la parte A mediante búsqueda con memoización para encontrar la secuencia mínima de pulsaciones de botones que alcance el objetivo de luces.
- **JoltageTester**: clase que resuelve el problema de la parte B construyendo mapas de paridad y patrones, utilizando programación dinámica para minimizar el número total de pulsaciones.
- **MachineLoader**: clase responsable de cargar y transformar máquinas desde el fichero de texto de entrada, parseando diagrama de luces, botones y joltajes. 
- **Loader**: interfaz que define el contrato para la carga de máquinas, permitiendo desacoplar el origen de los datos.

## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Modelado explícito del dominio**:
  - El concepto de *botón* deja de ser una estructura implícita (`List<Integer>`) y pasa a ser un objeto del dominio (`Button`).
  - `Machine` representa el estado completo del problema (luces, botones y joltages) como una unidad coherente.
- **Inmutabilidad controlada**:
  - `Button` es un *value object* inmutable: su lista de luces afectadas no cambia.
  - `Machine` protege su estado devolviendo copias defensivas (`lightDiagram()`).
- **Encapsulación del comportamiento**:
  - La lógica de "qué hace un botón al pulsarse" está dentro de `Button` (`pressLight`, `pressJoltage`), no dispersa en los testers.
- **Separación de conceptos**:
  - Carga de datos (`MachineLoader`), modelo (`Machine`, `Button`) y algoritmos (`LightTester`, `JoltageTester`) están claramente separados.
- **Abstracción**:
  - La interfaz `Loader` abstrae el origen de los datos.
- **Claridad semántica**:
  - El código expresa intención: `button.pressLight(...)` es más expresivo que iterar índices manualmente.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `Button`: define el efecto de una pulsación.
  - `Machine`: encapsula el estado completo del problema.
  - `LightTester`: resuelve el problema de luces con backtracking y memoización.
  - `JoltageTester`: resuelve el problema de joltages mediante paridades y DP.
  - `MachineLoader`: se encarga exclusivamente del parsing del input.
- **Open / Closed Principle (OCP)**:
  - Nuevos tipos de efectos de botones podrían añadirse ampliando `Button` sin modificar los testers.
  - Nuevas estrategias de resolución pueden implementarse creando nuevos `Tester`.
- **Dependency Inversion Principle (DIP)**:
  - `MachineLoader` depende de la abstracción `Loader`.
- **Bajo acoplamiento**:
  - Los testers dependen de la abstracción `Button` y `Machine`, no de detalles de implementación.
- **Alta cohesión**:
  - Cada clase agrupa comportamiento estrechamente relacionado.
- **Tell, Don't Ask**:
  - En lugar de preguntar "qué luces afecta este botón" y operar fuera, se le dice al botón que actúe.
- **Programación defensiva**:
  - Uso de copias (`Arrays.copyOf`) para evitar efectos colaterales en estados compartidos.

### Patrones de diseño
- **Value Object**:
  - `Button` y `Machine` representan conceptos del dominio sin identidad mutable.
- **Strategy**:
  - `LightTester` y `JoltageTester` implementan estrategias distintas para resolver el mismo dominio.
- **Backtracking con memoización**:
  - `LightTester` explora combinaciones de pulsaciones evitando recomputaciones mediante caché.
- **Dynamic Programming**:
  - `JoltageTester` reduce el problema usando paridades y descomposición recursiva con cache.
- **Factory Pattern**:
  - `MachineLoader` actúa como fábrica que construye instancias completas de `Machine` a partir del input.
- **Functional Core / Imperative Shell**:
  - La lógica principal es funcional (cálculos, transformaciones), mientras que la carga de datos es imperativa.
