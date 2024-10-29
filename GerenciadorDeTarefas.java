import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return (concluida ? "[Concluída] " : "[Pendente] ") + descricao;
    }
}

public class GerenciadorDeTarefas {
    private static ArrayList<Tarefa> listaDeTarefas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
                while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (escolha) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    marcarTarefaComoConcluida();
                    break;
                case 4:
                    System.out.println("Saindo do gerenciador de tarefas.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Gerenciador de Tarefas ===");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa tarefa = new Tarefa(descricao);
        listaDeTarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void listarTarefas() {
        System.out.println("\n=== Lista de Tarefas ===");
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            for (int i = 0; i < listaDeTarefas.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeTarefas.get(i));
            }
        }
    }

    private static void marcarTarefaComoConcluida() {
        listarTarefas();
        System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
        int numeroTarefa = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        if (numeroTarefa > 0 && numeroTarefa <= listaDeTarefas.size()) {
            Tarefa tarefa = listaDeTarefas.get(numeroTarefa - 1);
            tarefa.marcarComoConcluida();
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Número de tarefa inválido.");
        }
    }
}