package pacotepadrao;

/** Interface para dois tipos de produto: simples e composto(combo de simples) */

public interface Produto {
	public void setValor(double valorProduto)
	;
	public double getValor();
	
	public String toString();
	
	public int hashCode();
	
	public boolean equals(Object obj);
}
