import java.util.Scanner;

public class PagamentoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor do pagamento: ");
        double valor = scanner.nextDouble();

        Pix pix = new Pix();
        pix.pagar(valor);
    }
}
