package pacotepadrao;

/** Representação de uma pessoa.
 *  Recebe: Nome e Email
 */

public class Pessoa {
	/** Nome de Pessoa (String)*/
	protected String nome;
	/** Email de Pessoa (String)*/
	protected String email;
	
	/** Construtor: constrói Pessoa com Nome e Email
	 * 
	 * @param Nome da Pessoa (String)
	 * @param Email da Pessoa (String)
	 */
	public Pessoa(String nome, String email) {
		Utilitarios.NullException("Nome nulo", nome);
		Utilitarios.NullException("Email nulo", email);
		Utilitarios.EmptyException("Nome vazio", nome);
		Utilitarios.EmptyException("Email vazio", email);
		
		this.nome = nome;
		this.email = email;
	}
	
	/** Determina o Email da Pessoa
	 * 
	 * @param Email da Pessoa (String)
	 */
	public void setEmail(String email) {
		Utilitarios.NullException("Email nulo", email);
		Utilitarios.EmptyException("Email vazio", email);
		
		this.email = email;
	}
	
	/** Representação de Pessoa
	 *  Estilo: Nome de Pessoa
	 *  
	 * @return Nome de Pessoa (String)
	 */
	@Override
	public String toString() {
		return this.nome;
	}
}
