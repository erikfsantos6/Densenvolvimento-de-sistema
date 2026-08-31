import java.util.Scanner;

public class numeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = new int[5];
        
        int size = 0, op;

        do {
            System.out.print("\n1-Inserir | 2-Listar | 3-Remover | 4-Sair\nOpção: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    if (size < v.length) {
                        System.out.print("Número: ");
                        v[size++] = sc.nextInt();
                        System.out.println("Inserido com sucesso!");
                    } else System.out.println("Erro: está cheio!");
                }
                case 2 -> {
                    if (size == 0) System.out.println("está vazio!");
                    else for (int i = 0; i < size; i++) System.out.println("[" + i + "] = " + v[i]);
                }
                case 3 -> {
                    if (size == 0) System.out.println("Erro:  vazio!");
                    else {
                        System.out.print("Índice para remover: ");
                        int idx = sc.nextInt();
                        if (idx >= 0 && idx < size) {
                            for (int i = idx; i < size - 1; i++) v[i] = v[i + 1];
                            size--;
                            System.out.println("Removido com sucesso!");
                        } else System.out.println("Erro: Índice inválido!");
                    }
                }
            }
        } while (op != 4);

        sc.close();
    }
}