package pacotepadrao;

/** Representação de um Produto
 *  Recebe: Nome, Descrição e Valor*/

import java.text.DecimalFormat;

public class Produto {
	/** Nome do Produto (String)*/
	private String nome;
	/** Descrição do Produto (String)*/
	private String descricao;
	/** Valor do Produto (double)*/
	private double valor;
	
	/** Construtor: constrói um produto com nome, descrição e valor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Valor do Produto (double)
	 */
	public Produto(String nomeProduto, String descricaoProduto, double valorProduto) {
		Utilitarios.NullException("Nome nulo", nomeProduto);
		Utilitarios.EmptyException("Nome vazio", nomeProduto);
		Utilitarios.NullException("Descrição nulo", descricaoProduto);
		Utilitarios.EmptyException("Descrição vazio", descricaoProduto);
		Utilitarios.NumberException("Valor negativo", valorProduto);
		
		this.nome = nomeProduto;
		this.descricao = descricaoProduto;
		this.valor = valorProduto;
	}
	
	/** Determina o valor do produto
	 * 
	 *  @param Valor do Produto (double)
	 */
	public void setValor(double valorProduto) {
		Utilitarios.NumberException("Valor negativo", valorProduto);
		this.valor = valorProduto;
	}
	
	/** Representação de um Produto
	 *  Estilo: nome - descrição - valor (formatado 2 casas decimais)
	 *  
	 * @return nome - descrição - valor (String)
	 */
	@Override
	public String toString() {
		DecimalFormat df2 = new DecimalFormat("#.##");
		return this.nome + " - " + this.descricao + " - R$" + df2.format(this.valor);
	}
	
	/** hashCode para Nome e Descrição do Produto*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/** equals para Nome e Descrição do Produto*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
