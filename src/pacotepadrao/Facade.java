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
		args = new String[] { "pacotepadrao.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt", "testes_aceitacao/use_case_4.txt" , "testes_aceitacao/use_case_5.txt", "testes_aceitacao/use_case_6.txt" };
		EasyAccept.main(args);
	}
	
	/** edita o desconto do combo
	 * 
	 * @param nome do combo (String)
	 * @param descrição do combo (String)
	 * @param nome do fornecedor (String)
	 * @param desconto do combo (double)
	 */
	public void editaCombo(String nomeCombo, String descricaoCombo, String nomeFornecedor, double novoFator) {
		this.fornecedorController.editaCombo(nomeCombo, descricaoCombo, nomeFornecedor, novoFator);
	}
	
	/** Adiciona um combo de produto
	 * 
	 * @param nome do fornecedor (String)
	 * @param nome do combo (String)
	 * @param descrição do combo (String)
	 * @param desconto do combo (double)
	 * @param produtos do combo (String)
	 */
	public void adicionaCombo(String nomeFornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
		this.fornecedorController.adicionaCombo(nomeFornecedor, nomeCombo, descricaoCombo, fator, produtos);
	}
	
	/** Exibe a conta de um cliente para todos os fornecedores
	 *  Estilo: "Cliente: nomeCliente | nomeFornecedor | produto - data | nomeFornecedor | produto - data | ...
	 *  
	 *  @param cpf do cliente (String)
	 *  
	 *  @return ""Cliente: nomeCliente | nomeFornecedor | produto - data | nomeFornecedor | produto - data | ..." (String)
	 */
	public String exibeContasClientes(String cpfCliente) {
		return this.fornecedorController.exibeContasClientes(cpfCliente, this.clienteController);
	}
	
	/** Exibe um conta de um cliente para determinado fornecedor
	 *  Estilo: "Cliente: nomeCliente | nomeFornecedor | produto - data | ...
	 *  
	 *  @param cpf do cliente (String)
	 *  @param nome do fornecedor (String)
	 *  
	 *  @return "Cliente: nomeCliente | nomeFornecedor | produto - data | ..." (String)
	 */
	public String exibeContas(String cpfCliente, String nomeFornecedor) {
		return this.fornecedorController.exibeContas(cpfCliente, nomeFornecedor, this.clienteController);
	}
	
	/** Retorna o débito de um cliente para determinado fornecedor
	 * 
	 * @param cpf do cliente (String)
	 * @param nome do fornecedor (String)
	 * 
	 * @return débito do cliente formatado em 2 casas decimais
	 */
	public String getDebito(String cpfCliente, String nomeFornecedor) {
		return this.fornecedorController.getDebito(cpfCliente, nomeFornecedor, this.clienteController);
	}
	
	/** Adiciona a compra de um cliente no mapa de contas de um fornecedor
	 *  Observação: Cria uma conta com o débito do cliente e informações dos produtos comprados se ainda não existir
	 * 
	 * @param cpf do cliente (String) (tamanho 11)
	 * @param nome do fornecedor (String)
	 * @param data da compra (String) (tamanho 10)
	 * @param nome do produto (String)
	 * @param descricao do produto (String)
	 */
	public void adicionaCompra(String cpfCliente, String nomeFornecedor, String dataCompra, String nomeProduto, String descricaoProduto) {
		this.fornecedorController.adicionaCompra(cpfCliente, nomeFornecedor, dataCompra, nomeProduto, descricaoProduto, this.clienteController);
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
	public String exibeFornecedores() {
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
	public String exibeProdutos() {
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
