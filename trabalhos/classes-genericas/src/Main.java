public class Main {
    public static void main(String[] args) {
        // Teste com Strings
        System.out.println("=== TESTANDO COM STRINGS ===");
        Repositorio<String> repoStrings = new Repositorio<>();
        
        repoStrings.adicionar("Banana");
        repoStrings.adicionar("Maçã");
        repoStrings.adicionar("Pera");
        
        System.out.println("Itens no repositório:");
        repoStrings.listar();
        
        System.out.println("\nBuscando 'Maçã':");
        String encontrado = repoStrings.buscar("Maçã");
        System.out.println("Encontrado: " + encontrado);
        
        // Teste com Alunos
        System.out.println("\n=== TESTANDO COM ALUNOS ===");
        Repositorio<Aluno> repoAlunos = new Repositorio<>();
        
        Aluno aluno1 = new Aluno("001", "João Silva");
        Aluno aluno2 = new Aluno("002", "Maria Santos");
        Aluno aluno3 = new Aluno("003", "Pedro Costa");
        
        repoAlunos.adicionar(aluno1);
        repoAlunos.adicionar(aluno2);
        repoAlunos.adicionar(aluno3);
        
        System.out.println("Alunos no repositório:");
        repoAlunos.listar();
        
        System.out.println("\nBuscando aluno '002 - Maria Santos':");
        Aluno alunoEncontrado = repoAlunos.buscar("002 - Maria Santos");
        System.out.println("Aluno encontrado: " + alunoEncontrado);
        
        // Testando remoção
        System.out.println("\nRemovendo o aluno João...");
        repoAlunos.remover(aluno1);
        System.out.println("Alunos após remoção:");
        repoAlunos.listar();
        
        // Busca que não encontra
        System.out.println("\nBuscando 'Ana' (que não existe):");
        Aluno naoEncontrado = repoAlunos.buscar("Ana");
        System.out.println("Resultado: " + naoEncontrado);
    }
}