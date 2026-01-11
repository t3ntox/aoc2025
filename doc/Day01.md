# 🎄 Advent of Code 2025 – Day 1: Secret Entrance

Los elfos del Polo Norte han empezado a aplicar *project management* para evitar los clásicos desastres navideños… pero en el proceso han terminado bloqueando su propia entrada secreta. Tu objetivo es ayudarlos a abrir la caja fuerte que guarda la contraseña para continuar con la decoración del Polo Norte.

---

## 🧩 Descripción del problema

La caja fuerte tiene un **dial circular** con los números del `0` al `99`.  
El documento adjunto (tu **input**) contiene una secuencia de **rotaciones**, una por línea, con el formato:

```text
L<number>
R<number>
```

- `L` → gira el dial hacia la izquierda (decreciente).  
- `R` → gira el dial hacia la derecha (creciente).  
- El dial comienza en la posición **50**.  
- Si se sobrepasa `0` o `99`, el dial continúa en forma circular (por ejemplo, a la izquierda de `0` está `99`, y a la derecha de `99` está `0`).  

---

## 🌟 Parte 1 — The Decoy Safe

**Objetivo:**
> Contar las veces que el dial está en `0` **al finalizar** una rotación.

---

## 🌟 Parte 2 — Password Method 0x434C49434B

Una nueva política de seguridad especifica el *"password method 0x434C49434B"*, que cambia la forma de calcular la contraseña. 

**Objetivo:**
> Contar las veces que el dial apunta a `0` **en cualquier momento, no solo al final**.

---

[▶ Ir al día 1](../src/main/java/software/aoc/day01)


---

## 🏗️ Estructura del día

```text
day01/
├─ a/
│  └─ Main
│  └─ SimpleZeroCounter
├─ b/
│  └─ Main
│  └─ WrapZeroCounter
├─ Dial
├─ ZeroCounter
├─ Loader
├─ Order
└─ OrdersLoader
```
- **SimpleZeroCounter**: implementación de `ZeroCounter` que cuenta si el dial termina apuntando a 0 al final de cada rotación.
- **WrapZeroCounter**: implementación de `ZeroCounter` que cuenta las veces que el dial cruza por el valor 0 durante una rotación, incluyendo tanto rotaciones parciales como vueltas completas al dial.
- **Dial**: clase inmutable que representa el estado del dial en un instante dado, incluyendo el valor al que apunta y el conteo acumulado de pasos por el 0.
- **Order**: clase inmutable que modela una orden de giro aplicada al dial, especificando dirección y magnitud.
- **OrdersLoader**: clase responsable de cargar y transformar las órdenes desde el fichero de texto de entrada.
- **Loader**: interfaz que define el contrato para la carga de órdenes, permitiendo desacoplar el origen de los datos.
- **ZeroCounter**: interfaz común que abstrae la lógica de conteo de pasos por el valor 0, permitiendo distintas estrategias de conteo para cada parte del problema sin duplicar el modelo del dial.




## 📐 Fundamentos, Principios y patrones de diseño de ingeniería del software aplicados

---

### Fundamentos de diseño
- **Abstracción**: el concepto de `Dial` modela el estado del dial sin exponer detalles internos.
- **Inmutabilidad**: el dial no se modifica; cada rotación devuelve una nueva instancia.
- **Modelado del dominio**: `Order` representa explícitamente una orden de giro.

### Principios de diseño
- **Single Responsibility Principle (SRP)**:
    - `Dial`: representa el estado del dial.
    - `Order`: representa una instrucción de giro.
    - `OrdersLoader`: carga las órdenes desde el input.
- **Open / Closed Principle (OCP)**:
    - El conteo de ceros se abstrae mediante `ZeroCounter`, permitiendo nuevas estrategias.
- **Bajo acoplamiento**:
    - `Dial` no depende de cómo se cargan las órdenes.
- **Alta cohesión**:
    - Cada clase cumple un único propósito claro.

### Patrones de diseño
- **Strategy**:
    - `ZeroCounter` define distintas estrategias de conteo (Parte 1 y Parte 2).
