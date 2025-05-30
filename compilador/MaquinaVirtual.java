import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MaquinaVirtual {
    private int instructionPointer = 0;
    private Map<Integer, Object> memoriaPrincipal = new HashMap<>();
    private Stack<Map<Integer, Object>> memoryStack = new Stack<>();
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
        // Reservar globals
        FunctionInfo globalInfo = functionDirectory.get("program");
        if (globalInfo != null) {
            for (int i = 0; i < globalInfo.recursos.numVariablesInt; i++)
                memoriaPrincipal.put(1000 + i, 0);
            for (int i = 0; i < globalInfo.recursos.numVariablesFloat; i++)
                memoriaPrincipal.put(3000 + i, 0.0f);
        }
        // Cargar constantes
        for (Map.Entry<String, Integer> entry : memoriaConstantes.entrySet()) {
            int dir = entry.getValue(); String valStr = entry.getKey(); Object val;
            if (dir >= 15000 && dir < 17000) {
                try { val = Integer.parseInt(valStr); } catch (Exception e) { val = 0; }
            } else if (dir >= 17000 && dir < 19000) {
                try { val = Float.parseFloat(valStr); } catch (Exception e) { val = 0.0f; }
            } else {
                // string literal constants handled inline in PRINT
                continue;
            }
            memoriaPrincipal.put(dir, val);
        }
        // Contexto inicial
        memoryStack.push(new HashMap<>(memoriaPrincipal));
    }

    public void ejecutar() {
        Stack<Integer> pilaSaltos = new Stack<>();
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

                // Aritméticos: solo division promueve a float, suma/resta/multiplicación siempre entero
                case "+": case "-": case "*": case "/": {
                    int a1 = Integer.parseInt(op1Str);
                    int a2 = Integer.parseInt(op2Str);
                    Number v1 = leer(a1);
                    Number v2 = leer(a2);
                    Number out;
                    if ("/".equals(op)) {
                        // division produce float si hay float o no
                        out = v1.floatValue() / v2.floatValue();
                    } else {
                        // suma, resta, multiplicación siempre entero
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
                        System.out.println(resStr.substring(1, resStr.length()-1));
                    } else {
                        int addr = Integer.parseInt(resStr);
                        System.out.println(leer(addr));
                    }
                    break;
                }

                case "ERA": {
                    String funcName = op1Str;
                    FunctionInfo fi = functionDirectory.get(funcName);
                    if (fi != null) {
                        memoryStack.push(new HashMap<>(memoryStack.firstElement()));
                    }
                    break;
                }

                case "PARAMETER": {
                    int src = Integer.parseInt(op1Str);
                    int dest = Integer.parseInt(resStr);
                    memoryStack.peek().put(dest, leer(src));
                    break;
                }

                case "GOSUB": {
                    pilaSaltos.push(instructionPointer + 1);
                    instructionPointer = Integer.parseInt(resStr);
                    continue;
                }

                case "ENDFunc": {
                    if (!memoryStack.isEmpty()) memoryStack.pop();
                    if (!pilaSaltos.isEmpty()) {
                        instructionPointer = pilaSaltos.pop();
                        continue;
                    } else {
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

    private Number leer(int dir) {
        Object o = memoryStack.peek().getOrDefault(dir, memoriaPrincipal.get(dir));
        if (o instanceof Integer) return (Integer) o;
        if (o instanceof Float) return (Float) o;
        return 0;
    }

    private void escribir(int dir, Number val) {
        memoryStack.peek().put(dir, val);
    }
}
