
class Veiculo {
    private String marca;
    private int ano;

    public Veiculo(String marca, int ano) {
        this.marca = marca;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
    }
}


class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String marca, int ano, int cilindrada) {
        super(marca, ano);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Cilindrada: " + cilindrada + " cc");
    }
}


class Carro extends Veiculo {
    private int qtdPortas;

    public Carro(String marca, int ano, int qtdPortas) {
        super(marca, ano);
        this.qtdPortas = qtdPortas;
    }

    public int getQtdPortas() {
        return qtdPortas;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Quantidade de Portas: " + qtdPortas);
    }
}

public class veiculo {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", 2023, 4);
        Moto moto = new Moto("Honda", 2022, 600);

        System.out.println("=== Detalhes do Carro ===");
        carro.exibirInfo();

        System.out.println("\n=== Detalhes da Moto ===");
        moto.exibirInfo();
    }
}