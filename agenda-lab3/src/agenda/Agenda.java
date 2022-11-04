package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos.
 *
 * @author nazareno
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;

	private Contato[] contatos; //apenas uma simplificacao de contato
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}

	/**
	 * Retorna o contato da posição especificada.
	 *
	 * @return O array de contatos.
	 */

	public String getContato(int posicao) {
		String contatoInfo = contatos[posicao].getContato();
		return contatoInfo;
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	}

	/**
	 * Cadastra um contato no array favoritos
	 *
	 * @param contatoPosi
	 * @param favoritoPosi
	 */
	public void cadastraFavorito(int contatoPosi, int favoritoPosi) {
		contatos[contatoPosi].favoritaContato();
		favoritos[favoritoPosi] = contatos[contatoPosi];
	}

	/**
	 * Verifica se o nome e sobrenome que estao sendo cadastrados já estão cadastrados em outro contato.
	 *
	 * @param nome
	 * @param sobrenome
	 * @return boolean
	 */
	public boolean verificaNomeContato(String nome, String sobrenome) {
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getNome().equals(nome) && contatos[i].getSobrenome().equals(sobrenome)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Retorna uma relação dos contatos cadastrados.
	 *
	 * @return
	 */
	public String getListaContatos() {
		StringBuilder listagemNomes = new StringBuilder();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listagemNomes.append(String.format("%s - %s\n", i + 1, contatos[i].getNome()));
			}
		}
		return listagemNomes.toString();
	}

	/**
	 * Retorna o nome e a posição dos contatos favoritos na lista rápida de acesso.
	 * @return String contatosfavoritos
	 */
	public String getFavoritos() {
		StringBuilder listagemFav = new StringBuilder();
		for (int i = 0; i < favoritos.length; i++) {
			if (contatos[i] != null) {
				listagemFav.append(String.format("%s - %s\n", i + 1, favoritos[i].getNome()));
			}
		}
		return listagemFav.toString();
	}

	/**
	 * Remove um contato favorito da lista rápida de acesso.
	 *
	 * @param posi
	 */
	public void removeFav(int posi) {
		this.favoritos[posi].desfavoritaContato();
		this.favoritos[posi] = null;
	}
}