import java.util.ArrayList;

public class Ex01 {

    public static void main(String[] args) {
        
        ArrayList<String> nomes =new ArrayList<>();

        // Adicionar
        nomes.add("Alice");
        nomes.add("Bob");
        nomes.add("Charlie");

        //LISTAR
        System.out.println("Lista de nomes:");
        for (String nome : nomes) {
            System.out.println(nome);

            nomes.set(1, "edivandecidecleide");

System.out.println("Lista após alterar");
for (String nome1 : nomes) {
    System.out.println(nome1);
}

   //REMOVER
   nomes.remove(0);

System.out.println("Lista após remover");
for (String nome1 : nomes) {
    System.out.println(nome1);
}

 }

        }


    }
