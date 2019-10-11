package pacotepadrao;

public class Compra {
	private String dataCompra;
	private String nomeProduto;
	private double valorProduto;
	
	public Compra(String dataCompra, String nomeProduto, double valorProduto) {
		this.dataCompra = dataCompra;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}
	
	public String toString() {
		return this.nomeProduto + " - " + this.dataCompra;
	}
	
	public double getValor() {
		return this.valorProduto;
	}
}
