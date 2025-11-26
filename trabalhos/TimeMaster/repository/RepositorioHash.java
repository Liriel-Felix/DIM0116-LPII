package repository;

import model.Compromisso;
import util.InfoAutor;
import util.NegocioException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@InfoAutor(nome = "TimeMaster Team", matricula = "TM001", versao = "1.0")
public class RepositorioHash {
    private List<Compromisso> compromissos = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public void salvar(Compromisso entity) throws NegocioException {
        // Verificar conflito de horário
        for (Compromisso c : compromissos) {
            if (c.getDataHora().equals(entity.getDataHora()) && !c.getId().equals(entity.getId())) {
                throw new NegocioException("Conflito de horário com: " + c.getDescricao() + 
                                         " (" + c.getId() + ") em " + 
                                         entity.getDataHora().format(formatter));
            }
        }
        
        for (int i = 0; i < compromissos.size(); i++) {
            if (compromissos.get(i).getId().equals(entity.getId())) {
                compromissos.set(i, entity);
                return;
            }
        }
        
        compromissos.add(entity);
    }
    
    public List<Compromisso> listarTodos() {
        compromissos.sort((c1, c2) -> c1.getDataHora().compareTo(c2.getDataHora()));
        return new ArrayList<>(compromissos);
    }
    
    public void remover(String id) {
        remover(id, false);
    }
    
    public void remover(String id, boolean silencioso) {
        for (int i = 0; i < compromissos.size(); i++) {
            if (compromissos.get(i).getId().equals(id)) {
                compromissos.remove(i);
                if (!silencioso) {
                    System.out.println("[OK] Compromisso removido: " + id);
                }
                return;
            }
        }
        if (!silencioso) {
            System.out.println("[INFO] Compromisso não encontrado: " + id);
        }
    }
    
    public boolean estaVazio() {
        return compromissos.isEmpty();
    }
}