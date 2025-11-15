package src;

import java.util.ArrayDeque;

public class FilaArrayDeque<T> implements Fila<T> {
    private ArrayDeque<T> deque = new ArrayDeque<>();
    
    @Override
    public void enfileirar(T obj) {
        deque.addLast(obj); 
    }
    
    @Override
    public T desenfileirar() {
        return deque.pollFirst(); 
    }
    
    @Override
    public int tamanho() {
        return deque.size();
    }
}
