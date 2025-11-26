package service;

import model.Compromisso;
import repository.RepositorioHash;
import util.NegocioException;
import java.util.Comparator;
import java.util.List;

public class AgendaService {
    private RepositorioHash repositorio = new RepositorioHash();
    
    public void cadastrarCompromisso(Compromisso compromisso) throws NegocioException {
        repositorio.salvar(compromisso);
    }
    
    public List<Compromisso> listarTodosCompromissos() {
        return repositorio.listarTodos();
    }
    
    public void removerCompromisso(String id) {
        repositorio.remover(id);
    }
    
public void editarCompromisso(String id, Compromisso novoCompromisso) throws NegocioException {
    repositorio.remover(id, true); 
    repositorio.salvar(novoCompromisso);
}
    
    public List<Compromisso> ordenarPorData() {
        List<Compromisso> compromissos = listarTodosCompromissos();
        util.HeapSort.ordenar(compromissos, Comparator.comparing(Compromisso::getDataHora));
        return compromissos;
    }
    
    public List<Compromisso> ordenarPorPrioridade() {
        List<Compromisso> compromissos = listarTodosCompromissos();
        util.HeapSort.ordenar(compromissos, 
            Comparator.comparing(Compromisso::getPrioridade).reversed());
        return compromissos;
    }
    
    public List<Compromisso> ordenarPorCategoria() {
        List<Compromisso> compromissos = listarTodosCompromissos();
        util.HeapSort.ordenar(compromissos, 
            Comparator.comparing(Compromisso::getCategoria));
        return compromissos;
    }
}