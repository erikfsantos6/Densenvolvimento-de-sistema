import java.util.Scanner;

public class cond04 {

public class Cond04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("informa a idade: ");
        int idade = sc.nextInt();

        if (idade <= 12) {
            System.out.println("Criança");
        } else if(idade<18){
            System.out.println("Adolescente");
        } else if(idade<60){
            System.out.println("Adulto");
        }else{
            System.out.println("idoso");
        }
    }
}
 
}

