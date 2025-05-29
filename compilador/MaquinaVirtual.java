import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MaquinaVirtual{
    private Stack<Integer> pilha;
    private int instructionPointer = 0; // <-- Aquí declaras el instruction pointer
    // private Stack<Map<String, Integer>> memoryStack = new Stack<>(); 
    // private Map<String, Integer> mainMemory = new java.util.HashMap<>();
    private Memory memoriaGlobal = new Memory();
    private MainMemory mainMemory = new MainMemory();
    private Stack<Memory> memoryStack = new Stack<>();
    private List<Cuadruplo> cuadruplos;
    private Map<String, Integer> memoriaConstantes = new HashMap<>();
    private Map<String, FunctionInfo> functionDirectory = new HashMap<>();
    
    

    public MaquinaVirtual(Ovejota ovejota) {
        this.pilha = new Stack<>();
        this.cuadruplos = ovejota.cuadruplos;
        this.memoriaConstantes = ovejota.memoriaConstantes;
        this.functionDirectory = ovejota.functionDirectory;
        inicializarMemoriaGlobal();
    }

    private void inicializarMemoriaGlobal() {
        // Inicializa las memorias si es necesario
        if (mainMemory.memoriaGlobal == null) mainMemory.memoriaGlobal = new Memory();
        if (mainMemory.memoriaConstante == null) mainMemory.memoriaConstante = new Memory();

        // Variables globales
        FunctionInfo globalInfo = functionDirectory.get("program");
        if (globalInfo != null) {
            for (VariableInfo var : globalInfo.variables.values()) {
                int direccion = var.direction;
                String tipo = var.type;
                if (direccion >= 1000 && direccion < 3000) { // int global
                    mainMemory.memoriaGlobal.put(direccion, 0);
                } else if (direccion >= 3000 && direccion < 5000) { // float global
                    mainMemory.memoriaGlobal.put(direccion, 0.0f);
                }
                // Si tienes bool global, agrégalo aquí
            }
        }

        // Constantes
        if (memoriaConstantes != null) {
            for (Map.Entry<String, Integer> entry : memoriaConstantes.entrySet()) {
                int direccion = entry.getValue();
                String valorStr = entry.getKey();
                if (direccion >= 15000 && direccion < 17000) { // int constante
                    try {
                        int valor = Integer.parseInt(valorStr);
                        mainMemory.memoriaConstante.put(direccion, valor);
                    } catch (NumberFormatException e) {
                        mainMemory.memoriaConstante.put(direccion, 0);
                    }
                } else if (direccion >= 17000 && direccion < 19000) { // float constante
                    try {
                        float valor = Float.parseFloat(valorStr);
                        mainMemory.memoriaConstante.put(direccion, valor);
                    } catch (NumberFormatException e) {
                        mainMemory.memoriaConstante.put(direccion, 0.0f);
                    }
                }
                // Si tienes bool constante, agrégalo aquí
            }
        }
    }

        private Memory memoriaActiva() {
        return memoryStack.peek();
    }

    private int leerMemoria(int direccion) {
        if (esDireccionGlobal(direccion)) {
            return memoriaGlobal.getInt(direccion);
        } else {
            return memoriaActiva().getInt(direccion);
        }
    }

    private void escribirMemoria(int direccion, int valor) {
        if (esDireccionGlobal(direccion)) {
            memoriaGlobal.put(direccion, valor);
        } else {
            memoriaActiva().put(direccion, valor);
        }
    }

    private boolean esDireccionGlobal(int direccion) {
        return direccion >= 1000 && direccion < 5000;
    }

    public void ejecutarCuadruplos() {
        instructionPointer = 0;
        while (instructionPointer < this.cuadruplos.size()) {
            Cuadruplo cuadruplo = this.cuadruplos.get(instructionPointer);
            switch (cuadruplo.operador) {
                case "+":
                    int b = pilha.pop();
                    int a = pilha.pop();
                    pilha.push(a + b);
                    break;
                case "-":
                    b = pilha.pop();
                    a = pilha.pop();
                    pilha.push(a - b);
                    break;
                case "*":
                    b = pilha.pop();
                    a = pilha.pop();
                    pilha.push(a * b);
                    break;
                case "/":
                    b = pilha.pop();
                    a = pilha.pop();
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    pilha.push(a / b);
                    break;

                case "=": // Asignación
                    int valor = pilha.pop();
                    // Aquí podrías almacenar el valor en una variable si fuera necesario
                    // Por ejemplo, si tienes un mapa de variables, podrías hacer algo como:
                    //this.variables.put(cuadruplo.resultado, valor);
                    break;

                case "GOTO": // Salto incondicional
                    int target = Integer.parseInt(cuadruplo.resultado);
                    if (target < 0 || target >= this.cuadruplos.size()) {
                        throw new IndexOutOfBoundsException("GOTO fuera de rango: " + target);
                    }
                    instructionPointer = target; // Salta al cuádruplo indicado
                    continue; // No avanza al siguiente cuádruplo
                
                // case "PUSH":
                //     pilha.push(cuadruplo.operando1);
                //     break;
                // case "POP":
                //     pilha.pop();
                //     break;
                default:
                    throw new UnsupportedOperationException("Operador no soportado: " + cuadruplo.operador);
            }
            instructionPointer++; // Avanza al siguiente cuádruplo
        }
    }
    public int obtenerResultado() {
        if (pilha.isEmpty()) {
            throw new IllegalStateException("La pila está vacía, no hay resultado.");
        }
        return pilha.pop();
    }
    public void imprimirPila() {
        System.out.println("Contenido de la pila: " + pilha);
    }

    public void ejecutar() {
        // Inicializa la pila
        pilha.clear();
        System.out.println(memoriaConstantes);
        // Inicializa la memoria
        mainMemory.imprimir();

    }


}
