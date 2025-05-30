public class Recursos {
    public int numVariables = 0;
    public int numTemporales = 0;
    public int numVariablesInt = 0;
    public int numVariablesFloat = 0;
    public int numTemporalesInt = 0;
    public int numTemporalesFloat = 0;
    public int numTemporalesBool = 0;

    @Override
    public String toString() {
        return "Variables: " + numVariables + ", Temporales: " + numTemporales;
    }
}