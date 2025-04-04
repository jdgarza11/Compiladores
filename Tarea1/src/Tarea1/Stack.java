package Tarea1;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> elements = new ArrayList<>();

    public void push(T value) {
        elements.add(value);
    }
    public T pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
