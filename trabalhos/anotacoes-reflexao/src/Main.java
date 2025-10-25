public class Main {
    public static void main(String[] args) {
        System.out.println("Buscando classes com anotação...\n");
        
        Class<?>[] classesParaVerificar = {Usuario.class, Produto.class, String.class};
        
        for (Class<?> classe : classesParaVerificar) {

            if (classe.isAnnotationPresent(InfoAutor.class)) {
                InfoAutor anotacao = classe.getAnnotation(InfoAutor.class);
                
                System.out.println("Classe: " + classe.getSimpleName());
                System.out.println("Autor: " + anotacao.nome());
                System.out.println("Data: " + anotacao.data());
                System.out.println("------------------------");
            }
        }
    }
}