import java.util.Scanner;

public class cond05 {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe o nome: ");
    String nome = sc.nextLine();

    System.out.println("Informe a senha: ");
    String senha = sc.nextLine();

    if (nome.equals("erik")&& senha.equals("1234")) {
        System.out.println("Login realizado com sucesso");
    }else if (nome.equals("lucas")&& senha.equals("5678")) {
        System.out.println("Logi realizado com sucesso");

    }

    sc.close();
}
}
