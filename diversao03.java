import java.util.Scanner;

public class diversao03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a idade: ");
        int idade = sc.nextInt();

        if (idade <= 12) {
            System.out.println("É criança.");
        } else if (idade <= 17) {
            System.out.println("É adolescente.");
        } else if (idade <= 59) {
            System.out.println("É adulto.");
        } else {
            System.out.println("É idoso.");
        }

        sc.close();
    }
}