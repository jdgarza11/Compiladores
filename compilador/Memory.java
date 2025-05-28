import java.util.Map;

public class Memory {

    private Map<Integer, Integer> enteros;
    private Map<Integer, Boolean> booleanos;
    private Map<Integer, Float> flotantes;

    public Memory() {
        this.enteros = new java.util.HashMap<>();
        this.booleanos = new java.util.HashMap<>();
        this.flotantes = new java.util.HashMap<>();
    }

    public void put(int direccion, int valor) {
        enteros.put(direccion, valor);
    }

    public void put(int direccion, boolean valor) {
        booleanos.put(direccion, valor);
    }

    public void put(int direccion, float valor) {
        flotantes.put(direccion, valor);
    }

    public int getInt(int direccion) {
        return enteros.getOrDefault(direccion, 0);
    }

}
