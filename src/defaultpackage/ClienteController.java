package defaultpackage;

import java.util.HashMap;

public class ClienteController {
	private HashMap<String, Cliente> clientes;
	
	public ClienteController() {
		this.clientes = CadastroController.getMapaClientes();
	}
	
	public String getCliente(String cpfCliente) {
		if (CadastroController.hasCliente(cpfCliente)) {
			return clientes.get(cpfCliente).toString() + System.lineSeparator();
		}
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	public String getClientes() {
		String toStringClientes = "";
		int contador = clientes.size();
		for (String cpfCliente : clientes.keySet()) {
			if (contador != 0) {
				toStringClientes += clientes.get(cpfCliente).toString() + " | " + System.lineSeparator();
			} else {
				toStringClientes += clientes.get(cpfCliente).toString() + System.lineSeparator();
			}
			contador--;
		}
		return toStringClientes;
	}
	
	public void setClienteLocalizacao(String localizacaoCliente, String cpfCliente) {
		if (CadastroController.hasCliente(cpfCliente)) {
			Utilitarios.NullException("Localização nulo", localizacaoCliente);
			Utilitarios.EmptyException("Localização vazio", localizacaoCliente);
			clientes.get(cpfCliente).setLocalizacao(localizacaoCliente);
		}
	}
	
	public void setClienteNome(String nomeCliente, String cpfCliente) {
		if (CadastroController.hasCliente(cpfCliente)) {
			Utilitarios.NullException("Nome nulo", nomeCliente);
			Utilitarios.EmptyException("Nome vazio", nomeCliente);
			clientes.get(cpfCliente).setNome(nomeCliente);
		} 
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	public void setClienteEmail(String emailCliente, String cpfCliente) {
		if (CadastroController.hasCliente(cpfCliente)) {
			Utilitarios.NullException("Email nulo", emailCliente);
			Utilitarios.EmptyException("Email vazio", emailCliente);
			clientes.get(cpfCliente).setEmail(emailCliente);
		}
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
	
	public void removeCliente(String cpfCliente) {
		if (CadastroController.hasCliente(cpfCliente)) {
			clientes.remove(cpfCliente);
			return;
		} 
		throw new IllegalArgumentException("Cliente não cadastrado.");
	}
}
