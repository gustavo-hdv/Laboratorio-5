package defaultpackage;

import java.util.HashMap;

public class ClienteController {
	private HashMap<String, Cliente> clientes;
	
	public ClienteController() {
		this.clientes = CadastroController.getMapaClientes();
	}
	
	public String getCliente(String cpf) {
		return clientes.get(cpf).toString();
	}
	
	public void setClienteLocalizacao(String localizacao, String cpf) {
		clientes.get(cpf).setLocalizacao(localizacao);
	}
	
	public void setClienteNome(String nome, String cpf) {
		clientes.get(cpf).setNome(nome);
	}
	
	public void setClienteEmail(String email, String cpf) {
		clientes.get(cpf).setEmail(email);
	}
}
