package defaultpackage;

public class Facade {
	private CadastroController cadastroController = new CadastroController();
	private FornecedorController fornecedorController = new FornecedorController();
	private ClienteController clienteController = new ClienteController();
	
	public void cadastraCliente(String nome, String email, String localizacao, String cpf) {
		this.cadastroController.cadastraCliente(nome, email, localizacao, cpf);
	}
	
	public void cadastraFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		this.cadastroController.cadastraFornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor);
	}
	
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		this.cadastroController.cadastraProduto(nomeProduto, descricaoProduto, valorProduto, nomeFornecedor);
	}
}
