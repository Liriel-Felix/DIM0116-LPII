package src;

public class Cliente {
    private String nome;
    private int senha;
    
    public Cliente(String nome, int senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getSenha() {
        return senha;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nome + " (Senha: " + senha + ")";
    }
}
