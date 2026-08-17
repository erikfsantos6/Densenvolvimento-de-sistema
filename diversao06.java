import java.util.Scanner;

public class diversao06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número (OPERANDO1): ");
        double operando1 = scanner.nextDouble();

        System.out.print("Digite o segundo número (OPERANDO2): ");
        double operando2 = scanner.nextDouble();

        System.out.print("Digite a operação (+, -, *, /): ");
        char operador = scanner.next().charAt(0);

        double resultado = 0;
        boolean valido = true;

        switch (operador) {
            case '+':
                resultado = operando1 + operando2;
                break;
            case '-':
                resultado = operando1 - operando2;
                break;
            case '*':
                resultado = operando1 * operando2;
                break;
            case '/':
                if (operando2 != 0) {
                    resultado = operando1 / operando2;
                } else {
                    System.out.println("Erro: Divisão por zero!");
                    valido = false;
                }
                break;
            default:
                System.out.println("Operador inválido!");
                valido = false;
                break;
        }

        if (valido) {
            System.out.println("RESULTADO: " + resultado);
        }

        scanner.close();
    }
}