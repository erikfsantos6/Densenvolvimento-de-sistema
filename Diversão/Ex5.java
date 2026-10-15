import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int op = -1;
    

        while(op != 0) {
            try {
                System.out.println("===== Menu =====");
                System.out.println("1. Adicionar");
                System.out.println("2. Listar ");
                System.out.println("3. Remover");
                System.out.println("0. Sair");
                op = sc.nextInt();
                sc.nextLine();

                switch(op) {
                    case 1:
                        System.out.println("Informe o nome:");
                        String nome = sc.nextLine();
                        lista.add(Integer.parseInt(nome));
                        System.out.println("Adicionado com sucesso!");
                        break;
                    case 2:
                        if(lista.isEmpty()) {
                            System.out.println("Lista vazia!");
                        } else {
                            System.out.println("Lista:" + lista);
                        }
                        break;
                    case 3:
                        System.out.println("Informe o indice para remover:");
                        int indice = sc.nextInt();
                        lista.remove(indice);
                        System.out.println("Removido com sucesso!");
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        }
                        break;
                    
                        

    
    } catch (InputMismatchException e) {
        System.out.println("Erro: Não é um número inteiro");
        sc.nextLine();
    }catch(IndexOutOfBoundsException e) {
        System.out.println("Erro: Índice inválido");
        sc.nextLine();
    }catch(Exception e) {
        System.out.println("Erro: inesperado" + e.getMessage());
        sc.nextLine();

        }sc.close();


    }
}
}

