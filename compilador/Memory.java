import java.util.Map;

public class Memory {

    Map<Integer, Integer> enteros;
    private Map<Integer, Boolean> booleanos;
    Map<Integer, Float> flotantes;

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

    public void imprimir(String etiqueta) {
    for (Map.Entry<Integer, Integer> entry : enteros.entrySet()) {
        System.out.println(etiqueta + " [int] " + entry.getKey() + " = " + entry.getValue());
    }
    for (Map.Entry<Integer, Float> entry : flotantes.entrySet()) {
        System.out.println(etiqueta + " [float] " + entry.getKey() + " = " + entry.getValue());
    }
    for (Map.Entry<Integer, Boolean> entry : booleanos.entrySet()) {
        System.out.println(etiqueta + " [bool] " + entry.getKey() + " = " + entry.getValue());
    }
}

}
