package agenda;

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;

    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.favorito = false;
    }

    public void favoritaContato() {
        this.favorito = true;
    }

    public String getContato() {
        String contato = this.nome + " " + this.sobrenome + "\n" + this.telefone;
        return contato;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
