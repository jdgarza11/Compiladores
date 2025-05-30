public class MainMemory {
    public Memory memoriaConstante;
    public Memory memoriaGlobal;
    //public Memory memoriaActual;

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
        // if (memoriaActual != null) {
        //     System.out.println("Memoria Activa:");
        //     memoriaActual.imprimir("Variable");
        // }
    }
    
}
