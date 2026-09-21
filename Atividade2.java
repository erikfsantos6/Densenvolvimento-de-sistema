import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = null;
        int opcao = 0;

        do {
            System.out.println("\n========== SISTEMA DE PAGAMENTO ==========");
            System.out.println("1. Cadastrar Funcionário / Escolher Tipo");
            System.out.println("2. Mostrar dados cadastrados");
            System.out.println("3. Calcular pagamento");
            System.out.println("4. Calcular pagamento com bônus");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Selecione o tipo de funcionário:");
                    System.out.println("1. CLT");
                    System.out.println("2. Freelancer");
                    System.out.print("Opção: ");
                    int tipo = scanner.nextInt();

                    if (tipo == 1) {
                        System.out.print("Digite o salário mensal: R$ ");
                        double salario = scanner.nextDouble();
                        funcionario = new FuncionarioCLT(nome, cpf, salario);
                        System.out.println("-> Funcionário CLT cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("Digite a quantidade de horas trabalhadas: ");
                        int horas = scanner.nextInt();
                        System.out.print("Digite o valor por hora: R$ ");
                        double valorHora = scanner.nextDouble();
                        funcionario = new FuncionarioFreelancer(nome, cpf, horas, valorHora);
                        System.out.println("-> Funcionário Freelancer cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido. Cadastro cancelado.");
                    }
                    break;

                case 2:
                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado ainda.");
                    } else {
                        funcionario.exibirDados();
                    }
                    break;

                case 3:
                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado ainda.");
                    } else {
                        System.out.printf("Pagamento total: R$ %.2f\n", funcionario.calcularPagamento());
                    }
                    break;

                case 4:
                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado ainda.");
                    } else {
                        System.out.print("Digite o valor do bônus: R$ ");
                        double bonus = scanner.nextDouble();
                        System.out.printf("Pagamento total com bônus: R$ %.2f\n", funcionario.calcularPagamento(bonus));
                    }
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}