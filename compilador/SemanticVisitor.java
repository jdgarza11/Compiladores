import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
public class SemanticVisitor extends ExprBaseVisitor<Void> {

    private Stack<String> pilaOperadores = new Stack<>();
    private Stack<String> pilaOperandos = new Stack<>();
    private Stack<String> pilaTipos = new Stack<>();
    private Stack<Integer> pilaSaltos = new Stack<>();

    // Fila para los cuádruplos
    private List<Cuadruplo> cuadruplos = new ArrayList<>();

    private Map<String, FunctionInfo> functionDirectory = new HashMap<>();
    private String currentFunction = null;


    //Mapa de memoria
    // Mapa de memoria virtual: nombre -> dirección
    // private Map<String, Integer> memoriaVirtual = new HashMap<>();
    private Map<String, Integer> memoriaConstantes = new HashMap<>();

    // Contadores para direcciones (puedes separar por tipo si lo deseas)
    private int dirVarGlobalInt = 1000;
    private int dirVarGlobalFloat = 3000;
    private int dirVarLocalInt = 5000;
    private int dirVarLocalFloat = 7000;
    private int dirTemporalInt = 9000;
    private int dirTemporalFloat = 11000;
    private int dirTemporalBool = 13000;
    private int dirConstInt = 15000;
    private int dirConstFloat = 17000;

    private int dirAsignar = 0;
    private int dirSuma = 1;
    private int dirResta = 2;    
    private int dirMultiplicacion = 3;
    private int dirDivision = 4; 
    private int dirMenor = 5; 
    private int dirMayor = 6;
    private int dirDistinto = 8;
    
    public SemanticVisitor() {
        cuadruplos.add(new Cuadruplo("GOTO", "-1", "-1", "pendiente"));

    }
   
private int getDireccionVariable(String id) {
    VariableInfo varInfo = getVariableInfo(id);
    if (varInfo == null) {
        throw new RuntimeException("Error: Variable '" + id + "' no declarada.");
    }
    if (varInfo.direction == null) {
        int dir;
        String tipo = varInfo.type;
        boolean esGlobal = functionDirectory.get("program").variables.containsKey(id);
        if (currentFunction == "program") {
            if ("int".equals(tipo)) {
                dir = dirVarGlobalInt++;
            } else if ("float".equals(tipo)) {
                dir = dirVarGlobalFloat++;
            } else {
                throw new RuntimeException("Tipo no soportado para variable global: " + tipo);
            }
        } else {
            if ("int".equals(tipo)) {
                dir = dirVarLocalInt++;
            } else if ("float".equals(tipo)) {
                dir = dirVarLocalFloat++;
            } else {
                throw new RuntimeException("Tipo no soportado para variable local: " + tipo);
            }
        }
        varInfo.direction = dir;
    }
    return varInfo.direction;
}

private int getDireccionConstante(String valor, String tipo) {  
    if (!memoriaConstantes.containsKey(valor)) {
        int dir;
        if ("int".equals(tipo)) {
            dir = dirConstInt++;
        } else if ("float".equals(tipo)) {
            dir = dirConstFloat++;
        } else {
            System.err.println("Error: Tipo de constante: " + tipo);
            return -1;
        }
        memoriaConstantes.put(valor, dir);
    }
    return memoriaConstantes.get(valor);
}
    // Genera una dirección de memoria para un temporal

private int generarDireccionTemporal(String tipo) {
    int direccion;
    if ("int".equals(tipo)) {
        direccion = dirTemporalInt++;
    } else if ("float".equals(tipo)) {
        direccion = dirTemporalFloat++;
    } else if ("bool".equals(tipo)) {
        direccion = dirTemporalBool++;
    } else {
        throw new RuntimeException("Tipo de temporal no soportado: " + tipo);
    }
    // Suma temporal al recurso de la función actual
    if (currentFunction != null && functionDirectory.containsKey(currentFunction)) {
        functionDirectory.get(currentFunction).recursos.numTemporales++;
        if("int".equals(tipo)) {
            functionDirectory.get(currentFunction).recursos.numTemporalesInt++;
        } else if("float".equals(tipo)) {
            functionDirectory.get(currentFunction).recursos.numTemporalesFloat++;
        } else if("bool".equals(tipo)) {
            functionDirectory.get(currentFunction).recursos.numTemporalesBool++;
        }
    }
    return direccion;
}
    

