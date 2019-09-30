package pacotepadrao;

/** Representação de um delegador*/

public class Facade {
	/** Controlador de Fornecedores*/
	private FornecedorController fornecedorController = new FornecedorController();
	/** Controlador de Clientes*/
	private ClienteController clienteController = new ClienteController();
	
	/** Cadastra um Cliente
	 * 
	 * @param Nome do Cliente (String)
	 * @param Email do Cliente (String)
	 * @param Localização do Cliente (String)
	 * 
	 * @return CPF do Cliente(String)
	 */
	public String cadastraCliente(String nomeCliente, String emailCliente, String localizacaoCliente, String cpfCliente) {
		return this.clienteController.cadastraCliente(nomeCliente, emailCliente, localizacaoCliente, cpfCliente);
	}
	
	/** Representação de um Cliente
	 * 
	 * @param CPF do Cliente(String)
	 * 
	 * @return nome - localização - email (String)
	 */
	public String getCliente(String cpfCliente) {
		return clienteController.getCliente(cpfCliente);
	}
	
	/** Representação de todos os Clientes
	 *  Estilo: nome - localização - email | nome - localização - email | ...
	 * 
	 * @return nome - localização - email (String) | ...
	 */
	public String getClientes() {
		return clienteController.getClientes();
	}
	
	/** Determina o email de um Cliente
	 * 
	 * @param Email do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public void setEmailCliente(String emailCliente, String cpfCliente) {
		this.clienteController.setClienteEmail(emailCliente, cpfCliente);
	}
	
	/** Determina o nome de um Cliente
	 * 
	 * @param Nome do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public void setNomeCliente(String nomeCliente, String cpfCliente) {
		this.clienteController.setClienteNome(nomeCliente, cpfCliente);
	}
	
	/** Determina a localização de um Cliente
	 * 
	 * @param Localização do Cliente (String)
	 * @param CPF do Cliente (String)
	 */
	public void setLocalizacaoCliente(String localizacaoCliente, String cpfCliente) {
		this.clienteController.setClienteLocalizacao(localizacaoCliente, cpfCliente);
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
	public String cadastraFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		return this.fornecedorController.cadastraFornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor);
	}
	
	/** Representação do Fornecedor
	 *  Estilo: nome - email - telefone
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - email - telefone (String)
	 */
	public String getFornecedor(String nomeFornecedor) {
		return this.fornecedorController.getFornecedor(nomeFornecedor);
	}
	
	/** Representação de todos os Fornecedores
	 *  Estilo: nome - email - telefone | nome - email - telefone | ...
	 *  
	 *  @return nome - email - telefone | ...
	 */
	public String getFornecedores() {
		return this.fornecedorController.getFornecedores();
	}
	
	/** Determina o Email de um Fornecedor
	 * 
	 * @param Email do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void setEmailFornecedor(String emailFornecedor, String nomeFornecedor) {
		this.fornecedorController.setFornecedorEmail(emailFornecedor, nomeFornecedor);
	}
	
	/** Determina o Telefone de um Fornecedor
	 * 
	 * @param Telefone do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void setTelefoneFornecedor(String telefoneFornecedor, String nomeFornecedor) {
		this.fornecedorController.setFornecedorTelefone(telefoneFornecedor, nomeFornecedor);
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
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		this.fornecedorController.cadastraProduto(nomeProduto, descricaoProduto, valorProduto, nomeFornecedor);
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
	public String getProdutoFornecedor(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		return this.fornecedorController.getProduto(nomeProduto, descricaoProduto, nomeFornecedor) + System.lineSeparator();
	}
	
	/** Representação de todos os Produtos de um Fornecedor
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String getProdutosFornecedor(String nomeFornecedor) {
		return this.fornecedorController.getProdutos(nomeFornecedor);
	}
	
	/** Representação de todos os Produtos dos Fornecedores
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String getProdutosFornecedores() {
		return this.fornecedorController.getProdutos();
	}
	
	/** Determina o valor do Produto
	 * 
	 * @param Valor do Produto (double)
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		this.fornecedorController.setProdutoValor(valorProduto, nomeProduto, descricaoProduto, nomeFornecedor);
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
