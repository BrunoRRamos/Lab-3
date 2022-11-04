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
	 * Acessa a lista de contatos mantida.
	 *
	 * @return O array de contatos.
	 */

	/**
	public String[] getContatos() {
		return this.contatos.clone();
	}
	 /*

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
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

	public void cadastraFavorito(int contatoPosi, int favoritoPosi) {
		contatos[contatoPosi].favoritaContato();
		favoritos[favoritoPosi] = contatos[contatoPosi];
	}

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

	public String getListaContatos() {
		StringBuilder listagemNomes = new StringBuilder();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listagemNomes.append(String.format("%s - %s\n", i + 1, contatos[i].getNome()));
			}
		}
		return listagemNomes.toString();
	}

	public String getFavoritos() {
		StringBuilder listagemFav = new StringBuilder();
		for (int i = 0; i < favoritos.length; i++) {
			if (contatos[i] != null) {
				listagemFav.append(String.format("%s - %s\n", i + 1, favoritos[i].getNome()));
			}
		}
		return listagemFav.toString();
	}

	public void removeFav(int posi) {
		this.favoritos[posi].desfavoritaContato();
		this.favoritos[posi] = null;
	}

}
