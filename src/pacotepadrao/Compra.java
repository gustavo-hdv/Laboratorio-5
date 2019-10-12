package pacotepadrao;

/** Representação de uma compra com data, nome e valor. */

public class Compra {
	/** data da compra (String) */
	private String dataCompra;
	/** nome do produto (String) */
	private String nomeProduto;
	/** valor do produto (double) */
	private double valorProduto;
	
	/** Constrói um objeto Compra
	 * 
	 * @param data da compra (String)
	 * @param nome do produto (String)
	 * @param valor do produto (double)
	 */
	public Compra(String dataCompra, String nomeProduto, double valorProduto) {
		this.dataCompra = dataCompra.replace("/", "-");
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
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
