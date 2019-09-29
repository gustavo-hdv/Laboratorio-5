package defaultpackage;

public class Facade {
	private CadastroController cadastroController = new CadastroController();
	private FornecedorController fornecedorController = new FornecedorController();
	private ClienteController clienteController = new ClienteController();
	
	public String cadastraCliente(String nomeCliente, String emailCliente, String localizacaoCliente, String cpfCliente) {
		return this.cadastroController.cadastraCliente(nomeCliente, emailCliente, localizacaoCliente, cpfCliente);
	}
	
	public String getCliente(String cpfCliente) {
		return clienteController.getCliente(cpfCliente);
	}
	
	public String getClientes() {
		return clienteController.getClientes();
	}
	
	public void setEmailCliente(String emailCliente, String cpfCliente) {
		this.clienteController.setClienteEmail(emailCliente, cpfCliente);
	}
	
	public void setNomeCliente(String nomeCliente, String cpfCliente) {
		this.clienteController.setClienteNome(nomeCliente, cpfCliente);
	}
	
	public void setLocalizacaoCliente(String localizacaoCliente, String cpfCliente) {
		this.clienteController.setClienteLocalizacao(localizacaoCliente, cpfCliente);
	}
	
	public void removeCliente(String cpfCliente) {
		clienteController.removeCliente(cpfCliente);
	}
	
	public String cadastraFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		return this.cadastroController.cadastraFornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor);
	}
	
	public String getFornecedor(String nomeFornecedor) {
		return this.fornecedorController.getFornecedor(nomeFornecedor);
	}
	
	public String getFornecedores() {
		return this.fornecedorController.getFornecedores();
	}
	
	public void setEmailFornecedor(String emailFornecedor, String nomeFornecedor) {
		this.fornecedorController.setFornecedorEmail(emailFornecedor, nomeFornecedor);
	}
	
	public void setTelefoneFornecedor(String telefoneFornecedor, String nomeFornecedor) {
		this.fornecedorController.setFornecedorTelefone(telefoneFornecedor, nomeFornecedor);
	}
	
	public void removeFornecedor(String nomeFornecedor) {
		this.fornecedorController.removeFornecedor(nomeFornecedor);
	}
	
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		this.cadastroController.cadastraProduto(nomeProduto, descricaoProduto, valorProduto, nomeFornecedor);
	}
	
	public String getProdutoFornecedor(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		return this.fornecedorController.getProduto(nomeProduto, descricaoProduto, nomeFornecedor) + System.lineSeparator();
	}
	
	public String getProdutosFornecedor(String nomeFornecedor) {
		return this.fornecedorController.getProdutos(nomeFornecedor);
	}
	
	public String getProdutosFornecedores() {
		return this.fornecedorController.getProdutos();
	}
	
	public void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		this.fornecedorController.setProdutoValor(valorProduto, nomeProduto, descricaoProduto, nomeFornecedor);
	}
	
	public void removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		this.fornecedorController.removeProduto(nomeProduto, descricaoProduto, nomeFornecedor);
	}
}
