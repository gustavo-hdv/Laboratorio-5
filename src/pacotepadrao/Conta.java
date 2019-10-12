package pacotepadrao;

/** Representação de uma conta com compras com data, nome e valor. */

import java.util.ArrayList;
//import java.util.Comparator;


public class Conta {
	ArrayList<Compra> compras = new ArrayList<Compra>();
	
	/** Adiciona uma compra na lista de compras
	 * 
	 * @param data da compra (String)
	 * @param nome do produto (String)
	 * @param valor do produto (double)
	 */
	public void adicionaCompra(String dataCompra, String nomeProduto, double valorProduto) {
		compras.add(new Compra(dataCompra, nomeProduto, valorProduto));
	}
	
	/** Retorna o débito
	 * 
	 * @return débito das compras
	 */
	public double getDebito() {
		double debito = 0.0;
		for (Compra compra : compras) {
			debito += compra.getValor();
		}
		return debito;
	}
	
	/** Representação das compras em forma de string
	 *	Estilo: nome do produto - data do produto | ...
	 * 	
	 * @return nome do produto - data do produto | ... (String)
	 */
	public String toString() {
		String toStringCompras = "";
		//compras.sort(Comparator.comparing(Compra::toString));
		
		int contador = compras.size();
		for (Compra compra : compras) {
			if (contador != 1) {
				toStringCompras += compra.toString() + " | ";
			} else {
				toStringCompras += compra.toString();
			}
			contador--;
		}
		
		return toStringCompras;
	}
}
