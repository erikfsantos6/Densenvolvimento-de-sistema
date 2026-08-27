import java.util.Scanner;

public class Vet06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] nomes;
        int[] idades;

        System.out.println("Quantas pessoas deseja cadastrar");
        int quantidade = sc.nextInt();

        nomes=new String[quantidade];
        idades = new int[quantidade];

for(int i=0;i<quantidade;i++){
    System.out.println("Digite o nome: ");
    nomes[i]=sc.nextLine();

    System.out.println("Digite a idade: ");
    idades[i]=sc.nextInt();
    sc.nextLine();//Limpar buffer
}

for(int i=0;i<quantidade;i++){
    System.out.println(nomes[i]+" - "+idades[i]+"anos");
}

sc.close();




        sc.close();
    }
} 