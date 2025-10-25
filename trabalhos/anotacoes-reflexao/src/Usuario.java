@InfoAutor(
    nome = "João Silva",
    data = "20/10/2025"
)

public class Usuario {
    private String nome;
    
    public Usuario(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}