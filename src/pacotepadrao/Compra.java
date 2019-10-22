package pacotepadrao;

/** Representação de uma compra com data, nome e valor. */

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
	
	public String ordenarCliente() {
		return this.nomeCliente + ", " + this.nomeFornecedor + ", " + this.descricao + ", " + this.dataCompra.replace('-', '/');
	}
	
	public String ordenarFornecedor() {
		return this.nomeFornecedor + ", " + this.nomeCliente + ", " + this.descricao + ", " + this.dataCompra.replace('-', '/');
	}
	
	public String ordenarData() {
		return this.dataCompra.replace('-', '/') + ", " + this.nomeCliente + ", " + this.nomeFornecedor + ", " + this.descricao;
	}
	
	public String getNomeCliente() {
		return this.nomeCliente;
	}
	
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}
	
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