    public Map<String, FunctionInfo> getFunctionDirectory() {
        return functionDirectory;
    }

    public void imprimirCuadruplos() {
        System.out.println("Cuádruplos generados:");
        for (Cuadruplo c : cuadruplos) {
            System.out.println(c);
        }
    }

    public String imprimirDirectorio() {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, FunctionInfo> entry : functionDirectory.entrySet()) {
        sb.append("Función: ").append(entry.getKey()).append("\n");
        FunctionInfo funcInfo = entry.getValue();
        sb.append("  Tipo de retorno: ").append(funcInfo.returnType).append("\n");
        sb.append("  Recursos: ").append(funcInfo.recursos).append("\n");
        sb.append("  Variables:\n");
        for (Map.Entry<String, VariableInfo> varEntry : funcInfo.variables.entrySet()) {
            sb.append("    ").append(varEntry.getValue().Imprimir())
              //.append(" : ").append(varEntry.getValue().type)
              .append("\n");
        }
        sb.append("  Parámetros:\n");
        for (Map.Entry<String, VariableInfo> paramEntry : funcInfo.parameters.entrySet()) {
            sb.append("    ").append(paramEntry.getValue().Imprimir())
              //.append(" : ").append(paramEntry.getValue().type)
              .append("\n");
        }
    }
    return sb.toString();
}

    @Override
    public Void visitAll(ExprParser.AllContext ctx) {
        System.out.println("¡visitAll!");
        // Aquí puedes iniciar la verificación semántica global o recorrido del programa
        return visitChildren(ctx);
    }

    @Override
    public Void visitProgram(ExprParser.ProgramContext ctx) {
        currentFunction = "program";
        functionDirectory.put(currentFunction, new FunctionInfo());

        // Procesa variables y funciones primero
        if (ctx.o_vars() != null) visit(ctx.o_vars());
        if (ctx.o_funcs() != null) visit(ctx.o_funcs());

        // Justo antes de entrar al main, actualiza el GOTO
        int indiceMain = cuadruplos.size();
        cuadruplos.get(0).resultado = String.valueOf(indiceMain);
        //Reinicia el contador de temporales para el main
        dirTemporalInt = 9000;
        dirTemporalFloat = 11000;
        dirTemporalBool = 13000;
        // Ahora procesa el body de main
        visit(ctx.body());

        return null;
    }

    

