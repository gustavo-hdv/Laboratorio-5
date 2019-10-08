package pacotepadrao;

import easyaccept.EasyAccept;

/** Representação de um delegador */

public class Facade {
	/** Controlador de Fornecedores*/
	private FornecedorController fornecedorController = new FornecedorController();
	/** Controlador de Clientes*/
	private ClienteController clienteController = new ClienteController();
	
	/** Testes de aceitação */
	public static void main(String[] args) {
		args = new String[] { "pacotepadrao.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt" };
		EasyAccept.main(args);
	}
	
	/** Cadastra um Cliente
	 * 
	 * @param Nome do Cliente (String)
	 * @param Email do Cliente (String)
	 * @param Localização do Cliente (String)
	 * 
	 * @return CPF do Cliente(String)
	 */
	public String adicionaCliente(String cpfCliente, String nomeCliente, String emailCliente, String localizacaoCliente) {
		return this.clienteController.adicionaCliente(nomeCliente, emailCliente, localizacaoCliente, cpfCliente);
	}
	
	/** Representação de um Cliente
	 * 
	 * @param CPF do Cliente(String)
	 * 
	 * @return nome - localização - email (String)
	 */
	public String exibeCliente(String cpfCliente) {
		return this.clienteController.exibeCliente(cpfCliente);
	}
	
	/** Representação de todos os Clientes
	 *  Estilo: nome - localização - email | nome - localização - email | ...
	 * 
	 * @return nome - localização - email (String) | ...
	 */
	public String exibeClientes() {
		return this.clienteController.getClientes();
	}
	
	/** Determina o email de um Cliente
	 * 
	 * @param Email do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public void editaCliente(String cpfCliente, String atributo, String novoValor) {
		this.clienteController.editaCliente(cpfCliente, atributo, novoValor);
	}
	
	/** Remove o Cliente do cadastro
	 * 
	 * @param CPF do Cliente (String)
	 */
	public void removeCliente(String cpfCliente) {
		clienteController.removeCliente(cpfCliente);
	}
	
	/** Cadastro de um Fornecedor
	 * 
	 * @param Nome do Fornecedor (String)
	 * @param Email do Fornecedor (String)
	 * @param Telefone do Fornecedor (String)
	 *
	 * @return Nome do Fornecedor (String)
	 */
	public String adicionaFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		return this.fornecedorController.adicionaFornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor);
	}
	
	/** Representação do Fornecedor
	 *  Estilo: nome - email - telefone
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - email - telefone (String)
	 */
	public String exibeFornecedor(String nomeFornecedor) {
		return this.fornecedorController.exibeFornecedor(nomeFornecedor);
	}
	
	/** Representação de todos os Fornecedores
	 *  Estilo: nome - email - telefone | nome - email - telefone | ...
	 *  
	 *  @return nome - email - telefone | ...
	 */
	public String getFornecedores() {
		return this.fornecedorController.getFornecedores();
	}
	
	/** Edita um atributo do fornecedor
	 * 
	 * @param nome do fornecedor (String)
	 * @param atributo a ser editado (String)
	 * @param novo valor do atributo (String)
	 */
	public void editaFornecedor(String nomeFornecedor, String atributo, String novoValor) {
		this.fornecedorController.editaFornecedor(nomeFornecedor, atributo, novoValor);
	}
	
	/** Remove um Fornecedor cadastrado
	 * 
	 * @param Nome do Fornecedor (String)
	 */
	public void removeFornecedor(String nomeFornecedor) {
		this.fornecedorController.removeFornecedor(nomeFornecedor);
	}
	
	/** Cadastro de um produto
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Valor do Produto (double)
	 * @param Nome do Fornecedor (String)
	 */
	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double valorProduto) {
		this.fornecedorController.adicionaProduto(nomeProduto, descricaoProduto, valorProduto, nomeFornecedor);
	}
	
	/** Representação de um Produto
	 *  Estilo: nome - descrição - valor
	 * 
	 *  @param Nome do Produto (String)
	 *  @param Descrição do Produto (String)
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - descrição - valor(2df) (String)
	 */
	public String exibeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		return this.fornecedorController.exibeProduto(nomeProduto, descricaoProduto, nomeFornecedor);
	}
	
	/** Representação de todos os Produtos de um Fornecedor
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return this.fornecedorController.exibeProdutos(nomeFornecedor);
	}
	
	/** Representação de todos os Produtos dos Fornecedores
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String exibeProdutosFornecedores() {
		return this.fornecedorController.exibeProdutos();
	}
	
	/** Determina o valor do Produto
	 * 
	 * @param Valor do Produto (double)
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void editaProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor, double novoValor) {
		this.fornecedorController.editaProduto(nomeProduto, descricaoProduto, nomeFornecedor, novoValor);
	}
	
	/** Remove um Produto de um Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		this.fornecedorController.removeProduto(nomeProduto, descricaoProduto, nomeFornecedor);
	}
}
