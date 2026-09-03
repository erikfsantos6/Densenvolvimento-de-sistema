import java.util.Scanner;

public class diversao07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a cor do CD (Verde, Azul, Amarelo, Vermelho): ");
        String cor = scanner.nextLine().trim().toLowerCase();

        switch (cor) {
            case "verde":
                System.out.println("PREÇO: R$ 10,00");
                break;
            case "azul":
                System.out.println("PREÇO: R$ 20,00");
                break;
            case "amarelo":
                System.out.println("PREÇO: R$ 30,00");
                break;
            case "vermelho":
                System.out.println("PREÇO: R$ 40,00");
                break;
            default:
                System.out.println("Cor inválida!");
                break;
        }

        scanner.close();
    }
}