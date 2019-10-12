package pacotepadrao;

public class ProdutoCombo implements Produto {
	/** Nome do Produto (String) */
	private String nome;
	/** Descrição do Produto (String) */
	private String descricao;
	/** Valor do Produto (double) */
	private double valorTotal;
	/** Desconto do produto (double) */
	private double fatorProduto;
	/** Valor sem desconto (double) */
	private double valorBase;
	
	/** Construtor: constrói um produto com nome, descrição e valor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Fator do Produto (double)
	 * @param Produtos que compõe o produto
	 */
	public ProdutoCombo(String nomeProduto, String descricaoProduto, double fatorProduto, double valorTotal) {
		Utilitarios.NullException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", descricaoProduto);
		if (fatorProduto <= 0 || fatorProduto >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		
		this.nome = nomeProduto;
		this.descricao = descricaoProduto;
		this.fatorProduto = fatorProduto;
		this.valorBase = valorTotal;
		this.valorTotal = valorTotal - valorTotal * fatorProduto;
	}

	/** Determina o valor do desconto
	 * 
	 *  @param Valor do desconto (double)
	 */
	public void setValor(double fatorProduto) {
		if (fatorProduto <= 0 || fatorProduto >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		this.fatorProduto = fatorProduto;
		this.valorTotal = this.valorBase - this.valorBase * this.fatorProduto;
	}
	
	/** Retorna o valor do produto 
	 * 
	 * @return valor do produto (double)
	 */
	public double getValor() {
		return this.valorTotal;
	}
	
	/** Representação de um Produto
	 *  Estilo: nome - descrição - valor (formatado 2 casas decimais)
	 *  
	 * @return nome - descrição - valor (String)
	 */
	@Override
	public String toString() {	
		return String.format("%s - %s - R$%.2f", this.nome, this.descricao, this.valorTotal);
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
		ProdutoCombo other = (ProdutoCombo) obj;
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

