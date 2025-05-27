import java.util.HashMap;
import java.util.Map;

public class FunctionInfo {
    public String returnType;
    public String recursos;
    public Map<String, VariableInfo> parameters = new HashMap<>();
    public Map<String, VariableInfo> variables = new HashMap<>();
}