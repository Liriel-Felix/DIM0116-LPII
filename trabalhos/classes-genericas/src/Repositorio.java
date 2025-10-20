import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List objetos;

    public Repositorio() {
        objetos = new ArrayList();
    }

    public void adicionar(Object obj) {
        objetos.add(obj);
    }

    public void remover(Object obj) {
        objetos.remove(obj);
    }

    public Object buscar(String chave) {
        for (Object obj : objetos) {
            // Comparação simplificada - aluno deve generalizar
            if (obj.toString().equalsIgnoreCase(chave)) {
                return obj;
            }
        }
        return null;
    }

    public void listar() {
        for (Object obj : objetos) {
            System.out.println(obj);
        }
    }
}
