package agenda;

/**
 * Classe que representa um contato e seus comportamentos
 *
 * @author Bruno Rodrigues Ramos
 */
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;

    /**
     * Construtor que inicia um contato
     *
     * @param nome
     * @param sobrenome
     * @param telefone
     */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.favorito = false;
    }

    /**
     * Torna um contato favorito modificando o atributo favorito.
     */
    public void favoritaContato() {
        this.favorito = true;
    }

    /**
     * Remove o status de favorito de um conatato.
     */
    public void desfavoritaContato() {
        this.favorito = false;
    }

    /**
     * Método getter que retorna nome, sobrenome, telefone
     * @return String(nome, sobrenome, telefone)
     */
    public String getContato() {
        if (this.favorito) {
            return "❤ " + this.nome + " " + this.sobrenome + "\n" + this.telefone;
        }
        return this.nome + " " + this.sobrenome + "\n" + this.telefone;
    }

    /**
     * Método getter que retorna o nome do contato
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método getter que retorna o sobrenome do contato
     * @return sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }
}