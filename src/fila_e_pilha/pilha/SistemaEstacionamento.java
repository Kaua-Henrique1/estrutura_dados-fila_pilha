package fila_e_pilha.pilha;

import java.util.Scanner;

public class SistemaEstacionamento {

    public static void main(String[] args) {
        
        Pilha estacionamento = new Pilha();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== ESTACIONAMENTO DE VAGA UNICA ===");
            System.out.println("1 - Entrada de veiculo (Push)");
            System.out.println("2 - Saida de veiculo (Pop)");
            System.out.println("3 - Mostrar veiculo no topo (Top)");
            System.out.println("4 - Quantidade de veiculos (Size)");
            System.out.println("5 - Estacionamento vazio? (isEmpty)");
            System.out.println("6 - Mostrar todos os veiculos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Digite um numero valido.");
                continue;
            }

            System.out.println("------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.print("Digite o modelo do carro: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Digite a placa do carro: ");
                    String placa = scanner.nextLine();
                    
                    Carro novoCarro = new Carro(placa, modelo);
                    estacionamento.push(novoCarro); 
                    System.out.println("[SUCESSO] " + novoCarro.getModelo() + " estacionado!");
                    break;

                case 2:
                    if (estacionamento.isEmpty()) {
                        System.out.println("[AVISO] O estacionamento ja esta vazio.");
                    } else {
                        Carro carroSaindo = estacionamento.pop(); 
                        System.out.println("[SAIDA] O veiculo " + carroSaindo.getModelo() + " foi retirado.");
                    }
                    break;

                case 3:
                    if (estacionamento.isEmpty()) {
                        System.out.println("[AVISO] Nao ha veiculos no estacionamento.");
                    } else {
                        System.out.println("[TOPO] Veiculo bloqueando a saida: " + estacionamento.top());
                    }
                    break;

                case 4:
                    System.out.println("[INFO] Quantidade de veiculos estacionados: " + estacionamento.size());
                    break;

                case 5:
                    if (estacionamento.isEmpty()) {
                        System.out.println("[INFO] Sim, o estacionamento esta totalmente vazio.");
                    } else {
                        System.out.println("[INFO] Nao, existem veiculos estacionados.");
                    }
                    break;

                case 6:
                    if (estacionamento.isEmpty()) {
                        System.out.println("[AVISO] O estacionamento esta vazio.");
                    } else {
                        System.out.println("--- Ordem dos Veiculos (Fundo -> Saida) ---");
                        int posicao = 1;
                        for (Carro c : estacionamento.getElementos()) {
                            System.out.println(posicao + " - Carro: " + c.toString());
                            posicao++;
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("[ERRO] Opcao invalida!");
            }
        }
        
        scanner.close();
    }
}