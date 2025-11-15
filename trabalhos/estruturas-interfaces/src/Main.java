package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fila com LinkedList");
        Fila<Cliente> filaLikedList = new FilaLinkedList<>();
        
        // Adicionando clientes
        filaLikedList.enfileirar(new Cliente("João", 1));
        filaLikedList.enfileirar(new Cliente("Maria", 2));
        filaLikedList.enfileirar(new Cliente("Pedro", 3));
        
        System.out.println("Clientes na fila: " + filaLikedList.tamanho());
        
        // Atendendo clientes (FIFO - primeiro a entrar, primeiro a sair)
        System.out.println("\nAtendendo clientes:");
        while (filaLikedList.tamanho() > 0) {
            Cliente clienteAtendido = filaLikedList.desenfileirar();
            System.out.println("Atendendo: " + clienteAtendido);
            System.out.println("Clientes aguardando: " + filaLikedList.tamanho());
        }
        
        // Testando com ArrayDeque
        System.out.println("\nFila com ArrayDeque ");
        Fila<Cliente> filaArrayDeque = new FilaArrayDeque<>();
        
        // Adicionando clientes
        filaArrayDeque.enfileirar(new Cliente("Ana", 4));
        filaArrayDeque.enfileirar(new Cliente("Carlos", 5));
        filaArrayDeque.enfileirar(new Cliente("Julia", 6));
        
        System.out.println("Clientes na fila: " + filaArrayDeque.tamanho());
        
        // Atendendo clientes
        System.out.println("\nAtendendo clientes:");
        while (filaArrayDeque.tamanho() > 0) {
            Cliente clienteAtendido = filaArrayDeque.desenfileirar();
            System.out.println("Atendendo: " + clienteAtendido);
            System.out.println("Clientes aguardando: " + filaArrayDeque.tamanho());
        }
    }
}
