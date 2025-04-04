    package Tarea1;

    import java.util.ArrayList;
    public class Queue<T> {
        private ArrayList<T> elements = new ArrayList<>();

        public void enqueue(T value) {
            elements.add(value);
        }

        public T dequeue() {
            if (elements.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return elements.remove(0);
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }
    }