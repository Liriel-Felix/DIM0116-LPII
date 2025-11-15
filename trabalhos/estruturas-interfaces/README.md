# Estruturas e Interfaces (2 pts)
**Aluna:** Liriel Felix
 
**Data de entrega:** 16/11/2025
 
Você deverá criar a interface genérica Fila<T> que represente uma fila (estrutura de dados FIFO – First In, First Out).
 
## Requisitos:

- A interface deve conter os métodos:
- void enfileirar(T obj)
- T desenfileirar()
- int tamanho()
- Implementar duas versões concretas:
- FilaLinkedList<T> usando LinkedList<T>
- FilaArrayDeque<T> usando ArrayDeque<T>
- Criar uma classe Cliente (com atributos nome e senha) e simular um sistema de fila de atendimento:
- Inserir clientes na fila.
- Atender clientes na ordem correta.
- Mostrar a quantidade de clientes aguardando.
 
## Critérios de Avaliação (2 pts)
- 0,5 pt → Definiu corretamente a interface Fila<T>.
- 0,5 pt → Implementação funcional com LinkedList.
- 0,5 pt → Implementação funcional com ArrayDeque.
- 0,5 pt → Demonstração da simulação de atendimento no Main.

## Como compilar

```bash
cd src
javac *.java
java Main
```