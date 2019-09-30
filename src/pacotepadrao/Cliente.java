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
		Utilitarios.NullException("Localização nulo", localizacaoCliente);
		Utilitarios.NullException("CPF nulo", cpfCliente);
		Utilitarios.EmptyException("Localização vazio", localizacaoCliente);
		Utilitarios.EmptyException("CPF vazio", cpfCliente);
		
		this.localizacao = localizacaoCliente;
		this.cpf = cpfCliente;
	}
	
	/** Determina a localização do Cliente
	 * 
	 * @param Localização do Cliente (String)
	 */
	public void setLocalizacao(String localizacaoCliente) {
		Utilitarios.NullException("Localização nulo", localizacaoCliente);
		Utilitarios.EmptyException("Localização vazio", localizacaoCliente);
		this.localizacao = localizacaoCliente;
	}
	
	/** Determina o nome do Cliente
	 * 
	 * @param Nome do Cliente (String)
	 */
	public void setNome(String nomeCliente) {
		Utilitarios.NullException("Nome nulo", nomeCliente);
		Utilitarios.EmptyException("Nome vazio", nomeCliente);
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
