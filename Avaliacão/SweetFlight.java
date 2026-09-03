import java.util.Scanner;

public class SweetFlight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeroAviao = new int[4];
        int[] assentosDisponiveis = new int[4];
        
        String[] nomePassageiro = new String[20];
        int[] aviaoReserva = new int[20];

        int qtdAvioesCadastrados = 0;
        int totalReservas = 0;
        boolean assentosCadastrados = false;

        int opcao = 0;

        while (opcao != 8) {
            System.out.println("=========================================");
            System.out.println("      SWEET FLIGHT – SISTEMA DE RESERVAS");
            System.out.println("=========================================");
            System.out.println("1 - Cadastrar aviões");
            System.out.println("2 - Cadastrar quantidade de assentos");
            System.out.println("3 - Listar aviões");
            System.out.println("4 - Realizar reserva");
            System.out.println("5 - Consultar reservas de um avião");
            System.out.println("6 - Pesquisar passageiro");
            System.out.println("7 - Mostrar resumo");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao < 1 || opcao > 8) {
                System.out.println("Opção inválida!\n");
            } else {
                switch (opcao) {
                    case 1:
                        
                        System.out.print("Quantos aviões deseja cadastrar (1 a 4)? ");
                        int qtdDesejada = scanner.nextInt();

                        
                        while (qtdDesejada < 1 || qtdDesejada > 4) {
                            System.out.print("Quantidade inválida! Digite um valor entre 1 e 4: ");
                            qtdDesejada = scanner.nextInt();
                        }

                        qtdAvioesCadastrados = qtdDesejada;

                        for (int i = 0; i < qtdAvioesCadastrados; i++) {
                            int numAviao;
                            boolean jaExiste;

                            do {
                                jaExiste = false;
                                System.out.print("Informe o número do avião " + (i + 1) + ": ");
                                numAviao = scanner.nextInt();

                                for (int j = 0; j < i; j++) {
                                    if (numeroAviao[j] == numAviao) {
                                        jaExiste = true;
                                        System.out.println("Este número de avião já foi cadastrado! Digite outro.");
                                        break;
                                    }
                                }
                            } while (jaExiste);

                            numeroAviao[i] = numAviao;
                        }

                        System.out.println("Aviões cadastrados com sucesso!\n");
                        break;

                    case 2:
                        if (qtdAvioesCadastrados == 0) {
                            System.out.println("Cadastre os aviões primeiro (Opção 1)!\n");
                        } else {
                            for (int i = 0; i < qtdAvioesCadastrados; i++) {
                                System.out.print("Informe a quantidade de assentos do avião " + numeroAviao[i] + " (0 a 20): ");
                                int assentos = scanner.nextInt();

                                while (assentos < 0 || assentos > 20) {
                                    System.out.print("Quantidade inválida! Informe um valor entre 0 e 20: ");
                                    assentos = scanner.nextInt();
                                }

                                assentosDisponiveis[i] = assentos;
                            }
                            assentosCadastrados = true;
                            System.out.println("Assentos cadastrados com sucesso!\n");
                        }
                        break;

                    case 3:
                        if (qtdAvioesCadastrados == 0) {
                            System.out.println("Nenhum avião cadastrado.\n");
                        } else {
                            for (int i = 0; i < qtdAvioesCadastrados; i++) {
                                System.out.println("Avião: " + numeroAviao[i] + " | Assentos disponíveis: " + assentosDisponiveis[i]);
                            }
                            System.out.println();
                        }
                        break;

                    case 4:

                        if (totalReservas >= 20) {
                            System.out.println("Limite máximo de 20 reservas atingido!\n");
                            break;
                        }

                        if (qtdAvioesCadastrados == 0 || !assentosCadastrados) {
                            System.out.println("É necessário cadastrar aviões e assentos antes de realizar reservas!\n");
                            break;
                        }

                        System.out.print("Informe o número do avião desejado: ");
                        int numAviaoBusca = scanner.nextInt();
                        scanner.nextLine(); // Limpar buffer

                        int indiceAviao = -1;
                        for (int i = 0; i < qtdAvioesCadastrados; i++) {
                            if (numeroAviao[i] == numAviaoBusca) {
                                indiceAviao = i;
                                break;
                            }
                        }

                        if (indiceAviao == -1) {
                            System.out.println("Este avião não existe!\n");
                        } else if (assentosDisponiveis[indiceAviao] <= 0) {
                            System.out.println("Não há assentos disponíveis para este avião!\n");
                        } else {
                            System.out.print("Informe o nome do passageiro: ");
                            String nome = scanner.nextLine();

                            while (nome.trim().isEmpty()) {
                                System.out.print("O nome não pode ficar vazio! Informe o nome do passageiro: ");
                                nome = scanner.nextLine();
                            }

                            nomePassageiro[totalReservas] = nome;
                            aviaoReserva[totalReservas] = numAviaoBusca;
                            
                            assentosDisponiveis[indiceAviao]--;
                            totalReservas++;

                            System.out.println("Reserva realizada com sucesso!\n");
                        }
                        break;

                    case 5:

                        if (qtdAvioesCadastrados == 0) {
                            System.out.println("Nenhum avião cadastrado.\n");
                            break;
                        }

                        System.out.print("Informe o número do avião: ");
                        int aviaoConsulta = scanner.nextInt();

                        boolean aviaoExiste = false;
                        for (int i = 0; i < qtdAvioesCadastrados; i++) {
                            if (numeroAviao[i] == aviaoConsulta) {
                                aviaoExiste = true;
                                break;
                            }
                        }

                        if (!aviaoExiste) {
                            System.out.println("Este avião não existe!\n");
                        } else {
                            boolean encontrouReserva = false;
                            System.out.println("Passageiros do avião " + aviaoConsulta + ":");
                            for (int i = 0; i < totalReservas; i++) {
                                if (aviaoReserva[i] == aviaoConsulta) {
                                    System.out.println("- " + nomePassageiro[i]);
                                    encontrouReserva = true;
                                }
                            }

                            if (!encontrouReserva) {
                                System.out.println("Não há reservas realizadas para este avião!");
                            }
                            System.out.println();
                        }
                        break;

                    case 6:

                        if (totalReservas == 0) {
                            System.out.println("Não há reservas registradas no sistema.\n");
                            break;
                        }

                        System.out.print("Informe o nome do passageiro: ");
                        String nomePesquisado = scanner.nextLine();

                        boolean passageiroEncontrado = false;
                        for (int i = 0; i < totalReservas; i++) {
                            if (nomePassageiro[i].equalsIgnoreCase(nomePesquisado)) {
                                System.out.println("Passageiro: " + nomePassageiro[i] + " | Avião: " + aviaoReserva[i]);
                                passageiroEncontrado = true;
                            }
                        }

                        if (!passageiroEncontrado) {
                            System.out.println("Não há reservas realizadas para este passageiro!");
                        }
                        System.out.println();
                        break;

                    case 7:

                        if (qtdAvioesCadastrados == 0) {
                            System.out.println("Nenhum dado cadastrado para exibir no resumo.\n");
                            break;
                        }

                        int totalAssentosDisponiveis = 0;
                        int avioesComAssentos = 0;
                        int avioesSemAssentos = 0;
                        int maiorQtdAssentos = -1;
                        int aviaoMaiorAssentos = -1;

                        for (int i = 0; i < qtdAvioesCadastrados; i++) {
                            totalAssentosDisponiveis += assentosDisponiveis[i];

                            if (assentosDisponiveis[i] > 0) {
                                avioesComAssentos++;
                            } else {
                                avioesSemAssentos++;
                            }

                            if (assentosDisponiveis[i] > maiorQtdAssentos) {
                                maiorQtdAssentos = assentosDisponiveis[i];
                                aviaoMaiorAssentos = numeroAviao[i];
                            }
                        }

                        System.out.println("========== RESUMO DO SISTEMA ==========");
                        System.out.println("Quantidade de aviões cadastrados: " + qtdAvioesCadastrados);
                        System.out.println("Quantidade total de reservas realizadas: " + totalReservas);
                        System.out.println("Quantidade total de assentos disponíveis: " + totalAssentosDisponiveis);
                        System.out.println("Quantidade de aviões com assentos disponíveis: " + avioesComAssentos);
                        System.out.println("Quantidade de aviões sem assentos disponíveis: " + avioesSemAssentos);
                        System.out.println("Avião com maior quantidade de assentos disponíveis: " + aviaoMaiorAssentos + " (" + maiorQtdAssentos + " assentos)");
                        System.out.println("=========================================\n");
                        break;

                    case 8:
                    System.out.println("Sistema encerrado. Até logo!");
                        break;
                }
            }
        }

        scanner.close();
    }
}