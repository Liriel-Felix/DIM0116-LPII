package util;

import java.util.Comparator;
import java.util.List;

public class HeapSort {
    public static <T> void ordenar(List<T> lista, Comparator<T> comparador) {
        int n = lista.size();
        
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(lista, n, i, comparador);
        
        for (int i = n - 1; i > 0; i--) {
            T temp = lista.get(0);
            lista.set(0, lista.get(i));
            lista.set(i, temp);
            heapify(lista, i, 0, comparador);
        }
    }
    
    private static <T> void heapify(List<T> lista, int n, int i, Comparator<T> comparador) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        
        if (esquerda < n && comparador.compare(lista.get(esquerda), lista.get(maior)) > 0)
            maior = esquerda;
        
        if (direita < n && comparador.compare(lista.get(direita), lista.get(maior)) > 0)
            maior = direita;
        
        if (maior != i) {
            T swap = lista.get(i);
            lista.set(i, lista.get(maior));
            lista.set(maior, swap);
            heapify(lista, n, maior, comparador);
        }
    }
}