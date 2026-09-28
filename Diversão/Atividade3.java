import java.util.Scanner;

interface Pagamento {
    double calcularPagamento();
    double calcularPagamento(double bonus);
}

abstract class Funcionario implements Pagamento {
    private String nome;
    private String cpf;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public abstract void exibirDados();
}

class FuncionarioCLT extends Funcionario {
    private double salarioMensal;

    public FuncionarioCLT(String nome, String cpf, double salarioMensal) {
        super(nome, cpf);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularPagamento() {
        return salarioMensal;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return salarioMensal + bonus;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- DADOS DO FUNCIONÁRIO (CLT) ---");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.printf("Salário Mensal: R$ %.2f\n", salarioMensal);
    }
}

class FuncionarioFreelancer extends Funcionario {
    private int horasTrabalhadas;
    private double valorPorHora;

    public FuncionarioFreelancer(String nome, String cpf, int horasTrabalhadas, double valorPorHora) {
        super(nome, cpf);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorPorHora;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return (horasTrabalhadas * valorPorHora) + bonus;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- DADOS DO FUNCIONÁRIO (FREELANCER) ---");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.printf("Valor por Hora: R$ %.2f\n", valorPorHora);
    }
}

public class Atividade3 {
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