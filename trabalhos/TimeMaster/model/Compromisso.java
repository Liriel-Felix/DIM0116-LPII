package model;

import util.InfoAutor;

@InfoAutor(nome = "TimeMaster Team", matricula = "TM001", versao = "1.0")
public abstract class Compromisso implements Comparable<Compromisso> {
    protected String id;
    protected java.time.LocalDateTime dataHora;
    protected String descricao;
    protected int prioridade;
    protected String categoria;
    
    public Compromisso(String id, java.time.LocalDateTime dataHora, String descricao, 
                      int prioridade, String categoria) {
        if (dataHora.isBefore(java.time.LocalDateTime.now())) {
            throw new IllegalArgumentException("Data não pode ser passada");
        }
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.categoria = categoria;
    }
    
    public String getId() { return id; }
    public java.time.LocalDateTime getDataHora() { return dataHora; }
    public String getDescricao() { return descricao; }
    public int getPrioridade() { return prioridade; }
    public String getCategoria() { return categoria; }
    
    @Override
    public int compareTo(Compromisso outro) {
        return this.dataHora.compareTo(outro.dataHora);
    }
}