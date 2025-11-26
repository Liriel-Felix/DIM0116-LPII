package model;

public class CompromissoPessoal extends Compromisso {
    
    public CompromissoPessoal(String id, java.time.LocalDateTime dataHora, String descricao, 
                             int prioridade, String categoria) {
        super(id, dataHora, descricao, prioridade, categoria);
    }
    
    @Override
    public String toString() {
        return String.format("CompromissoPessoal{id='%s', dataHora=%s, descricao='%s', " +
                "prioridade=%d, categoria='%s'}",
                getId(), getDataHora(), getDescricao(), getPrioridade(), getCategoria());
    }
}