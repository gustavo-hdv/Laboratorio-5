package pacotepadrao;

/** Representação de um cliente
 *  Recebe: Nome, Email, CPF e Localização
 */

public class Cliente extends Pessoa {
	/** Localização do Cliente (String)*/
	private String localizacao;
	/** CPF do Cliente (String)*/
	private String cpf;
	
	/** Construtor:
	 * 	Constrói um cliente com nome, email, localização, cpf.
	 * 
	 * @param Nome do Cliente (String)
	 * @param Email do Cliente (String)
	 * @param Localização do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public Cliente(String nomeCliente, String emailCliente, String localizacaoCliente, String cpfCliente) {
		super(nomeCliente, emailCliente);
		Utilitarios.NullException("Erro no cadastro: localizacao nao pode ser nula.", localizacaoCliente);
		Utilitarios.NullException("Erro no cadastro: cpf nao pode ser nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro no cadastro: localizacao nao pode ser vazia.", localizacaoCliente);
		Utilitarios.EmptyException("Erro no cadastro: cpf nao pode ser vazio.", cpfCliente);
	
		this.localizacao = localizacaoCliente;
		
		if (cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro: cpf invalido.");
		}
		this.cpf = cpfCliente;
	}
	
	/** Determina a localização do Cliente
	 * 
	 * @param Localização do Cliente (String)
	 */
	public void setLocalizacao(String localizacaoCliente) {
		Utilitarios.NullException("Erro na edicao do cliente: atributo nao pode ser nulo.", localizacaoCliente);
		Utilitarios.EmptyException("Erro na edicao do cliente: atributo nao pode ser vazio.", localizacaoCliente);
		this.localizacao = localizacaoCliente;
	}
	
	/** Determina o nome do Cliente
	 * 
	 * @param Nome do Cliente (String)
	 */
	public void setNome(String nomeCliente) {
		Utilitarios.NullException("Erro na edicao do cliente: atributo nao pode ser nulo.", nomeCliente);
		Utilitarios.EmptyException("Erro na edicao do cliente: atributo nao pode ser vazio.", nomeCliente);
		this.nome = nomeCliente;
	}
	
	/** Representação de um Cliente estilo:
	 *  Nome - Localização - Email
	 *
	 *	@return nome - localização - email (String)
	 */
	@Override
	public String toString() {
		return super.toString() + " - " + this.localizacao + " - " + this.email;
	}

	/** hashCode para CPF do Cliente*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/** equals para CPF do Cliente*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
}
