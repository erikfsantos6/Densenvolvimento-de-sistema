import java.util.Scanner;

class Animal {
    private String nome; private int idade;
    public Animal(String nome, int idade) { this.nome = nome; this.idade = idade; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public void emitirSom() { System.out.println("Som genérico"); }
    public void exibirInfo() { System.out.println("Nome: " + nome + "\nIdade: " + idade); }
}

class Cachorro extends Animal {
    private String raca;
    public Cachorro(String n, int i, String raca) { super(n, i); this.raca = raca; }
    public String getRaca() { return raca; }
    @Override public void emitirSom() { System.out.println("Au Au!"); }
    @Override public void exibirInfo() { super.exibirInfo(); System.out.println("Raça: " + raca); }
}

class Gato extends Animal {
    private String cor;
    public Gato(String n, int i, String cor) { super(n, i); this.cor = cor; }
    public String getCor() { return cor; }
    @Override public void emitirSom() { System.out.println("Miau!"); }
    @Override public void exibirInfo() { super.exibirInfo(); System.out.println("Cor: " + cor); }
}

public class Clínica{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cachorro c = null; Gato g = null; int op = -1;


        while (op != 0) {
            System.out.println("\n===== CLÍNICA VETERINÁRIA =====\n1 - Cadastrar Cachorro\n2 - Cadastrar Gato\n3 - Mostrar dados do Cachorro\n4 - Mostrar dados do Gato\n5 - Fazer Cachorro emitir som\n6 - Fazer Gato emitir som\n0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt(); sc.nextLine();


            switch (op) {
                case 1 -> {
                    System.out.print("Nome: "); String n = sc.nextLine();
                    System.out.print("Idade: "); int i = sc.nextInt(); sc.nextLine();
                    System.out.print("Raça: "); c = new Cachorro(n, i, sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Nome: "); String n = sc.nextLine();
                    System.out.print("Idade: "); int i = sc.nextInt(); sc.nextLine();
                    System.out.print("Cor: "); g = new Gato(n, i, sc.nextLine());
                }
                case 3 -> { if (c != null) c.exibirInfo(); else System.out.println("Cachorro não cadastrado!"); }
                case 4 -> { if (g != null) g.exibirInfo(); else System.out.println("Gato não cadastrado!"); }
                case 5 -> { if (c != null) c.emitirSom(); else System.out.println("Cachorro não cadastrado!"); }
                case 6 -> { if (g != null) g.emitirSom(); else System.out.println("Gato não cadastrado!"); }
            }
        }
        sc.close();
    }
}