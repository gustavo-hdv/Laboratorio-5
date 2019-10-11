package pacotepadrao;

import java.util.ArrayList;
import java.util.Comparator;

public class Conta {
	ArrayList<Compra> compras = new ArrayList<Compra>();
	
	public void adicionaCompra(String dataCompra, String nomeProduto, double valorProduto) {
		compras.add(new Compra(dataCompra, nomeProduto, valorProduto));
	}
	
	public double getDebito() {
		double debito = 0.0;
		for (Compra compra : compras) {
			debito += compra.getValor();
		}
		return debito;
	}
	
	public String toString() {
		String toStringCompras = "";
		compras.sort(Comparator.comparing(Compra::toString));
		
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
