import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorNumeros {
    public static void main(String[] args) throws IOException {
        // Nome do arquivo que será lido
        String nomeArquivo = "dados.txt";

        // Abre o arquivo
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

        String linha;
        while ((linha = br.readLine()) != null) {
            // Converte a linha para número inteiro
            int numero = Integer.parseInt(linha);

            // Regra de negócio: não pode número negativo
            if (numero < 0) {
                // Aqui os alunos devem lançar a exceção personalizada
                System.out.println("Número inválido detectado!");
            }

            System.out.println("Número lido: " + numero);
        }

        br.close();
        System.out.println("Leitura concluída!");
    }
}