@Override
public Void visitFuncs(ExprParser.FuncsContext ctx) {
    System.out.println("Función detectada: " + ctx.getText());
    String functionName = ctx.ID().getText();
    FunctionInfo functionInfo = new FunctionInfo();
    if(functionDirectory.containsKey(functionName)) {
        System.err.println("Error: La función " + functionName + " ya está definida.");
        throw new RuntimeException("Error: La función " + functionName + " ya está definida.");
    } else {
        System.out.println("Función " + functionName + " registrada.");
        functionDirectory.put(functionName, functionInfo);
        currentFunction = functionName;
    }
    functionInfo.inicioCuadruplo = cuadruplos.size();

    // Reinicia los contadores de temporales y locales para esta función
    dirTemporalInt = 9000;
    dirTemporalFloat = 11000;
    dirTemporalBool = 13000;
    dirVarLocalInt = 5000;
    dirVarLocalFloat = 7000;

    // Procesa parámetros y variables locales
    if (ctx.input() != null) visit(ctx.input());
    if (ctx.o_vars() != null) visit(ctx.o_vars());

    // Procesa el cuerpo de la función
    visit(ctx.body());

    // Al final del body, agrega ENDFunc
    cuadruplos.add(new Cuadruplo("ENDFunc", functionName, "-1", "-1"));

    // Restaura currentFunction (opcional)
    currentFunction = "program";
    return null;
}

    @Override
    public Void visitVariables(ExprParser.VariablesContext ctx) {
        String type = ctx.type().getText();
        List<String> ids = extractIds(ctx.listid());

        for (String id : ids) {
            VariableInfo varInfo = new VariableInfo();
            varInfo.type = type;
            varInfo.name = id;

            if ("program".equals(currentFunction)) {
                // Variables globales: solo revisa duplicados en global
                Map<String, VariableInfo> globalVars = functionDirectory.get("program").variables;
                if (globalVars.containsKey(id)) {
                    throw new RuntimeException("Error: La variable global '" + id + "' ya está declarada.");
                } else {
                    globalVars.put(id, varInfo);
                    System.out.println("Variable global '" + id + "' declarada con tipo: " + type + " y dirección: " + getDireccionVariable(id));
                    functionDirectory.get(currentFunction).recursos.numVariables++;
                    if("int".equals(type)) {
                        functionDirectory.get(currentFunction).recursos.numVariablesInt++;
                    } else if("float".equals(type)) {
                        functionDirectory.get(currentFunction).recursos.numTemporalesFloat++;
                    }

                }
            } else {
                // Variables locales: revisa duplicados en local
                Map<String, VariableInfo> localVars = functionDirectory.get(currentFunction).variables;
                Map<String, VariableInfo> globalVars = functionDirectory.get("program").variables;
                if (localVars.containsKey(id)) {
                    // System.err.println("Error: La variable local '" + id + "' ya está declarada en la función '" + currentFunction + "'.");
                    throw new RuntimeException("Error: La variable local '" + id + "' ya está declarada en la función '" + currentFunction + "'.");
                 } //else if (globalVars.containsKey(id)) {
                //     System.err.println("Error: La variable local '" + id + "' no puede repetir el nombre de una variable global.");
                // } 
                else {
                    localVars.put(id, varInfo); 
                    System.out.println("Variable local '" + id + "' declarada con tipo: " + type + " y dirección: " + getDireccionVariable(id));
                    functionDirectory.get(currentFunction).recursos.numVariables++;
                    if("int".equals(type)) {
                        functionDirectory.get(currentFunction).recursos.numVariablesInt++;
                    } else if("float".equals(type)) {
                        functionDirectory.get(currentFunction).recursos.numTemporalesFloat++;
                    }


                }
            }
        }
        return visitChildren(ctx);
    }

   @Override
    public Void visitInput(ExprParser.InputContext ctx) {
        if (ctx.ID() != null && ctx.type() != null) {
            String paramName = ctx.ID().getText();
            String paramType = ctx.type().getText();

            // Crea VariableInfo para el parámetro
            VariableInfo paramInfo = new VariableInfo();
            paramInfo.name = paramName;
            paramInfo.type = paramType;

            // Asigna dirección local al parámetro ANTES de agregar variables locales
            if ("int".equals(paramType)) {
                paramInfo.direction = dirVarLocalInt++;
            } else if ("float".equals(paramType)) {
                paramInfo.direction = dirVarLocalFloat++;
            } else {
                throw new RuntimeException("Tipo de parámetro no soportado: " + paramType);
            }

            // Guarda el parámetro en el directorio de funciones
            if (currentFunction != null) {
                FunctionInfo funcInfo = functionDirectory.get(currentFunction);
                if (funcInfo != null) {
                    if (funcInfo.parameters.containsKey(paramName)) {
                        throw new RuntimeException("Error: Parámetro '" + paramName + "' ya declarado en función '" + currentFunction + "'");
                    } else {
                        funcInfo.parameters.put(paramName, paramInfo);
                        funcInfo.numParameters++;
                        // También puedes agregarlo a variables locales si lo deseas:
                        funcInfo.variables.put(paramName, paramInfo);
                    }
                }
            }
        }
        // Visita recursivamente listinput si existe
        if (ctx.listinput() != null) {
            visit(ctx.listinput());
        }
        return null;
    }

    // Función auxiliar para extraer todos los IDs de la lista (recursiva)
    private List<String> extractIds(ExprParser.ListidContext ctx) {
        List<String> ids = new ArrayList<>();
        if (ctx == null) return ids;
        ids.add(ctx.ID().getText());
        if (ctx.listid() != null) {
            ids.addAll(extractIds(ctx.listid()));
        }
        return ids;
    }

    // Métodos para manipular las pilas y la fila de cuádruplos
    public void pushOperador(String op) { pilaOperadores.push(op); }
    public String popOperador() { return pilaOperadores.pop(); }
    public void pushOperando(String opnd) { pilaOperandos.push(opnd); }
    public String popOperando() { return pilaOperandos.pop(); }
    public void pushTipo(String tipo) { pilaTipos.push(tipo); }
    public String popTipo() { return pilaTipos.pop(); }
    // public void addCuadruplo(String operador, String op1, String op2, String res) {
    //     cuadruplos.add(new Cuadruplo(operador, op1, op2, res));
    // }
    
    public void addCuadruplo(String operador, int op1, int op2, int res) {

        // if(operador.equals("+")) {
        //     operador = String.valueOf(dirSuma);
        // } else if(operador.equals("-")) {
        //     operador = String.valueOf(dirResta);
        // } else if(operador.equals("*")) {
        //     operador = String.valueOf(dirMultiplicacion);
        // } else if(operador.equals("/")) {
        //     operador = String.valueOf(dirDivision);
        // } else if(operador.equals("<")) {
        //     operador = String.valueOf(dirMenor);
        // } else if(operador.equals(">")) {
        //     operador = String.valueOf(dirMayor);
        // }else if(operador.equals("=")) {
        //     operador = String.valueOf(dirAsignar);
        // }
        cuadruplos.add(new Cuadruplo(operador, String.valueOf(op1), String.valueOf(op2), String.valueOf(res)));
    }

    public List<Cuadruplo> getCuadruplos() { return cuadruplos; }

    @Override
    public Void visitMas_menos(ExprParser.Mas_menosContext ctx) {
        // mas_menos: '+' termino mas_menos | '-' termino mas_menos | (vacío)
        if (ctx.getChildCount() > 0) {
            String op = ctx.getChild(0).getText();
            if (op.equals("+") || op.equals("-")) {
                pilaOperadores.push(op);
                visit(ctx.termino());
                checkOperadorYGeneraCuadruplo(Set.of("+", "-"));
                visit(ctx.mas_menos());
            }
        }
        return null;
    }

    @Override
    public Void visitPor_div(ExprParser.Por_divContext ctx) {
        // por_div: '*' factor por_div | '/' factor por_div | (vacío)
        if (ctx.getChildCount() > 0) {
            String op = ctx.getChild(0).getText();
            if (op.equals("*") || op.equals("/")) {
                pilaOperadores.push(op);
                visit(ctx.factor());
                checkOperadorYGeneraCuadruplo(Set.of("*", "/"));
                visit(ctx.por_div());
            }
        }
        return null;
    }

    @Override
    public Void visitExpresion(ExprParser.ExpresionContext ctx) {
        visit(ctx.exp());       // visita el lado izquierdo
        visit(ctx.op());        // visita el operador relacional y el lado derecho si existe

        // Genera cuádruplo si hay operador relacional
        checkOperadorYGeneraCuadruplo(Set.of(">", "<", "!="));
        return null;
    }

    @Override
    public Void visitAssign(ExprParser.AssignContext ctx) {
        // 1. Visita el ID (variable)
        String id = ctx.ID().getText();
        VariableInfo varInfo = getVariableInfo(id);
        if (varInfo == null) {
            throw new RuntimeException("Error: Variable '" + id + "' no declarada.");
        }
        String tipoVar = varInfo.type;

        // 2. Visita la expresión
        visit(ctx.expresion());

        // 3. Saca el resultado de la expresión
        String resultadoExpresion = pilaOperandos.pop();
        String tipoExpresion = pilaTipos.pop();

        // 4. Verifica tipos usando el cubo semántico
        String tipoResultado = null;
        if (cuboSemantico.containsKey(tipoVar) &&
            cuboSemantico.get(tipoVar).containsKey("=") &&
            cuboSemantico.get(tipoVar).get("=").containsKey(tipoExpresion)) {
            tipoResultado = cuboSemantico.get(tipoVar).get("=").get(tipoExpresion);
        }

        if (tipoResultado == null) {
            throw new RuntimeException("Error semántico: No se puede asignar '" + tipoExpresion + "' a '" + tipoVar + "'.");
        }

        int dirVar = getDireccionVariable(id);
        addCuadruplo("=", Integer.parseInt(resultadoExpresion), -1, dirVar);

        return null;
    }

    @Override
    public Void visitCondition(ExprParser.ConditionContext ctx) {
        // 1. Visita la condición (expresion)
        visit(ctx.expresion());

        // 2. Saca el resultado de la condición
        String resultadoCondicion = pilaOperandos.pop();

        // 3. Genera GOTOF y guarda el salto pendiente
        cuadruplos.add(new Cuadruplo("GOTOF", resultadoCondicion, "-1", "pendiente"));
        pilaSaltos.push(cuadruplos.size() - 1);

        // 4. Visita el bloque del if (body)
        visit(ctx.body());

        if (ctx.elses() != null && ctx.elses().body() != null) {
            // 5. Si hay else, genera un GOTO y actualiza el salto del if
            cuadruplos.add(new Cuadruplo("GOTO", "-1", "-1", "pendiente"));
            int gotoFalso = pilaSaltos.pop();
            pilaSaltos.push(cuadruplos.size() - 1);
            // Rellena el salto falso del if al inicio del else
            cuadruplos.get(gotoFalso).resultado = String.valueOf(cuadruplos.size());
            // Visita el bloque else
            visit(ctx.elses().body());
            // Rellena el GOTO del else al final del else
            int gotoFinal = pilaSaltos.pop();
            cuadruplos.get(gotoFinal).resultado = String.valueOf(cuadruplos.size());
        } else {
            // 6. Si no hay else, rellena el salto falso del if al final del if
            int gotoFalso = pilaSaltos.pop();
            cuadruplos.get(gotoFalso).resultado = String.valueOf(cuadruplos.size());
        }
        return null;
    }
    @Override
    public Void visitPrint(ExprParser.PrintContext ctx) {
        // Si es una cadena
        if (ctx.exps().STRING() != null) {
            String cadena = ctx.exps().STRING().getText();
            cuadruplos.add(new Cuadruplo("PRINT", "-1", "-1", cadena));
        } else {
            // Si es una o varias expresiones
            procesarExps(ctx.exps());
        }
        return null;
    }

    // Método auxiliar para procesar exps recursivamente
    private void procesarExps(ExprParser.ExpsContext ctx) {
        if (ctx == null) return;
        if (ctx.expresion() != null) {
            visit(ctx.expresion());
            String valor = pilaOperandos.pop();
            cuadruplos.add(new Cuadruplo("PRINT", "-1", "-1", valor));
            // Procesar posibles expresiones adicionales (ext)
            if (ctx.ext() != null) {
                procesarExps(ctx.ext().exps());
            }
        } else if (ctx.STRING() != null) {
            String valor = ctx.STRING().getText();
            cuadruplos.add(new Cuadruplo("PRINT", "-1", "-1", valor));
        }
    }
    @Override
    public Void visitCycle(ExprParser.CycleContext ctx) {
        // 1. Marca el inicio del ciclo
        int inicioCiclo = cuadruplos.size();

        // 2. Visita la condición
        visit(ctx.expresion());

        // 3. Saca el resultado de la condición
        String resultadoCondicion = pilaOperandos.pop();

        // 4. Genera GOTOF y guarda el salto pendiente
        cuadruplos.add(new Cuadruplo("GOTOF", resultadoCondicion, "-1", "pendiente"));
        pilaSaltos.push(cuadruplos.size() - 1);

        // 5. Visita el cuerpo del ciclo
        visit(ctx.body());

        // 6. GOTO al inicio del ciclo
        cuadruplos.add(new Cuadruplo("GOTO", "-1", "-1", String.valueOf(inicioCiclo)));

        // 7. Rellena el salto falso para salir del ciclo
        int gotoFalso = pilaSaltos.pop();
        cuadruplos.get(gotoFalso).resultado = String.valueOf(cuadruplos.size());

        return null;
    }

    public void checkOperadorYGeneraCuadruplo(Set<String> operadoresEsperados) {
        if (!pilaOperadores.isEmpty()) {
            String operador = pilaOperadores.peek();
            if (operadoresEsperados.contains(operador)) {
                pilaOperadores.pop();
                String arg2 = pilaOperandos.pop();
                String arg1 = pilaOperandos.pop();
                String tipo2 = pilaTipos.pop();
                String tipo1 = pilaTipos.pop();

                // Consulta el cubo semántico
                String tipoResultado = null;
                if (cuboSemantico.containsKey(tipo1) &&
                    cuboSemantico.get(tipo1).containsKey(operador) &&
                    cuboSemantico.get(tipo1).get(operador).containsKey(tipo2)) {
                    tipoResultado = cuboSemantico.get(tipo1).get(operador).get(tipo2);
                }

                if (tipoResultado == null) {
                    throw new RuntimeException("Error semántico: No se puede aplicar el operador '" + operador +
                            "' entre '" + tipo1 + "' y '" + tipo2 + "'");
                }

                int dirArg1 = arg1.matches("\\d+") ? Integer.parseInt(arg1) : getDireccionVariable(arg1);
                int dirArg2 = arg2.matches("\\d+") ? Integer.parseInt(arg2) : getDireccionVariable(arg2);

                int dirTemp = generarDireccionTemporal(tipoResultado);
                addCuadruplo(operador, dirArg1, dirArg2, dirTemp);
                pilaOperandos.push(String.valueOf(dirTemp));
                pilaTipos.push(tipoResultado);
            }
        }
    }

