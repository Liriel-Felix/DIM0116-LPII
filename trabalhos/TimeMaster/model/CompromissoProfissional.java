package model;

public class CompromissoProfissional extends Compromisso {
    
    public CompromissoProfissional(String id, java.time.LocalDateTime dataHora, String descricao, 
                                  int prioridade, String categoria) {
        super(id, dataHora, descricao, prioridade, categoria);
    }
    
    @Override
    public String toString() {
        return String.format("CompromissoProfissional{id='%s', dataHora=%s, descricao='%s', " +
                "prioridade=%d, categoria='%s'}",
                getId(), getDataHora(), getDescricao(), getPrioridade(), getCategoria());
    }
}