import java.util.Scanner;

public class diversao05 {
    public static void main(String[] args) {
        // Senha pré-configurada no sistema
        String senhaCorreta = "erik5787";
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a senha de acesso: ");
        String senha = scanner.nextLine();
        
        // Verificação da senha
        if (senha.equals(senhaCorreta)) {
            System.out.println("PORTA ABERTA");
        } else {
            System.out.println("SENHA NAO CONFERE");
        }
        
        scanner.close();
    }
}