@Override
public Void visitF_call(ExprParser.F_callContext ctx) {
    String functionName = ctx.ID().getText();

    // 1. ERA
    cuadruplos.add(new Cuadruplo("ERA", functionName, "-1", "-1"));

    // 2. PARAMETER para cada argumento
    if (ctx.list_exp() != null) {
        List<String> argumentos = obtenerArgumentos(ctx.list_exp());
        FunctionInfo funcInfo = functionDirectory.get(functionName);
        int paramIndex = 0;
        for (String arg : argumentos) {
            int dirArg = arg.matches("\\d+") ? Integer.parseInt(arg) : getDireccionVariable(arg);
            cuadruplos.add(new Cuadruplo("PARAMETER", String.valueOf(dirArg), "-1", String.valueOf(paramIndex)));
            paramIndex++;
        }
    }

    // 3. GOSUB
    int inicioFuncion = functionDirectory.get(functionName).inicioCuadruplo;
    cuadruplos.add(new Cuadruplo("GOSUB", functionName, "-1", String.valueOf(inicioFuncion)));

    return null;
}

// Método auxiliar para obtener argumentos de list_exp
private List<String> obtenerArgumentos(ExprParser.List_expContext ctx) {
    List<String> args = new ArrayList<>();
    if (ctx == null) return args;
    if (ctx.expresion() != null) {
        visit(ctx.expresion());
        args.add(pilaOperandos.pop());
        if (ctx.mas_exp() != null) {
            args.addAll(obtenerArgumentos(ctx.mas_exp().list_exp()));
        }
    }
    return args;
}

