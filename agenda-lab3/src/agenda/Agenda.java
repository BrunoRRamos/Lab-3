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

	public String retornaContatoInfo(int posicao) {
		try {
			String contatoInfo = contatos[posicao - 1].toString();
			return contatoInfo;
		} catch (Exception e) {
			return "POSIÇÃO INVÁLIDA!";
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao > 100 || posicao < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		if (posicao == 0) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVALIDA");
		}

		if (nome.isBlank()) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}

		if (telefone.isBlank()) {
			throw new IllegalArgumentException("NUMERO INVALIDO");
		}

		if (verificaNomeContato(nome, sobrenome)) {
			throw new IllegalArgumentException("CONTATO JA CADASTRADO");
		}

		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}

	/**
	 * Cadastra um contato no array favoritos
	 *
	 * @param contatoPosi
	 * @param favoritoPosi
	 */
	public void cadastraFavorito(int contatoPosi, int favoritoPosi) {
		if (contatoPosi > 100 || contatoPosi < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		if (favoritoPosi > 10 || favoritoPosi < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		if (contatos[contatoPosi - 1] == null) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		if (contatos[contatoPosi - 1].getFavorito()) {
			throw new IllegalArgumentException("JA FOI FAVORITADO");
		}

		contatos[contatoPosi - 1].favoritaContato();
		favoritos[favoritoPosi - 1] = contatos[contatoPosi - 1];
	}

	/**
	 * Verifica se o nome e sobrenome que estao sendo cadastrados já estão cadastrados em outro contato.
	 *
	 * @param nome
	 * @param sobrenome
	 * @return boolean
	 */
	private boolean verificaNomeContato(String nome, String sobrenome) {
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
	public String returnListaContatos() {
		StringBuilder listagemNomes = new StringBuilder();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listagemNomes.append(String.format("%s - %s\n", i + 1, contatos[i].nomeCompleto()));
			}
		}
		return listagemNomes.toString();
	}

	/**
	 * Retorna o nome e a posição dos contatos favoritos na lista rápida de acesso.
	 * @return String contatosfavoritos
	 */
	public String returnFavoritos() {
	StringBuilder listagemFav = new StringBuilder();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				listagemFav.append(String.format("%s - %s\n", i + 1, this.favoritos[i].nomeCompleto()));
			}
		}
		if (listagemFav.isEmpty()) {
			return "NENHUM FAVORITO";
		}
		return listagemFav.toString();
	}

	/**
	 * Remove um contato favorito da lista rápida de acesso.
	 *
	 * @param posi
	 */
	public void removeFav(int posi) {
		if (posi > 10 || posi < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		if (contatos[posi - 1] == null) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		this.favoritos[posi - 1].desfavoritaContato();
		this.favoritos[posi - 1] = null;
	}
}