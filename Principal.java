import java.util.Scanner;

interface Pagamento {
    void pagar(double valor);
}


class Agencia {
    private int numero;
    private String nome;

    public Agencia(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostrarDados() {
        System.out.println("Número da Agência: " + numero);
        System.out.println("Nome da Agência: " + nome);
    }
}

class Conta {
    private int numero;
    private String titular;
    protected double saldo;
    private Agencia agencia;

    public Conta(int numero, String titular, double saldoInicial, Agencia agencia) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = Math.max(saldoInicial, 0);
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
            System.out.printf("Novo saldo: R$ %.2f%n", saldo);
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
    }

    public void mostrarDados() {
        if (agencia != null) {
            agencia.mostrarDados();
        }
        System.out.println("Número da Conta: " + numero);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo Atual: R$ %.2f%n", saldo);
    }
}

class ContaCorrente extends Conta implements Pagamento {

    public ContaCorrente(int numero, String titular, double saldoInicial, Agencia agencia) {
        super(numero, titular, saldoInicial, agencia);
    }

  
    @Override
    public void pagar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento.");
            return;
        }
        saldo -= valor;
        System.out.println("Pagamento em dinheiro realizado com sucesso!");
        System.out.printf("Saldo atualizado: R$ %.2f%n", saldo);
    }

  
    public void pagar(double valor, String chavePix) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento.");
            return;
        }
        saldo -= valor;
        System.out.println("Pagamento via PIX realizado com sucesso!");
        System.out.println("Chave PIX utilizada: " + chavePix);
        System.out.printf("Saldo atualizado: R$ %.2f%n", saldo);
    }

   
    public void pagar(double valor, int parcelas) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero.");
            return;
        }
        if (parcelas <= 0) {
            System.out.println("Erro: A quantidade de parcelas deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento.");
            return;
        }
        saldo -= valor;
        double valorParcela = valor / parcelas;
        System.out.println("Pagamento no cartão realizado com sucesso!");
        System.out.printf("Valor da parcela (%dx): R$ %.2f%n", parcelas, valorParcela);
        System.out.printf("Saldo atualizado: R$ %.2f%n", saldo);
    }

  
    public void transferir(double valor, int contaDestino) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da transferência deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar a transferência.");
            return;
        }
        saldo -= valor;
        System.out.printf("Transferência de R$ %.2f para a conta %d realizada com sucesso!%n", valor, contaDestino);
        System.out.printf("Saldo atualizado: R$ %.2f%n", saldo);
    }
}


public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CADASTRO INICIAL ===");
        System.out.print("Número da agência: ");
        int numAgencia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome da agência: ");
        String nomeAgencia = scanner.nextLine();

        Agencia agencia = new Agencia(numAgencia, nomeAgencia);

        System.out.print("Número da conta: ");
        int numConta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titular: ");
        String titular = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaCorrente conta = new ContaCorrente(numConta, titular, saldoInicial, agencia);

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("7 - Transferir (Desafio)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- DADOS DA CONTA ---");
                    conta.mostrarDados();
                    break;
                case 2:
                    System.out.println("\n--- CONSULTA DE SALDO ---");
                    conta.consultarSaldo();
                    break;
                case 3:
                    System.out.print("Informe o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 4:
                    System.out.print("Informe o valor do pagamento: ");
                    double valorPix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Informe a chave PIX: ");
                    String chavePix = scanner.nextLine();
                    conta.pagar(valorPix, chavePix);
                    break;
                case 5:
                    System.out.print("Informe o valor da compra: ");
                    double valorCartao = scanner.nextDouble();
                    System.out.print("Informe a quantidade de parcelas: ");
                    int parcelas = scanner.nextInt();
                    conta.pagar(valorCartao, parcelas);
                    break;
                case 6:
                    System.out.print("Informe o valor do pagamento: ");
                    double valorDinheiro = scanner.nextDouble();
                    conta.pagar(valorDinheiro);
                    break;
                case 7:
                    System.out.print("Informe o número da conta de destino: ");
                    int contaDestino = scanner.nextInt();
                    System.out.print("Informe o valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    conta.transferir(valorTransferencia, contaDestino);
                    break;
                case 0:
                    System.out.println("A encerrar o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}