package Tarea1;

public class App {
    public static void main(String[] args) throws Exception {

        // Ejemplo de uso de Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack pop: " + stack.pop());

        // Ejemplo de uso de Queue
        Queue<String> queue = new Queue<>();
        queue.enqueue("Primero");
        queue.enqueue("Segundo");
        System.out.println("Queue dequeue: " + queue.dequeue());

        // Ejemplo de uso de Dictionary
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Uno", 1);
        dictionary.put("Dos", 2);
        System.out.println("Dictionary get 'Uno': " + dictionary.get("Uno"));
    }

    

}