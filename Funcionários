import java.util.Scanner;

class Funcionario {
    private String nome; private double salario;
    public Funcionario(String nome, double salario) { this.nome = nome; this.salario = salario; }
    public String getNome() { return nome; }
    public double getSalario() { return salario; }
    public void exibirInfo() { System.out.println("Nome: " + nome + "\nSalário: " + salario); }
}

class Professor extends Funcionario {
    private String disciplina;
    public Professor(String n, double s, String disciplina) { super(n, s); this.disciplina = disciplina; }
    @Override public void exibirInfo() { super.exibirInfo(); System.out.println("Disciplina: " + disciplina); }
}

class Tecnico extends Funcionario {
    private String setor;
    public Tecnico(String n, double s, String setor) { super(n, s); this.setor = setor; }
    @Override public void exibirInfo() { super.exibirInfo(); System.out.println("Setor: " + setor); }
}

public class FuncionarioApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Professor prof = null; Tecnico tec = null; int op = -1;

        while (op != 0) {
            System.out.println("\n===== SISTEMA DE FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar Professor\n2 - Cadastrar Técnico\n3 - Exibir Professor\n4 - Exibir Técnico\n0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nome: "); String n = sc.nextLine();
                    System.out.print("Salário: "); double s = sc.nextDouble(); sc.nextLine();
                    System.out.print("Disciplina: "); prof = new Professor(n, s, sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Nome: "); String n = sc.nextLine();
                    System.out.print("Salário: "); double s = sc.nextDouble(); sc.nextLine();
                    System.out.print("Setor: "); tec = new Tecnico(n, s, sc.nextLine());
                }
                case 3 -> { if (prof != null) prof.exibirInfo(); else System.out.println("Professor não cadastrado!"); }
                case 4 -> { if (tec != null) tec.exibirInfo(); else System.out.println("Técnico não cadastrado!"); }
            }
        }
        sc.close();
    }
}