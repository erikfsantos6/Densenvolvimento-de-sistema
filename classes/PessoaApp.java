public class PessoaApp {
 
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1, "Edison");
        Pessoa p2 = new Pessoa(2, "Maria");

        //acessador
        System.out.println("Pessoa 1: Código: " + p1.getCodigo() + " Nome: " + p1.getNome());
        //modificador
        p1.setNome ("João");

        System.out.println("Código: " + p1.getCodigo() + " Nome: " + p1.getNome());

    

}
 
}