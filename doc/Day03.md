# 🎄 Advent of Code 2025 – Day 3: Lobby

Tras descender por una corta escalera llegas al **lobby del Polo Norte**. Pasas sin problemas el control de seguridad, pero al llegar a los ascensores descubres que todos están fuera de servicio debido a una subida de tensión.

Un Elfo te sugiere usar la escalera mecánica para seguir descendiendo… pero también está apagada. Por suerte, hay **baterías de emergencia** cerca. Si consigues suministrar suficiente voltaje, podrás ponerla en marcha.

---

## 🧩 Descripción del problema

Tu *input* consiste en varias líneas de dígitos. Cada línea representa un **banco de baterías**, y cada dígito indica el **joltage** (de `1` a `9`) de una batería.

Dentro de cada banco:

* Las baterías **no se pueden reordenar**.
* Debes encender un número exacto de baterías.
* El **joltage producido** es el número formado por los dígitos de las baterías encendidas, en el mismo orden.

El objetivo es **maximizar el joltage** producido por cada banco y luego sumar los resultados.

---

## 🌟 Parte 1 — Two Batteries

En la primera parte, debes encender **exactamente dos baterías** por banco.

El joltage del banco será el número de dos cifras formado por esas baterías.

**Objetivo:**

> Encontrar el mayor joltage posible en cada banco usando **dos baterías** y calcular la **suma total**.

---

## 🌟 Parte 2 — Twelve Batteries

La escalera mecánica sigue sin moverse, así que se desactiva el límite de seguridad. Ahora necesitas aún más potencia.

En esta parte, debes encender **exactamente doce baterías** por banco.

* El joltage resultante tendrá **12 dígitos**.
* Las reglas de orden y selección se mantienen.

**Objetivo:**

> Encontrar el mayor joltage posible en cada banco usando **doce baterías** y calcular la **suma total**.

---

[▶ Ir al día 3](../src/main/java/software/aoc/day03)

---

## 🏗️ Estructura del día

```text
day03/
├─ a/
│  └─ Main
├─ b/
│  └─ Main
├─ Bank
├─ BankLoader
└─ Loader
```

- **Bank**: clase inmutable que representa una secuencia de caracteres (línea) y proporciona métodos para extraer pares de valores máximos dentro de rangos específicos. 
- **BankLoader**: clase responsable de cargar y transformar las líneas desde el fichero de texto de entrada, parseando cada una en objetos `Bank`. 
- **Loader**: interfaz que define el contrato para la carga de bancos, permitiendo desacoplar el origen de los datos. 




## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Encapsulación algorítmica**: la lógica compleja se concentra en `Bank`.
- **Inmutabilidad**: `Bank` es un `record`, garantizando semántica de valor.
- **Abstracción**: el origen de los datos se abstrae mediante `Loader`.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
  - `Bank`: encapsula el cálculo del par máximo.
  - `BankLoader`: se encarga exclusivamente de la carga del input.
- **Open / Closed Principle (OCP)**:
  - Nuevas estrategias de carga pueden añadirse implementando `Loader` sin modificar `Bank`.
- **DRY**:
  - Extracción del cálculo de máximos en métodos privados reutilizables.
- **Claridad algorítmica**:
  - Algoritmo explícito y determinista, fácil de seguir y entender.

### Patrones de diseño
- **Value Object**:
  - `Bank` representa un valor inmutable del dominio, encapsulando los datos y comportamiento asociado.

