import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*String nome="Anderson";
        System.out.println(nome.toUpperCase());*/

        Scanner sc = new Scanner(System.in);

        System.out.println("infome o seu nome: ");
        String nome = sc.nextLine();
        nome = nome.toUpperCase();
        System.out.println("Nome em maiusculo: " + nome);

        sc.close();
    }
}