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
	public String adicionaCliente(String nome, String email, String localizacao, String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(nome, email, localizacao, cpf));
			return cpf;
		} throw new IllegalArgumentException("Erro no cadastro: cliente ja existe.");
	}
	
	/** Representação de um Cliente
	 * 
	 * @param CPF do Cliente(String)
	 * 
	 * @return nome - localização - email (String)
	 */
	public String exibeCliente(String cpfCliente) {
		Utilitarios.NullException("Erro na exibicao do cliente: cpf nao pode ser nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro na exibicao do cliente: cpf nao pode ser vazio.", cpfCliente);
		
		if (hasCliente(cpfCliente)) {
			return this.clientes.get(cpfCliente).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
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
	
	/** Edita um cliente recebendo o cpf, atributo e novo valor
	 * 
	 * @param cpf do cliente (String)
	 * @param atributo a ser editado (String)
	 * @param novo valor para o atributo (String)
	 */
	public void editaCliente(String cpfCliente, String atributo, String novoValor) {
		Utilitarios.NullException("Erro na edicao do cliente: atributo nao pode ser nulo.", atributo);
		Utilitarios.EmptyException("Erro na edicao do cliente: atributo nao pode ser vazio.", atributo);
		
		if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}
		else if (atributo.equals("nome")) {
			setClienteNome(novoValor, cpfCliente);
		}
		else if (atributo.equals("localizacao")) {
			setClienteLocalizacao(novoValor, cpfCliente);
		}
		else if (atributo.equals("email")) {
			setClienteEmail(novoValor, cpfCliente);
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}
	
	/** Determina a localização de um Cliente
	 * 
	 * @param Localização do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	private void setClienteLocalizacao(String localizacaoCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Erro na edicao do cliente: novo valor nao pode ser nulo.", localizacaoCliente);
			Utilitarios.EmptyException("Erro na edicao do cliente: novo valor nao pode ser vazio.", localizacaoCliente);
			this.clientes.get(cpfCliente).setLocalizacao(localizacaoCliente);
			return;
		}
		throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
	}
	
	/** Determina o nome de um Cliente
	 * 
	 * @param Nome do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	private void setClienteNome(String nomeCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Erro na edicao do cliente: novo valor nao pode ser nulo.", nomeCliente);
			Utilitarios.EmptyException("Erro na edicao do cliente: novo valor nao pode ser vazio.", nomeCliente);
			this.clientes.get(cpfCliente).setNome(nomeCliente);
			return;
		} 
		throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
	}
	
	/** Determina o email de um Cliente
	 * 
	 * @param Email do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	private void setClienteEmail(String emailCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Erro na edicao do cliente: novo valor nao pode ser nulo.", emailCliente);
			Utilitarios.EmptyException("Erro na edicao do cliente: novo valor nao pode ser vazio.", emailCliente);
			this.clientes.get(cpfCliente).setEmail(emailCliente);
			return;
		}
		throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
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
		throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
	}
	
	/** Verifica se tem um Cliente cadastrado
	 * 
	 * @param CPF do Cliente (String)
	 */
	private boolean hasCliente(String cpfCliente) {
		Utilitarios.NullException("Erro na remocao do cliente: cpf nao pode ser nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro na remocao do cliente: cpf nao pode ser vazio.", cpfCliente);
		
		if (clientes.containsKey(cpfCliente)) {
			return true;
		} return false;
	}
}
