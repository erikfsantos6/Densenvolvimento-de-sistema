import java.util.*;

public class hotel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 0;
        
        while (n < 1 || n > 5) {
            System.out.print("Quantidade de quartos no hotel (máximo 5): ");
            n = s.nextInt();
        }

        int[] quartos = new int[n], camas = new int[n];
        List<String[]> reservas = new ArrayList<>(); // [numeroQuarto, nomeHospede]

        while (true) {
            System.out.println("\n1–Registrar quartos | 2–Registrar camas | 3–Reservar | 4–Consultar por quarto | 5–Consultar por hóspede | 6–Encerrar");
            System.out.print("Opção: ");
            int op = s.nextInt();
            if (op == 6) break;

            if (op == 1) {
                for (int i = 0; i < n; i++) {
                    System.out.print("Número do Quarto " + (i + 1) + ": ");
                    quartos[i] = s.nextInt();
                }
            } else if (op == 2) {
                for (int i = 0; i < n; i++) {
                    System.out.print("Quarto " + quartos[i] + " -> quantidade de camas: ");
                    camas[i] = s.nextInt();
                }
            } else if (op == 3) {
                System.out.print("Informe o número do quarto: ");
                int q = s.nextInt(), idx = -1;
                for (int i = 0; i < n; i++) if (quartos[i] == q) idx = i;

                if (idx == -1) System.out.println("Este quarto não existe!");
                else if (camas[idx] <= 0) System.out.println("Não há camas disponíveis neste quarto!");
                else if (reservas.size() >= 25) System.out.println("Limite de reservas atingido!");
                else {
                    System.out.print("Informe o nome do hóspede: ");
                    s.nextLine();
                    reservas.add(new String[]{String.valueOf(q), s.nextLine()});
                    camas[idx]--;
                    System.out.println("Reserva realizada com sucesso!");
                }
            } else if (op == 4) {
                System.out.print("Informe o número do quarto: ");
                int q = s.nextInt(), count = 0;
                boolean existe = false;
                for (int x : quartos) if (x == q) existe = true;

                if (!existe) {
                    System.out.println("Este quarto não existe!");
                } else {
                    for (String[] r : reservas) {
                        if (r[0].equals(String.valueOf(q))) {
                            System.out.println("- " + r[1]);
                            count++;
                        }
                    }
                    if (count == 0) System.out.println("Não há reservas para este quarto!");
                }
            } else if (op == 5) {
                System.out.print("Informe o nome do hóspede: ");
                s.nextLine();
                String h = s.nextLine();
                int count = 0;
                for (String[] r : reservas) {
                    if (r[1].equalsIgnoreCase(h)) {
                        System.out.println("- Quarto " + r[0]);
                        count++;
                    }
                }
                if (count == 0) System.out.println("Não há reservas para este hóspede!");
            }
        }
        s.close();
    }
}