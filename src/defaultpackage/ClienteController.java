package defaultpackage;

import java.util.HashMap;

public class ClienteController {
	private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
	
	public String cadastraCliente(String nome, String email, String localizacao, String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(nome, email, localizacao, cpf));
			return cpf;
		} throw new IllegalArgumentException("Cliente já cadastrado.");
	}
	
	public String getCliente(String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			return this.clientes.get(cpfCliente).toString() + System.lineSeparator();
		}
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	public String getClientes() {
		String toStringClientes = "";
		int contador = this.clientes.size();
		for (String cpfCliente : this.clientes.keySet()) {
			if (contador != 0) {
				toStringClientes += this.clientes.get(cpfCliente).toString() + " | " + System.lineSeparator();
			} else {
				toStringClientes += this.clientes.get(cpfCliente).toString() + System.lineSeparator();
			}
			contador--;
		}
		return toStringClientes;
	}
	
	public void setClienteLocalizacao(String localizacaoCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Localização nulo", localizacaoCliente);
			Utilitarios.EmptyException("Localização vazio", localizacaoCliente);
			this.clientes.get(cpfCliente).setLocalizacao(localizacaoCliente);
		}
	}
	
	public void setClienteNome(String nomeCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Nome nulo", nomeCliente);
			Utilitarios.EmptyException("Nome vazio", nomeCliente);
			this.clientes.get(cpfCliente).setNome(nomeCliente);
		} 
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	public void setClienteEmail(String emailCliente, String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			Utilitarios.NullException("Email nulo", emailCliente);
			Utilitarios.EmptyException("Email vazio", emailCliente);
			this.clientes.get(cpfCliente).setEmail(emailCliente);
		}
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	public void removeCliente(String cpfCliente) {
		if (hasCliente(cpfCliente)) {
			this.clientes.remove(cpfCliente);
			return;
		} 
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	private boolean hasCliente(String cpfCliente) {
		if (clientes.containsKey(cpfCliente)) {
			return true;
		} return false;
	}
}
