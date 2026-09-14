public class Cliente {
    private String nome;
    private String endereco;


    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }
// The image cuts off here, likely before the setEndereco method and closing brace.

public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String toString(){
        return "nome: "+nome+"endereco: "+endereco;
    }


    public void exibirDados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirDados'");
    }
}
