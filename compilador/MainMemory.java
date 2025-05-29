public class MainMemory {
    public Memory memoriaConstante;
    public Memory memoriaGlobal;
    public Memory memoriaTemporal;

    public void imprimir() {
    System.out.println("=== MainMemory ===");

    if (memoriaGlobal != null) {
        System.out.println("Memoria Global:");
        memoriaGlobal.imprimir("Global");
    }
    if (memoriaConstante != null) {
        System.out.println("Memoria Constante:");
        memoriaConstante.imprimir("Constante");
    }
    if (memoriaTemporal != null) {
        System.out.println("Memoria Temporal:");
        memoriaTemporal.imprimir("Temporal");
    }
}
}