@Override
public Void visitIdcte(ExprParser.IdcteContext ctx) {
    String valor = ctx.getText();
    String tipo;
    int direccion;

    if (ctx.ID() != null) {
        String id = ctx.ID().getText();
        VariableInfo var = getVariableInfo(id);
        if (var == null) {
            throw new RuntimeException("Variable '" + id + "' no declarada.");
        }
        tipo = var.type;
        direccion = getDireccionVariable(id);
    } else if (ctx.INT() != null || ctx.FLOAT() != null) {
        tipo = ctx.INT() != null ? "int" : "float";
        direccion = getDireccionConstante(valor, tipo);
    } else {
        System.err.println("Error: Tipo desconocido para valor '" + valor + "'.");
        return null;
    }

    pilaOperandos.push(String.valueOf(direccion));
    pilaTipos.push(tipo);
    //System.out.println("Push operando: " + valor + " (dir: " + direccion + ") con tipo: " + tipo);
    return null;
}

@Override
public Void visitOpt(ExprParser.OptContext ctx) {
    if (ctx.expresion() != null) {
        visit(ctx.expresion());
    } else if (ctx.idcte() != null) {
        visit(ctx.idcte());
    }
    return null;
}

@Override
public Void visitFactor(ExprParser.FactorContext ctx) {
    return visit(ctx.opt());
}

