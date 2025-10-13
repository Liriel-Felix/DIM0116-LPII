import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MinhaExcecao extends Exception {
    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}

public class LeitorNumeros {
    public static void main(String[] args) {
        String nomeArquivo = "dados.txt";
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(nomeArquivo));
            System.out.println("Arquivo aberto com sucesso!\n");
            
            String linha;
            int numero;
            int linhaNumero = 0;
            
            while ((linha = br.readLine()) != null) {
                linhaNumero++;
                
                try {
                    numero = Integer.parseInt(linha);
                    
                    if (numero <= 0) {
                        throw new MinhaExcecao(" Número negativo ou zero não permitido");
                    }
                    
                    System.out.println("[OK] Número lido: " + numero);
                    
                } catch (NumberFormatException e) {
                    System.out.println("[ERRO] Formato inválido na linha " + linhaNumero + ": '" + linha + "'");
                } catch (MinhaExcecao e) {
                    System.out.println("[ERRO]" + e.getMessage() + " na linha " + linhaNumero + ": " + linha);
                }
            }
            
        } catch (IOException e) {
            System.out.println("Erro: arquivo não encontrado.");
        } finally {
            try {
                if (br != null) {
                    br.close();
                    System.out.println("\nLeitura concluída!");
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
    }
}