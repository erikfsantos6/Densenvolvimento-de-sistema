import java.util.Scanner;

public class cond02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("informar a nota do aluno:");
        double nota=sc.nextDouble();

        System.out.println("informar a frequência do aluno: ");
        double frequência=sc.nextDouble();

        if (nota>=7 && frequência>=75) {
            System.out.println("Ap");
        }else{
            System.out.println("rep");
            
        }
    }
}    
