package src;

import java.util.LinkedList;

public class FilaLinkedList<T> implements Fila<T> {
    private LinkedList<T> lista = new LinkedList<>();
    
    @Override
    public void enfileirar(T obj) {
        lista.addLast(obj);  
    }
    
    @Override
    public T desenfileirar() {
        if (lista.isEmpty()) {
            return null; 
        }
        return lista.removeFirst(); 
    }
    
    @Override
    public int tamanho() {
        return lista.size();
    }
}