import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {
    private List<T> objetos;

    public Repositorio() {
        objetos = new ArrayList<>();
    }

    public void adicionar(T obj) {
        objetos.add(obj);
    }

    public void remover(T obj) {
        objetos.remove(obj);
    }

    public T buscar(String chave) {
        for (T obj : objetos) {
            if (obj.toString().equals(chave)) {
                return obj;
            }
        }
        return null;
    }

    public void listar() {
        for (T obj : objetos) {
            System.out.println(obj);
        }
    }
}