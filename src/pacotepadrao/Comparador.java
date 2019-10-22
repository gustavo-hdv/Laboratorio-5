package pacotepadrao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/** Compara clientes para ordenação */
class CompararCliente implements Comparator<Compra> {
	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.ordenarCliente().compareTo(o2.ordenarCliente());
	}
}

/** Compara fornecedores para ordenação */
class CompararFornecedor implements Comparator<Compra> {
	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.ordenarFornecedor().compareTo(o2.ordenarFornecedor());
	}
}

/** Compara datas para ordenação */
class CompararData implements Comparator<Compra> {
	@Override
	public int compare(Compra o1, Compra o2) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date data1 = format.parse(o1.getData());
			Date data2 = format.parse(o2.getData());
			int resultado = data1.compareTo(data2);
			if (resultado == 0) {
				return o1.ordenarCliente().compareTo(o2.ordenarCliente());
			}
			return resultado;
		} catch (ParseException e) {
			throw new IllegalArgumentException("Desgraça de usuario maldito.");
		}
	}
}

public class Comparador {
	
}
