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
		Utilitarios.NullException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", nomeCliente);
		Utilitarios.EmptyException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", nomeCliente);
		Utilitarios.NullException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", emailCliente);
		Utilitarios.EmptyException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", emailCliente);
		Utilitarios.NullException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", localizacaoCliente);
		Utilitarios.EmptyException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", localizacaoCliente);
		Utilitarios.NullException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", cpfCliente);
	
		this.localizacao = localizacaoCliente;
		
		if (cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		this.cpf = cpfCliente;
	}
	
	/** Determina a localização do Cliente
	 * 
	 * @param Localização do Cliente (String)
	 */
	public void setLocalizacao(String localizacaoCliente) {
		Utilitarios.NullException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", localizacaoCliente);
		Utilitarios.EmptyException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", localizacaoCliente);
		this.localizacao = localizacaoCliente;
	}
	
	/** Determina o nome do Cliente
	 * 
	 * @param Nome do Cliente (String)
	 */
	public void setNome(String nomeCliente) {
		Utilitarios.NullException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", nomeCliente);
		Utilitarios.EmptyException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", nomeCliente);
		this.nome = nomeCliente;
	}
	
	/** Determina o email do Cliente
	 * 
	 * @param Email no Cliente (String)
	 */
	@Override
	public void setEmail(String emailCliente) {
		Utilitarios.NullException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo", emailCliente);
		Utilitarios.EmptyException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo", emailCliente);
		this.email = emailCliente;
	}
	
	/** Retorna o nome do cliente 
	 * 
	 * @return nome do cliente (String)
	 */
	public String getNome() {
		return this.nome;
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
