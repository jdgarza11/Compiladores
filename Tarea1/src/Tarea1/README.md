# Tarea1 - Implementación de Stack, Queue y Dictionary

Este proyecto contiene implementaciones básicas de las estructuras de datos `Stack`, `Queue` y `Dictionary` en Java, junto con ejemplos de uso en la clase principal `App`.

## Casos de Uso

### 1. **Stack (Pila)**
La clase `Stack` implementa una estructura de datos LIFO (Last In, First Out). Los elementos se agregan y eliminan desde el mismo extremo.

#### Métodos principales:
- `push(T value)`: Agrega un elemento al tope de la pila.
- `pop()`: Elimina y devuelve el elemento en el tope de la pila.
- `isEmpty()`: Verifica si la pila está vacía.

#### Ejemplo de uso:
```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
System.out.println("Stack pop: " + stack.pop()); // Salida: 20