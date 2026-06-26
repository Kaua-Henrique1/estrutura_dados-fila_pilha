package fila_e_pilha.fila.ui;

import fila_e_pilha.fila.service.CardService;
import java.util.Scanner;

public class MenuConsole {
    private final CardService cardService;
    private final Scanner scanner;

    public MenuConsole(CardService cardService) {
        this.cardService = cardService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("=== CONFIGURAÇÃO INICIAL DO CARD ===");
        System.out.print("Dê um título para o seu Card de tempo (ex: Estudos Padronizados): ");
        String tituloCard = scanner.nextLine();
        System.out.print("Defina o tempo limite do Card em minutos (ex: 3h = 180): ");
        int limiteMinutos = Integer.parseInt(scanner.nextLine());

        cardService.criarNovoCard(tituloCard, limiteMinutos);
        System.out.println("\n[SUCESSO] Card '" + tituloCard + "' criado com " + limiteMinutos + " minutos livres!");

        int opcao = 0;
        do {
            exibirStatusCard();
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("\n[ERRO] Digite um número válido.");
            }
            System.out.println();
        } while (opcao != 5);

        scanner.close();
    }

    private void exibirStatusCard() {
        System.out.println("\n" + cardService.obterStatusCardTexto());
    }

    private void exibirMenu() {
        System.out.println("1. Adicionar Tarefa na Fila do Card");
        System.out.println("2. Ver Próxima Tarefa a Ser Resolvida (Peek)");
        System.out.println("3. Concluir Tarefa Atual (Poll/Dequeue)");
        System.out.println("4. Listar Todas as Tarefas da Fila");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.print("Título da Tarefa: ");
                String titulo = scanner.nextLine();
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();
                System.out.print("Duração (em minutos): ");
                int duracao = Integer.parseInt(scanner.nextLine());

                String resultadoAdicionar = cardService.adicionarTarefaNoCard(titulo, descricao, duracao);
                System.out.println("\n" + resultadoAdicionar);
                break;

            case 2:
                String resultadoEspiar = cardService.espiarProxima();
                System.out.println("\n" + resultadoEspiar);
                break;

            case 3:
                String resultadoConcluir = cardService.concluirTarefaAtual();
                System.out.println("\n" + resultadoConcluir);
                break;

            case 4:
                System.out.println("\n--- ORDEM DE EXECUÇÃO DA FILA ---");
                String listagem = cardService.listarTodasAsTarefas();
                System.out.println(listagem);
                break;

            case 5:
                System.out.println("Encerrando o sistema...");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }
}