import java.util.HashMap;
import java.util.Map;

public class FunctionInfo {
    public String returnType;
    public Recursos recursos = new Recursos();
    public Map<String, VariableInfo> parameters = new HashMap<>();
    public Integer numParameters = 0;
    public Map<String, VariableInfo> variables = new HashMap<>();
    public int inicioCuadruplo = -1; // Indica el inicio de los cuadruplos para esta función
}