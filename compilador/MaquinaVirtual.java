import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MaquinaVirtual {
    private int instructionPointer = 0;
    private Map<Integer, Object> memoriaGlobal = new HashMap<>();
    private Stack<Map<Integer, Object>> stackFrames = new Stack<>();
    private List<Cuadruplo> cuadruplos;
    private Map<String, Integer> memoriaConstantes;
    private Map<String, FunctionInfo> functionDirectory;

    public MaquinaVirtual(Ovejota ovejota) {
        this.cuadruplos = ovejota.cuadruplos;
        this.memoriaConstantes = ovejota.memoriaConstantes;
        this.functionDirectory = ovejota.functionDirectory;
        inicializarMemoriaGlobal();
    }

    private void inicializarMemoriaGlobal() {
        // Reservar variables globales
        FunctionInfo globalInfo = functionDirectory.get("program");
        if (globalInfo != null) {
            // Variables globales int (1000-2999)
            for (int i = 0; i < globalInfo.recursos.numVariablesInt; i++)
                memoriaGlobal.put(1000 + i, 0);
            // Variables globales float (3000-4999)
            for (int i = 0; i < globalInfo.recursos.numVariablesFloat; i++)
                memoriaGlobal.put(3000 + i, 0.0f);
        }
        
        // Cargar constantes en memoria global
        for (Map.Entry<String, Integer> entry : memoriaConstantes.entrySet()) {
            int dir = entry.getValue(); 
            String valStr = entry.getKey(); 
            Object val;
            
            if (dir >= 15000 && dir < 17000) {
                try { 
                    val = Integer.parseInt(valStr); 
                } catch (Exception e) { 
                    val = 0; 
                }
            } else if (dir >= 17000 && dir < 19000) {
                try { 
                    val = Float.parseFloat(valStr); 
                } catch (Exception e) { 
                    val = 0.0f; 
                }
            } else {
                // string literals se manejan en PRINT
                continue;
            }
            memoriaGlobal.put(dir, val);
        }
    }

    public void ejecutar() {
        Stack<Integer> pilaSaltos = new Stack<>();
        
        // Crear frame inicial para el programa principal (main)
        FunctionInfo mainInfo = functionDirectory.get("program");
        Map<Integer, Object> mainFrame = new HashMap<>();
        
        if (mainInfo != null) {
            // Inicializar temporales del main
            for (int i = 0; i < mainInfo.recursos.numTemporalesInt; i++) {
                mainFrame.put(9000 + i, 0);
            }
            for (int i = 0; i < mainInfo.recursos.numTemporalesFloat; i++) {
                mainFrame.put(11000 + i, 0.0f);
            }
            for (int i = 0; i < mainInfo.recursos.numTemporalesBool; i++) {
                mainFrame.put(13000 + i, 0);
            }
        }
        
        stackFrames.push(mainFrame);
        //System.out.println("DEBUG: Iniciando main - Stack depth: " + stackFrames.size());
        
        while (instructionPointer < cuadruplos.size()) {
            Cuadruplo q = cuadruplos.get(instructionPointer);
            String op = q.operador;
            String op1Str = q.operando1;
            String op2Str = q.operando2;
            String resStr = q.resultado;

            switch (op) {
                case "GOTO":
                    instructionPointer = Integer.parseInt(resStr);
                    continue;

                case "+": case "-": case "*": case "/": {
                    int a1 = Integer.parseInt(op1Str);
                    int a2 = Integer.parseInt(op2Str);
                    Number v1 = leer(a1);
                    Number v2 = leer(a2);
                    Number out;
                    
                    if ("/".equals(op)) {
                        out = v1.floatValue() / v2.floatValue();
                    } else {
                        switch (op) {
                            case "+": out = v1.intValue() + v2.intValue(); break;
                            case "-": out = v1.intValue() - v2.intValue(); break;
                            default: out = v1.intValue() * v2.intValue();
                        }
                    }
                    escribir(Integer.parseInt(resStr), out);
                    break;
                }

                case "=": {
                    int src = Integer.parseInt(op1Str);
                    Number val = leer(src);
                    escribir(Integer.parseInt(resStr), val);
                    break;
                }

                case ">": case "<": case "!=": {
                    int a1 = Integer.parseInt(op1Str);
                    int a2 = Integer.parseInt(op2Str);
                    int dest = Integer.parseInt(resStr);
                    Number v1 = leer(a1), v2 = leer(a2);
                    boolean cond;
                    
                    switch(op) {
                        case ">": cond = v1.doubleValue() > v2.doubleValue(); break;
                        case "<": cond = v1.doubleValue() < v2.doubleValue(); break;
                        default: cond = !v1.equals(v2);
                    }
                    escribir(dest, cond ? 1 : 0);
                    break;
                }

                case "GOTOF": {
                    int flagAddr = Integer.parseInt(op1Str);
                    int target = Integer.parseInt(resStr);
                    Number flag = leer(flagAddr);
                    if (flag.intValue() == 0) {
                        instructionPointer = target;
                        continue;
                    }
                    break;
                }

                case "PRINT": {
                    if (resStr.startsWith("\"") && resStr.endsWith("\"")) {
                        System.out.println("|  "+resStr.substring(1, resStr.length()-1));
                    } else {
                        int addr = Integer.parseInt(resStr);
                        System.out.println("|  "+leer(addr));
                    }
                    break;
                }

                case "ERA": {
                    String funcName = op1Str;
                    FunctionInfo fi = functionDirectory.get(funcName);
                    
                    // Crear nuevo frame e inicializar variables locales y temporales
                    Map<Integer, Object> newFrame = new HashMap<>();
                    
                    if (fi != null) {
                        // Inicializar variables locales int (incluyendo parámetros)
                        for (int i = 0; i < fi.recursos.numVariablesInt; i++) {
                            newFrame.put(5000 + i, 0);
                        }
                        
                        // Inicializar variables locales float
                        for (int i = 0; i < fi.recursos.numVariablesFloat; i++) {
                            newFrame.put(7000 + i, 0.0f);
                        }
                        
                        // Inicializar temporales int
                        for (int i = 0; i < fi.recursos.numTemporalesInt; i++) {
                            newFrame.put(9000 + i, 0);
                        }
                        
                        // Inicializar temporales float
                        for (int i = 0; i < fi.recursos.numTemporalesFloat; i++) {
                            newFrame.put(11000 + i, 0.0f);
                        }
                        
                        // Inicializar temporales bool
                        for (int i = 0; i < fi.recursos.numTemporalesBool; i++) {
                            newFrame.put(13000 + i, 0);
                        }
                    }
                    
                    stackFrames.push(newFrame);
                    // System.out.println("DEBUG: ERA " + funcName + " - Stack depth: " + stackFrames.size() + 
                    //                  " - Variables: " + (fi != null ? fi.recursos.numVariablesInt : 0) + 
                    //                  " int, " + (fi != null ? fi.recursos.numVariablesFloat : 0) + " float");
                    break;
                }

                
                case "PARAMETER": {
                    int src = Integer.parseInt(op1Str);
                    int dest = Integer.parseInt(resStr);
                    
                    // El valor debe leerse del contexto actual (antes de ERA)
                    // pero escribirse en el frame que se acaba de crear (después de ERA)
                    Object value = leer(src);  // Esto ahora busca correctamente en el stack
                    
                    // Escribir en el frame actual (el de la función que se va a llamar)
                    if (!stackFrames.isEmpty()) {
                        stackFrames.peek().put(dest, value);
                        //System.out.println("DEBUG: PARAMETER " + src + " -> " + dest + " = " + value);
                    } else {
                        System.err.println("Error: No hay frame activo para parámetro");
                    }
                    break;
                }

                case "GOSUB": {
                    pilaSaltos.push(instructionPointer + 1);
                    instructionPointer = Integer.parseInt(resStr);
                    //System.out.println("DEBUG: GOSUB to " + resStr + " - Return to: " + (instructionPointer + 1));
                    continue;
                }

                case "ENDFunc": {
                    // Limpiar frame de función actual
                    if (!stackFrames.isEmpty()) {
                        Map<Integer, Object> removedFrame = stackFrames.pop();
                        //System.out.println("DEBUG: ENDFunc - Removed frame, Stack depth: " + stackFrames.size());
                    }
                    
                    // Regresar al punto de llamada
                    if (!pilaSaltos.isEmpty()) {
                        instructionPointer = pilaSaltos.pop();
                        //System.out.println("DEBUG: ENDFunc - Return to: " + instructionPointer);
                        continue;
                    } else {
                        // Fin del programa principal
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

    // Versión corregida de la función leer()
    private Number leer(int dir) {
        // 1. Buscar en todos los frames del stack (desde el más reciente)
        for (int i = stackFrames.size() - 1; i >= 0; i--) {
            Map<Integer, Object> frame = stackFrames.get(i);
            if (frame.containsKey(dir)) {
                Object value = frame.get(dir);
                //System.out.println("DEBUG: Leyendo " + dir + " del frame " + i + " = " + value);
                return (value instanceof Number) ? (Number) value : 0;
            }
        }
        
        // 2. Buscar en memoria global (variables globales y constantes)
        if (memoriaGlobal.containsKey(dir)) {
            Object value = memoriaGlobal.get(dir);
            //System.out.println("DEBUG: Leyendo " + dir + " de memoria global = " + value);
            return (value instanceof Number) ? (Number) value : 0;
        }
        
        // 3. Si es dirección local/temporal, inicializar con 0 en frame actual
        if (esMemoriaLocal(dir)) {
            if (!stackFrames.isEmpty()) {
                stackFrames.peek().put(dir, 0);
                //System.out.println("DEBUG: Inicializando " + dir + " = 0 en frame actual");
                return 0;
            }
        }
        
        System.err.println("Advertencia: Leyendo dirección no encontrada: " + dir);
        return 0;
    }

    private void escribir(int dir, Object val) {
        //System.out.println("DEBUG: Escribiendo " + dir + " = " + val);
        
        if (esMemoriaLocal(dir)) {
            // Variables locales, parámetros, temporales van al frame actual
            if (!stackFrames.isEmpty()) {
                stackFrames.peek().put(dir, val);
            } else {
                System.err.println("Error: No hay frame activo para escribir en: " + dir);
            }
        } else if (esMemoriaGlobal(dir)) {
            // Variables globales van a memoria global
            memoriaGlobal.put(dir, val);
        } else {
            System.err.println("Error: Dirección de memoria inválida: " + dir);
        }
    }
    
    private boolean esMemoriaLocal(int dir) {
        return (dir >= 5000 && dir < 7000) ||  // variables locales int
               (dir >= 7000 && dir < 9000) ||  // variables locales float
               (dir >= 9000 && dir < 11000) || // temporales int
               (dir >= 11000 && dir < 13000) || // temporales float
               (dir >= 13000 && dir < 15000);   // temporales bool
    }
    
    private boolean esMemoriaGlobal(int dir) {
        return (dir >= 1000 && dir < 3000) ||  // variables globales int
               (dir >= 3000 && dir < 5000) ||  // variables globales float
               (dir >= 15000 && dir < 17000) || // constantes int
               (dir >= 17000 && dir < 19000);   // constantes float
    }
}