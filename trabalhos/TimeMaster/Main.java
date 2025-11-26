import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static service.AgendaService agenda = new service.AgendaService();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public static void main(String[] args) {
        System.out.println("=== TIMEMASTER - SISTEMA DE AGENDA ===");
        mostrarMenuPrincipal();
    }
    
    private static void mostrarMenuPrincipal() {
        while (true) {
            try {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Cadastrar compromisso");
                System.out.println("2. Listar compromissos");
                System.out.println("3. Buscar compromisso");
                System.out.println("4. Editar compromisso");
                System.out.println("5. Remover compromisso");
                System.out.println("6. Ordenar compromissos");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                
                switch (opcao) {
                    case 1: cadastrarCompromisso(); break;
                    case 2: listarCompromissos(); break;
                    case 3: buscarCompromisso(); break;
                    case 4: editarCompromisso(); break;
                    case 5: removerCompromisso(); break;
                    case 6: ordenarCompromissos(); break;
                    case 7: 
                        System.out.println("Saindo do sistema...");
                        return;
                    default: 
                        System.out.println("Opção inválida! Digite um número de 1 a 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números no menu!");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }
    
    private static void cadastrarCompromisso() {
        try {
            System.out.println("\n--- CADASTRAR COMPROMISSO ---");
            
            int tipo = 0;
            while (tipo != 1 && tipo != 2) {
                try {
                    System.out.print("Tipo (Pessoal = 1, Profissional = 2): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Digite apenas 1 ou 2!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite apenas 1 ou 2!");
                    scanner.nextLine(); // Limpar buffer
                }
            }
            
            System.out.print("ID: ");
            String id = scanner.nextLine();
            
            LocalDateTime dataHora = null;
            while (dataHora == null) {
                try {
                    System.out.print("Data e Hora (dd/MM/yyyy HH:mm): ");
                    String dataHoraStr = scanner.nextLine();
                    dataHora = LocalDateTime.parse(dataHoraStr, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato inválido! Use: dd/MM/yyyy HH:mm (ex: 25/12/2024 14:30)");
                }
            }
            
            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();
            
            int prioridade = 0;
            while (prioridade < 1 || prioridade > 5) {
                try {
                    System.out.print("Prioridade (1-5): ");
                    prioridade = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (prioridade < 1 || prioridade > 5) {
                        System.out.println("Digite um número entre 1 e 5!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite apenas números de 1 a 5!");
                    scanner.nextLine(); 
                }
            }
            
            System.out.print("Categoria: ");
            String categoria = scanner.nextLine();
            
            if (tipo == 1) {
                model.CompromissoPessoal pessoal = new model.CompromissoPessoal(
                    id, dataHora, descricao, prioridade, categoria);
                agenda.cadastrarCompromisso(pessoal);
            } else {
                model.CompromissoProfissional profissional = new model.CompromissoProfissional(
                    id, dataHora, descricao, prioridade, categoria);
                agenda.cadastrarCompromisso(profissional);
            }
            
            System.out.println("[OK] Compromisso cadastrado: " + descricao);
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    private static void listarCompromissos() {
        System.out.println("\n--- LISTAR COMPROMISSOS ---");
        List<model.Compromisso> compromissos = agenda.listarTodosCompromissos();
        
        if (compromissos.isEmpty()) {
            System.out.println("Nenhum compromisso cadastrado.");
        } else {
            for (int i = 0; i < compromissos.size(); i++) {
                model.Compromisso c = compromissos.get(i);
                System.out.printf("%d. %s - %s (%s) - Prioridade: %d - Tipo: %s\n", 
                    i + 1, c.getDataHora().format(formatter), c.getDescricao(), 
                    c.getCategoria(), c.getPrioridade(),
                    (c instanceof model.CompromissoPessoal) ? "Pessoal" : "Profissional");
            }
        }
    }
    
    private static void buscarCompromisso() {
        System.out.println("\n--- BUSCAR COMPROMISSO ---");
        System.out.print("Digite o ID: ");
        String id = scanner.nextLine();
        
        List<model.Compromisso> compromissos = agenda.listarTodosCompromissos();
        for (model.Compromisso c : compromissos) {
            if (c.getId().equals(id)) {
                System.out.println("Encontrado:");
                System.out.println("ID: " + c.getId());
                System.out.println("Data/Hora: " + c.getDataHora().format(formatter));
                System.out.println("Descrição: " + c.getDescricao());
                System.out.println("Prioridade: " + c.getPrioridade());
                System.out.println("Categoria: " + c.getCategoria());
                System.out.println("Tipo: " + (c instanceof model.CompromissoPessoal ? "Pessoal" : "Profissional"));
                return;
            }
        }
        System.out.println("Compromisso não encontrado!");
    }
    
    private static void editarCompromisso() {
        System.out.println("\n--- EDITAR COMPROMISSO ---");
        System.out.print("Digite o ID: ");
        String id = scanner.nextLine();
        
        List<model.Compromisso> compromissos = agenda.listarTodosCompromissos();
        model.Compromisso encontrado = null;
        
        for (model.Compromisso c : compromissos) {
            if (c.getId().equals(id)) {
                encontrado = c;
                break;
            }
        }
        
        if (encontrado == null) {
            System.out.println("Compromisso não encontrado!");
            return;
        }
        
        try {
            
            System.out.println("\n Deixe em branco para manter o atual:");
            
            System.out.print("Nova descrição [" + encontrado.getDescricao() + "]: ");
            String novaDescricao = scanner.nextLine();
            if (novaDescricao.isEmpty()) novaDescricao = encontrado.getDescricao();
            
            LocalDateTime novaDataHora = null;
            while (novaDataHora == null) {
                try {
                    System.out.print("Nova data/hora [" + encontrado.getDataHora().format(formatter) + "]: ");
                    String novaDataStr = scanner.nextLine();
                    if (novaDataStr.isEmpty()) {
                        novaDataHora = encontrado.getDataHora();
                    } else {
                        novaDataHora = LocalDateTime.parse(novaDataStr, formatter);
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Formato inválido! Use: dd/MM/yyyy HH:mm");
                }
            }
            
            int novaPrioridade = encontrado.getPrioridade();
            try {
                System.out.print("Nova prioridade [" + encontrado.getPrioridade() + "]: ");
                String prioridadeStr = scanner.nextLine();
                if (!prioridadeStr.isEmpty()) {
                    novaPrioridade = Integer.parseInt(prioridadeStr);
                    if (novaPrioridade < 1 || novaPrioridade > 5) {
                        System.out.println("Prioridade mantida como " + encontrado.getPrioridade() + " (deve ser 1-5)");
                        novaPrioridade = encontrado.getPrioridade();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Prioridade mantida como " + encontrado.getPrioridade());
            }
            
            System.out.print("Nova categoria [" + encontrado.getCategoria() + "]: ");
            String novaCategoria = scanner.nextLine();
            if (novaCategoria.isEmpty()) novaCategoria = encontrado.getCategoria();
            
            model.Compromisso atualizado;
            if (encontrado instanceof model.CompromissoPessoal) {
                atualizado = new model.CompromissoPessoal(id, novaDataHora, novaDescricao, novaPrioridade, novaCategoria);
            } else {
                atualizado = new model.CompromissoProfissional(id, novaDataHora, novaDescricao, novaPrioridade, novaCategoria);
            }
            
            agenda.editarCompromisso(id, atualizado);
            System.out.println("[OK] Compromisso atualizado com sucesso!");
            
        } catch (Exception e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }
    }
    
    private static void removerCompromisso() {
        System.out.println("\n--- REMOVER COMPROMISSO ---");
        System.out.print("Digite o ID: ");
        String id = scanner.nextLine();
        agenda.removerCompromisso(id);
    }
    
    private static void ordenarCompromissos() {
        try {
            System.out.println("\n--- ORDENAR COMPROMISSOS ---");
            System.out.println("1. Por Data");
            System.out.println("2. Por Prioridade"); 
            System.out.println("3. Por Categoria");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            List<model.Compromisso> ordenados;
            String titulo;
            
            switch (opcao) {
                case 1: 
                    ordenados = agenda.ordenarPorData();
                    titulo = "DATA";
                    break;
                case 2: 
                    ordenados = agenda.ordenarPorPrioridade();
                    titulo = "PRIORIDADE";
                    break;
                case 3: 
                    ordenados = agenda.ordenarPorCategoria();
                    titulo = "CATEGORIA";
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }
            
            System.out.println("\n--- ORDENADO POR " + titulo + " ---");
            for (model.Compromisso c : ordenados) {
                System.out.printf("- %s | %s | Prioridade: %d | Categoria: %s | Tipo: %s\n",
                    c.getDataHora().format(formatter), c.getDescricao(), 
                    c.getPrioridade(), c.getCategoria(),
                    (c instanceof model.CompromissoPessoal) ? "Pessoal" : "Profissional");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números!");
            scanner.nextLine();
        }
    }
}