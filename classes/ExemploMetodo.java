public  class ExemploMetodo {

    
    public static void mensagem(){
        System.out.println("Seja bem vindo!");
    }

    //com parâmetros e sem retorno
    public static void mostrarNome(String nome){
        System.out.println("O nome é: " + nome);
    }
    // sem parâmetros e com retorno
    public static int obterNumero(){
        return 10;
    }
    //com parâmetros e com retorno
    public static int somar(int n1, int n2)
    {
        return n1 + n2;
    }

    public static void main(String[] args) {
        mensagem();
        mostrarNome("João");
        int numero = obterNumero();
        System.out.println("O número é: " + numero);
        int resultado = somar(10,5);
        System.out.println("O resultado é: " + resultado);
    }
}
