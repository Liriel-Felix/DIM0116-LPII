public class Main {
    public static void main(String[] args) {
        // Repositório sem Generics - aluno deve arrumar
        Repositorio repo = new Repositorio();

        // Testando com String
        repo.adicionar("Banana");
        repo.adicionar("Maçã");

        // Testando com Aluno
        Aluno a1 = new Aluno("2021001", "Maria");
        Aluno a2 = new Aluno("2021002", "João");

        repo.adicionar(a1);
        repo.adicionar(a2);

        System.out.println("Busca por João:");
        Object resultado = repo.buscar("João");
        System.out.println(resultado);

        System.out.println("\nListando todos:");
        repo.listar();
    }
}
