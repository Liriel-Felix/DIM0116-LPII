package src;

public interface Fila<T> {
    void enfileirar(T obj);  
    T desenfileirar();       
    int tamanho();           
}