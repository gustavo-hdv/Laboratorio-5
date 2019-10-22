package pacotepadrao;

/** Representação de uma compra */

public class Compra {
	/** data da compra (String) */
	private String dataCompra;
	/** nome do produto (String) */
	private String nomeProduto;
	/** valor do produto (double) */
	private double valorProduto;
	/** Nome do cliente */
	private String nomeCliente;
	/** Nome do fornecedor */
	private String nomeFornecedor;
	/** Descrição do produto */
	private String descricao;
	
	/** Constrói um objeto Compra
	 * 
	 * @param data da compra (String)
	 * @param nome do produto (String)
	 * @param valor do produto (double)
	 */
	public Compra(String dataCompra, String nomeProduto, double valorProduto, String descricao, String nomeCliente, String nomeFornecedor) {
		this.dataCompra = dataCompra.replace("/", "-");
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.nomeCliente = nomeCliente;
		this.nomeFornecedor = nomeFornecedor;
		this.descricao = descricao;
	}
	
	/** String para ordenação por cliente 
	 * 
	 * @return nomeCliente, nomeFornecedor, descrição, data da compra (String)
	 */
	public String ordenarCliente() {
		return this.nomeCliente + ", " + this.nomeFornecedor + ", " + this.descricao + ", " + this.dataCompra.replace('-', '/');
	}
	
	/** String para ordenação por fornecedor 
	 * 
	 * @return nomeFornecedor, nomeCliente, descrição, data da compra (String)
	 */
	public String ordenarFornecedor() {
		return this.nomeFornecedor + ", " + this.nomeCliente + ", " + this.descricao + ", " + this.dataCompra.replace('-', '/');
	}
	
	/** String para ordenação por data 
	 * 
	 * @return data da compra, nome do cliente, nome do fornecedor, descrição da compra (String)
	 */
	public String ordenarData() {
		return this.dataCompra.replace('-', '/') + ", " + this.nomeCliente + ", " + this.nomeFornecedor + ", " + this.descricao;
	}
	
	/** Retorna o nome do cliente
	 * 
	 * @return nome do cliente (String)
	 */
	public String getNomeCliente() {
		return this.nomeCliente;
	}
	
	/** Retorna o nome do fornecedor
	 * 
	 * @return nome do fornecedor (String)
	 */
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}
	
	/** Retorna a data da compra
	 * 
	 * @return data da compra (String)
	 */
	public String getData() {
		return this.dataCompra;
	}
	
	/** Representação da compra em forma de string
	 *	Estilo: nome do produto - data do produto
	 * 	
	 * @return nome do produto - data do produto (String)
	 */
	public String toString() {
		return this.nomeProduto + " - " + this.dataCompra;
	}

	/** retorna o valor do produto
	 * 
	 * @return valor do produto (double)
	 */
	public double getValor() {
		return this.valorProduto;
	}
}
