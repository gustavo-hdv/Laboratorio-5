package pacotepadrao;

/** Representação de um Controlador de Clientes*/

import java.util.HashMap;

public class ClienteController {
	/** Mapa de Clientes por seu CPF*/
	private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
	
	/** Cadastra um Cliente
	 * 
	 * @param Nome do Cliente (String)
	 * @param Email do Cliente (String)
	 * @param Localização do Cliente (String)
	 * 
	 * @return CPF do Cliente(String)
	 */
	public String cadastraCliente(String nome, String email, String localizacao, String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(nome, email, localizacao, cpf));
			return cpf;
		} throw new IllegalArgumentException("Cliente já cadastrado.");
	}
	
	/** Representação de um Cliente
	 * 
	 * @param CPF do Cliente(String)
	 * 
	 * @return nome - localização - email (String)
	 */
	public String getCliente(String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			return this.clientes.get(cpfCliente).toString();
		}
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	/** Representação de todos os Clientes
	 *  Estilo: nome - localização - email | nome - localização - email | ...
	 * 
	 * @return nome - localização - email (String) | ...
	 */
	public String getClientes() {
		String toStringClientes = "";
		int contador = this.clientes.size();
		for (String cpfCliente : this.clientes.keySet()) {
			if (contador != 1) {
				toStringClientes += this.clientes.get(cpfCliente).toString() + " | ";
			} else {
				toStringClientes += this.clientes.get(cpfCliente).toString() + System.lineSeparator();
			}
			contador--;
		}
		return toStringClientes;
	}
	
	/** Determina a localização de um Cliente
	 * 
	 * @param Localização do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public void setClienteLocalizacao(String localizacaoCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Localização nulo", localizacaoCliente);
			Utilitarios.EmptyException("Localização vazio", localizacaoCliente);
			this.clientes.get(cpfCliente).setLocalizacao(localizacaoCliente);
			return;
		}
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	/** Determina o nome de um Cliente
	 * 
	 * @param Nome do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public void setClienteNome(String nomeCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Nome nulo", nomeCliente);
			Utilitarios.EmptyException("Nome vazio", nomeCliente);
			this.clientes.get(cpfCliente).setNome(nomeCliente);
			return;
		} 
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	/** Determina o email de um Cliente
	 * 
	 * @param Email do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public void setClienteEmail(String emailCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Email nulo", emailCliente);
			Utilitarios.EmptyException("Email vazio", emailCliente);
			this.clientes.get(cpfCliente).setEmail(emailCliente);
			return;
		}
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	/** Remove o Cliente do cadastro
	 * 
	 * @param CPF do Cliente (String)
	 */
	public void removeCliente(String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			this.clientes.remove(cpfCliente);
			return;
		} 
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	/** Verifica se tem um Cliente cadastrado
	 * 
	 * @param CPF do Cliente (String)
	 */
	private boolean hasCliente(String cpfCliente) {
		if (clientes.containsKey(cpfCliente)) {
			return true;
		} return false;
	}
}
