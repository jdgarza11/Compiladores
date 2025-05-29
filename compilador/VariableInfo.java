import java.util.HashMap;
import java.util.Map;

public class VariableInfo {
    public String name;
    public String type;
    public Integer direction;

    public String Imprimir() {
        return "Variable: " + name + ", Tipo: " + type + ", Direccion: " + direction;
    }
}