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
    private Stack<Memory> memoryStack = new Stack<>();
    private List<Cuadruplo> cuadruplos;
    private Map<String, Integer> memoriaConstantes = new HashMap<>();
    private Map<String, FunctionInfo> functionDirectory = new HashMap<>();

    

    public MaquinaVirtual(List<Cuadruplo> cuadruplos, Map<String, FunctionInfo> functionDirectory, Map<String, Integer> memoriaConstantes) {
        this.pilha = new Stack<>();
        this.cuadruplos = cuadruplos;
        this.memoriaConstantes = memoriaConstantes;
        this.functionDirectory = functionDirectory;
        inicializarMemoriaGlobal(functionDirectory);
    }

    private void inicializarMemoriaGlobal(Map<String, FunctionInfo> functionDirectory) {
        // Busca la función global o "program"
        FunctionInfo globalInfo = functionDirectory.get("program");
        if (globalInfo != null) {
            int numVars = globalInfo.recursos.numVariables;
            int numTemps = globalInfo.recursos.numTemporales;

            // Reserva espacio para variables globales (ejemplo: direcciones 1000 a 1000+numVars)
            for (int i = 0; i < numVars; i++) {
                int direccion = 1000 + i;
                memoriaGlobal.put(direccion, 0); // Inicializa en 0 o valor por defecto
            }

            // Reserva espacio para temporales globales (ejemplo: direcciones 9000 a 9000+numTemps)
            for (int i = 0; i < numTemps; i++) {
                int direccion = 9000 + i;
                memoriaGlobal.put(direccion, 0); // Inicializa en 0 o valor por defecto
            }
        }

        // Inicializa constantes si tienes una tabla de constantes
        if (memoriaConstantes != null) {
            for (Map.Entry<String, Integer> entry : memoriaConstantes.entrySet()) {
                int direccion = entry.getValue();
                // Puedes convertir el valor de la constante según el tipo si lo necesitas
                // Aquí se inicializa en memoriaGlobal, pero podrías tener una memoria separada para constantes
                memoriaGlobal.put(direccion, Integer.parseInt(entry.getKey()));
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
    


}
