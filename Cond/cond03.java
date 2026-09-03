import java.util.Scanner;

class Cond03 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("informa a idade: ");
            int idade = sc.nextInt();

            System.out.println("É estudante? Digite 1 para SIM ou 0 NÃO: ");
            int estudante = sc.nextInt();

            if (idade >= 60 || estudante == 1) {
System.out.println("Você tem direito ao desconto");
} else {
System.out.println("Você não tem direito ao desconto");
}
        } 

    }

}
    
    