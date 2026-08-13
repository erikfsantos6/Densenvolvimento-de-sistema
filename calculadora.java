import java.util.Scanner;

public class calculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe N1: ");
        double N1 = sc.nextDouble();

        System.out.println("Informe N2: ");
        double N2 = sc.nextDouble();

        System.out.println("Soma: " + (N1 + N2));
        System.out.println("Subtração: " + (N1 - N2));
        System.out.println("Multiplicação: " + (N1 * N2));
        System.out.println("Divisão: " + (N1 / N2));

        sc.close();
    }
}