@Override
public Void visitTermino(ExprParser.TerminoContext ctx) {
    visit(ctx.factor());
    visit(ctx.por_div());
    return null;
}

@Override
public Void visitExp(ExprParser.ExpContext ctx) {
    visit(ctx.termino());
    visit(ctx.mas_menos());
    return null;
}

@Override
public Void visitOp(ExprParser.OpContext ctx) {
    if (ctx.tokenop() != null) {
        visit(ctx.tokenop());
    }
    return null;
}

@Override
public Void visitTokenop(ExprParser.TokenopContext ctx) {
    if (ctx.getChildCount() >= 2) {
        String op = ctx.getChild(0).getText(); // '>', '<', '!='
        pilaOperadores.push(op);
        System.out.println("Push operador relacional: " + op);
        visit(ctx.exp());
    }
    return null;
}

private VariableInfo getVariableInfo(String id) {
    if (currentFunction != null && functionDirectory.get(currentFunction).variables.containsKey(id)) {
        return functionDirectory.get(currentFunction).variables.get(id);
    } else if (functionDirectory.get("program").variables.containsKey(id)) {
        return functionDirectory.get("program").variables.get(id);
    } else {
        return null;
    }
}

public void imprimirMemoriaVirtual() {
    System.out.println("Mapa de memoria constante:");
    for (Map.Entry<String, Integer> entry : memoriaConstantes.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
}

public Ovejota getOvejota() {
    Ovejota ovejota = new Ovejota();
    ovejota.functionDirectory = this.functionDirectory;
    ovejota.memoriaConstantes = this.memoriaConstantes;
    ovejota.cuadruplos = this.cuadruplos;
    return ovejota;
}

// Cubo semántico: tipo1 -> operador -> tipo2 -> tipoResultado
private static final Map<String, Map<String, Map<String, String>>> cuboSemantico = new HashMap<>();

static {
    Map<String, Map<String, String>> intOps = new HashMap<>();
    Map<String, String> intPlus = new HashMap<>();
    intPlus.put("int", "int");
    intPlus.put("float", "float");
    intOps.put("+", intPlus);

    Map<String, String> intMinus = new HashMap<>();
    intMinus.put("int", "int");
    intMinus.put("float", "float");
    intOps.put("-", intMinus);

    Map<String, String> intMultiplication = new HashMap<>();
    intMultiplication.put("int", "int");
    intMultiplication.put("float", "float");
    intOps.put("*", intMultiplication);

    Map<String, String> intDivision = new HashMap<>();
    intDivision.put("int", "int");
    intDivision.put("float", "float");
    intOps.put("/", intDivision);

    Map<String, String> intAsignar = new HashMap<>();
    intAsignar.put("int", "int");
    //intAsignar.put("float", "float");
    intOps.put("=", intAsignar);

    Map<String, String> intDistinto = new HashMap<>();
    intDistinto.put("int", "bool");
    intDistinto.put("float", "bool");
    intOps.put("!=", intDistinto);
    Map<String, String> intMayor = new HashMap<>();
    intMayor.put("int", "bool");
    intMayor.put("float", "bool");
    intOps.put(">", intMayor);
    Map<String, String> intMenor = new HashMap<>();
    intMenor.put("int", "bool");
    intMenor.put("float", "bool");
    intOps.put("<", intMenor);

    cuboSemantico.put("int", intOps);

    Map<String, Map<String, String>> floatOps = new HashMap<>();
    Map<String, String> floatPlus = new HashMap<>();
    floatPlus.put("int", "float");
    floatPlus.put("float", "float");
    floatOps.put("+", floatPlus);

    Map<String, String> floatMinus = new HashMap<>();
    floatMinus.put("int", "float");
    floatMinus.put("float", "float");
    floatOps.put("-", floatMinus);

    Map<String, String> floatMultiplication = new HashMap<>();
    floatMultiplication.put("int", "float");
    floatMultiplication.put("float", "float");
    floatOps.put("*", floatMultiplication);

    Map<String, String> floatDivision = new HashMap<>();
    floatDivision.put("int", "float");
    floatDivision.put("float", "float");
    floatOps.put("/", floatDivision);

    Map<String, String> floatAsignar = new HashMap<>();
    floatAsignar.put("int", "float");
    floatAsignar.put("float", "float");
    floatOps.put("=", floatAsignar);
    
    Map<String, String> floatDistinto = new HashMap<>();
    floatDistinto.put("int", "bool");
    floatDistinto.put("float", "bool");
    floatOps.put("!=", floatDistinto);
    Map<String, String> floatMayor = new HashMap<>();
    floatMayor.put("int", "bool");
    floatMayor.put("float", "bool");
    floatOps.put(">", floatMayor);
    Map<String, String> floatMenor = new HashMap<>();
    floatMenor.put("int", "bool");
    floatMenor.put("float", "bool");
    floatOps.put("<", floatMenor);


    cuboSemantico.put("float", floatOps);
}

}
