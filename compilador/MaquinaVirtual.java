import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class MaquinaVirtual{
    private Stack<Integer> pilha;
    private int instructionPointer = 0; // <-- Aquí declaras el instruction pointer
    // private Stack<Map<String, Integer>> memoryStack = new Stack<>(); 
    // private Map<String, Integer> mainMemory = new java.util.HashMap<>();
    private MainMemory mainMemory = new MainMemory();
    private Stack<Memory> memoryStack = new Stack<>();
    private List<Cuadruplo> cuadruplos;
    private Map<String, Integer> memoriaConstantes = new HashMap<>();
    private Map<String, FunctionInfo> functionDirectory = new HashMap<>();
    private Memory memoryAux = new Memory();
    

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
            int numVariablesInt = globalInfo.recursos.numVariablesInt;
            int numVariablesFloat = globalInfo.recursos.numVariablesFloat;

            for (int i = 0; i < numVariablesInt; i++) {
                int direccion = 1000 + i;
                mainMemory.memoriaGlobal.put(direccion, 0);
            }
            for (int i = 0; i < numVariablesFloat; i++) {
                int direccion = 3000 + i;
                mainMemory.memoriaGlobal.put(direccion, 0.0f);
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

        // Inicializa la memoria activa para la función principal
        memoryStack.push(inicializarMemoriaActiva(globalInfo, globalInfo.parameters.size(), true));
        memoryAux = memoryStack.peek();

    }

    private Memory inicializarMemoriaActiva(FunctionInfo funcInfo, int parametrosSize, boolean isMain) {
    System.out.println("Parametros =  " + parametrosSize);        
    Memory memory = new Memory();
    
    // Temporales (debes tener los contadores por tipo en Recursos)                                                                              
    int numTempInt = funcInfo.recursos.numTemporalesInt;
    int numTempFloat = funcInfo.recursos.numTemporalesFloat;
    int numTempBool = funcInfo.recursos.numTemporalesBool;
    // Variables locales
    int numVariablesInt = funcInfo.recursos.numVariablesInt;
    int numVariablesFloat = funcInfo.recursos.numVariablesFloat;

    if(isMain!= true) {
        // Variables locales
        for (int i = 0; i < numVariablesInt; i++) {
            int direccion = 5000 + i;
            memory.put(direccion, 0);
        }
        for (int i = 0; i < numVariablesFloat; i++) {
            int direccion = 7000 + i;
            memory.put(direccion, 0.0f);
        }
    }



    // Int temporales
    for (int i = 0; i < numTempInt; i++) {
        int direccion = 9000 + i;
        memory.put(direccion, 0);
    }
    // Float temporales
    for (int i = 0; i < numTempFloat; i++) {
        int direccion = 11000 + i;
        memory.put(direccion, 0.0f);
    }
    // Bool temporales
    for (int i = 0; i < numTempBool; i++) {
        int direccion = 13000 + i;
        memory.put(direccion, false);
    }
    

    return memory;
    
}


private void ejecutarCuadruplos() {
    instructionPointer = 0;
    Stack<Integer> pilaSaltos = new Stack<>();
    while (instructionPointer < cuadruplos.size()) {
        Cuadruplo q = cuadruplos.get(instructionPointer);
        String op = q.operador;
        String op1 = q.operando1;
        int op2 = q.operando2.equals("-1") ? -1 : Integer.parseInt(q.operando2);
        int res = q.resultado.equals("-1") ? -1 : Integer.parseInt(q.resultado);


        switch (op) {
            case "GOTO":
                instructionPointer = res;
                continue;

            case "+":
            case "-":
            case "*":
            case "/": {
                Number val1 = leerValor(Integer.parseInt(op1));
                Number val2 = leerValor(op2);
                Number resultado = 0;
                // Si alguno es float, resultado es float
                boolean esFloat = (val1 instanceof Float) || (val2 instanceof Float);
                switch (op) {
                    case "+": resultado = esFloat ? val1.floatValue() + val2.floatValue() : val1.intValue() + val2.intValue(); break;
                    case "-": resultado = esFloat ? val1.floatValue() - val2.floatValue() : val1.intValue() - val2.intValue(); break;
                    case "*": resultado = esFloat ? val1.floatValue() * val2.floatValue() : val1.intValue() * val2.intValue(); break;
                    case "/": resultado = esFloat ? val1.floatValue() / val2.floatValue() : val1.intValue() / val2.intValue(); break;
                }
                escribirValor(res, resultado);
                break;
            }

            case "=": {
                Number valor = leerValor(Integer.parseInt(op1));
                escribirValor(res, valor);
                break;
            }

            case "PRINT": {
                Number valor = leerValor(res);
                System.out.println(valor);
                break;
            }

            case "GOSUB": {
                 pilaSaltos.push(instructionPointer + 1);
                // Guarda el contexto actual
                memoryStack.push(memoryAux);
                // Ya memoryAux apunta a la nueva reserva de ERA
                instructionPointer = res;
                continue;
            }

            case "ERA": {
                // Aquí se asume que res es el nombre de la función
                FunctionInfo funcInfo = functionDirectory.get(op1);
                if (funcInfo != null) {
                    Memory nuevaMemoria = inicializarMemoriaActiva(funcInfo, funcInfo.parameters.size(), false);
                    memoryAux = nuevaMemoria; // Guarda la memoria activa para la función
                    //actualizarMemoriaActiva();
                } else {
                    System.err.println("Función no encontrada: " + res);
                }
                 memoryAux = inicializarMemoriaActiva(funcInfo, funcInfo.parameters.size(), false);
                break;
            }
            case "PARAMETER": {
                int paramIndex = res;
                int opi = Integer.parseInt(q.operando1);
                // Determina el tipo del argumento por su dirección
                int dirDestino;
                if ((opi >= 1000 && opi < 3000) || (opi >= 5000 && opi < 7000) || (opi >= 9000 && opi < 11000) || (opi >= 15000 && opi < 17000)) {
                    // Es int (global, local, temporal, constante)
                    dirDestino = 5000 + paramIndex;
                } else if ((opi >= 3000 && opi < 5000) || (opi >= 7000 && opi < 9000) || (opi >= 11000 && opi < 13000) || (opi >= 17000 && opi < 19000)) {
                    // Es float (global, local, temporal, constante)
                    dirDestino = 7000 + paramIndex;
                } else {
                    System.err.println("Tipo de parámetro no soportado para dirección: " + op1);
                    break; 
                }

                Number valor = leerValor(opi);
                if (dirDestino >= 5000 && dirDestino < 7000) {
                    memoryAux.put(dirDestino, valor.intValue());
                } else if (dirDestino >= 7000 && dirDestino < 9000) {
                    memoryAux.put(dirDestino, valor.floatValue());
                } else {
                    System.err.println("Dirección de parámetro no válida: " + dirDestino);
                }
                
                break;
            }

            case "ENDFunc": {
                // 1. Restaurar la memoria del contexto padre
                if (!memoryStack.isEmpty()) {
                    memoryAux = memoryStack.pop();
                } else {
                    System.err.println("Error: Stack de memoria vacío en ENDFunc");
                }

                // 2. Recuperar y saltar a la dirección de retorno
                if (!pilaSaltos.isEmpty()) {
                    instructionPointer = pilaSaltos.pop();
                    continue;  // reingresa al while sin hacer el instructionPointer++
                } else {
                    // No hay más retornos; finaliza la ejecución
                    instructionPointer = cuadruplos.size();
                }
                break;
            }


            default:
                System.err.println("Operador no soportado: " + op);
        }
        instructionPointer++;
    }
}

// Lee el valor de la dirección desde la memoria correspondiente
private Number leerValor(int direccion) {
    if (direccion == -1) {System.out.println("**intento ingresar a un null***"); return 0;}
    if (direccion >= 1000 && direccion < 3000) { // int global
        return mainMemory.memoriaGlobal.getInt(direccion);
    } else if (direccion >= 3000 && direccion < 5000) { // float global
        return mainMemory.memoriaGlobal.getFloat(direccion);
    } else if (direccion >= 9000 && direccion < 11000) { // int temporal
        return memoryStack.peek().getInt(direccion);
    } else if (direccion >= 11000 && direccion < 13000) { // float temporal
        return memoryStack.peek().getFloat(direccion);
    } else if (direccion >= 15000 && direccion < 17000) { // int constante
        return mainMemory.memoriaConstante.getInt(direccion);
    } else if (direccion >= 17000 && direccion < 19000) { // float constante
        return mainMemory.memoriaConstante.getFloat(direccion);
    } else {
        System.err.println("Dirección no reconocida para leer: " + direccion);
        return 0;
    }
}

// Escribe el valor en la memoria correspondiente
private void escribirValor(int direccion, Number valor) {
    if (direccion == -1) return;
    if (direccion >= 1000 && direccion < 3000) { // int global
        mainMemory.memoriaGlobal.put(direccion, valor.intValue());
    } else if (direccion >= 3000 && direccion < 5000) { // float global
        mainMemory.memoriaGlobal.put(direccion, valor.floatValue());
    } else if (direccion >= 9000 && direccion < 11000) { // int temporal
        memoryStack.peek().put(direccion, valor.intValue());
    } else if (direccion >= 11000 && direccion < 13000) { // float temporal
         memoryStack.peek().put(direccion, valor.floatValue());
    } else {
        System.err.println("Dirección no reconocida para escribir: " + direccion);
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
        // Ejecuta los cuádruplos
        System.out.println("------------------------Terminal de BABYDUCK----------------------------");
        ejecutarCuadruplos();


    }


}
