
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("======== INICIANDO TESTE ========");
        System.out.println();
        
        System.out.println("1. Gerando 100.000 números aleatórios...");
        int[] numerosOriginais = new int[100000];
        Random random = new Random();
        
        for (int i = 0; i < 100000; i++) {
            numerosOriginais[i] = random.nextInt(1000000);
        }
        System.out.println("[OK] 100.000 números gerados!");
        System.out.println();
        
        int[] paraBubble = Ordenacao.copiarArray(numerosOriginais);
        int[] paraQuick = Ordenacao.copiarArray(numerosOriginais);
        
        System.out.println("2. Executando BubbleSort...");
        long inicioBubble = System.nanoTime();
        Ordenacao.bubbleSort(paraBubble);  
        long fimBubble = System.nanoTime();
        long tempoBubble = fimBubble - inicioBubble;
        System.out.println("[OK] BubbleSort concluído!");
        System.out.println();
        
        System.out.println("3. Executando QuickSort...");
        long inicioQuick = System.nanoTime();
        Ordenacao.quickSort(paraQuick, 0, paraQuick.length - 1);  
        long fimQuick = System.nanoTime();
        long tempoQuick = fimQuick - inicioQuick;
        System.out.println("[OK] QuickSort concluído!");
        System.out.println();
        
        System.out.println("\n ======== RELATÓRIO COMPARATIVO ========");
        System.out.println("Tempo do BubbleSort: " + tempoBubble + " nanosegundos");
        System.out.println("Tempo do QuickSort:  " + tempoQuick + " nanosegundos");
        System.out.println();
        
        double segundosBubble = tempoBubble / 1_000_000_000.0;
        double segundosQuick = tempoQuick / 1_000_000_000.0;
        System.out.printf("Tempo BubbleSort: %.2f segundos\n", segundosBubble);
        System.out.printf("Tempo QuickSort:  %.2f segundos\n", segundosQuick);
        
        if (tempoQuick < tempoBubble) {
            double vezesMaisRapido = (double) tempoBubble / tempoQuick;
            System.out.printf("\n QuickSort foi %.1f vezes mais rápido!\n", vezesMaisRapido);
            System.out.println("• Explicação: o QuickSort divide o array usando um pivô, organizando dados em \"menores\" e \"maiores\" recursivamente. Essa é uma estratégia inteligente que evita comparações desnecessárias. Já o BubbleSort compara cada elemento com todos os outros sequencialmente, é um método simples mas muito ineficiente para grandes volumes de dados.");
        } else {
            double vezesMaisRapido = (double) tempoQuick / tempoBubble;
            System.out.printf("\n BubbleSort foi %.1f vezes mais rápido!\n", vezesMaisRapido);
            System.out.println("• Explicação: Esse caso só ocorre se os dados já estiverem quase ordenados. BubbleSort detecta rapidamente e finaliza. Já o QuickSort, mesmo com dados organizados, ainda executa todo o processo de particionamento, podendo ser menos eficiente nesse caso específico.");
        }
    }
}