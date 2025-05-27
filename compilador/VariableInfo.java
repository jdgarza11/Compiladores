import java.util.HashMap;
import java.util.Map;

public class VariableInfo {
    public String name;
    public String scope;
    public String type;
    public int direction;

    public String Imprimir() {
        return "Variable: " + name + ", Tipo: " + type + ", Direccion: " + direction;
    }
}