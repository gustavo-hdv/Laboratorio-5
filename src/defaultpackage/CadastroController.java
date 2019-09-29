package defaultpackage;

import java.util.HashMap;

public class CadastroController {
	private static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
	private static HashMap<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
	
	//Clientes
	public String cadastraCliente(String nome, String email, String localizacao, String cpf) {
		if (!clientes.containsKey(cpf)) {
			clientes.put(cpf, new Cliente(nome, email, localizacao, cpf));
			return cpf;
		} throw new IllegalArgumentException("Cliente já cadastrado.");
	}
	
	//Fornecedores
	public String cadastraFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		if (!hasFornecedor(nomeFornecedor)) {
			fornecedores.put(nomeFornecedor, new Fornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor));
			return nomeFornecedor;
		} throw new IllegalArgumentException("Fornecedor já cadastrado.");
	}
	
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (!hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, valorProduto);
			} throw new IllegalArgumentException("Produto já cadastrado");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}

	//Static Methods
	protected static boolean hasFornecedor(String nomeFornecedor) {
		if (fornecedores.containsKey(nomeFornecedor)) {
			return true;
		} return false;
	}
	
	protected static boolean hasProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (fornecedores.get(nomeFornecedor).hasProduto(nomeProduto, descricaoProduto)) {
			return true;
		} return false;
	}
	
	protected static boolean hasCliente(String cpfCliente) {
		if (clientes.containsKey(cpfCliente)) {
			return true;
		} return false;
	}
	
	protected static HashMap<String, Cliente> getMapaClientes() {
		return clientes;
	}
	
	protected static HashMap<String, Fornecedor> getMapaFornecedores() {
		return fornecedores;
	}
}
