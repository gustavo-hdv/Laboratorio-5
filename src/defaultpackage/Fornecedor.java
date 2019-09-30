package defaultpackage;

/** Representação de um Fornecedor de Produtos */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Fornecedor extends Pessoa {
	/** Telefone do Fornecedor (String) */
	private String telefoneFornecedor;
	/** Mapa de Produtos por nome e descrição */
	private HashMap<ArrayList<String>, Produto> produtos = new HashMap<ArrayList<String>, Produto>();
	
	/** Construtor: constrói um Fornecedor com Nome, Email e Telefone
	 * 
	 * @param Nome do Fornecedor (String)
	 * @param Email do Fornecedor (String)
	 * @param Telefone do Fornecedor (String)
	 */
	public Fornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		super(nomeFornecedor, emailFornecedor);
		Utilitarios.NullException("Telefone nulo", telefoneFornecedor);
		Utilitarios.EmptyException("Telefone vazio", telefoneFornecedor);
		
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	/** Determina o Telefone do Fornecedor
	 * 
	 * @param Telefone do Fornecedor (String)
	 */
	public void setTelefone(String telefoneFornecedor) {
		Utilitarios.NullException("Telefone nulo", telefoneFornecedor);
		Utilitarios.EmptyException("Telefone vazio", telefoneFornecedor);
		
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	/** Cadastra um Produto na lista do Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Valor do Produto (double)
	 */
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto) {
		Utilitarios.NullException("Nome nulo", nomeProduto);
		Utilitarios.NullException("Descricao nulo", descricaoProduto);
		Utilitarios.EmptyException("Nome vazio", nomeProduto);
		Utilitarios.EmptyException("Descricao vazio", descricaoProduto);
		Utilitarios.NumberException("Valor negativo", valorProduto);
		
		ArrayList<String> key = new ArrayList<>(Arrays.asList(nomeProduto, descricaoProduto));
		Produto product = new Produto(nomeProduto, descricaoProduto, valorProduto);
		this.produtos.put(key, product);
	}
	
	/** Determina o valor de um Produto
	 * 
	 * @param Valor do Produto (double)
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 */
	public void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto) {
		if (hasProduto(nomeProduto, descricaoProduto)) {
			Utilitarios.NullException("Nome nulo", nomeProduto);
			Utilitarios.NullException("Descricao nulo", descricaoProduto);
			Utilitarios.EmptyException("Nome vazio", nomeProduto);
			Utilitarios.EmptyException("Descricao vazio", descricaoProduto);
			Utilitarios.NumberException("Valor negativo", valorProduto);
			
			ArrayList<String> key = new ArrayList<>(Arrays.asList(nomeProduto, descricaoProduto));
			this.produtos.get(key).setValor(valorProduto);
			return;
		}
		throw new IllegalArgumentException("Produto não cadastrado.");
	}
	
	/** Representação de um Produto
	 *  Estilo: nome - descrição - valor
	 *  
	 *  @param Nome do Produto (String)
	 *  @param Descriçaõ do Produto (String)
	 *
	 *  @return nome - descrição - valor (String)
	 */
	public String getProduto(String nomeProduto, String descricaoProduto) {
		if (hasProduto(nomeProduto, descricaoProduto)) {
			ArrayList<String> key = new ArrayList<>(Arrays.asList(nomeProduto, descricaoProduto));
			return this.produtos.get(key).toString();
		} 
		throw new IllegalArgumentException("Produto não cadastrado.");
	}
	
	/** Representação de todos os Produtos do Fornecedor
	 *  Estilo: NomeFornecedor - NomeProduto - Descrição - Valor | ...
	 *  
	 * @return NomeFornecedor - NomeProduto - Descrição - Valor | ... (String)
	 */
	public String getProdutos() {
		String toStringProdutos = "";
		int contador = produtos.size();
		for (ArrayList<String> produtoKey : produtos.keySet()) {
			if (contador != 0) {
				toStringProdutos += super.toString() + " - " + produtos.get(produtoKey).toString() + " | " + System.lineSeparator();
			} else {
				toStringProdutos += super.toString() + " - " + produtos.get(produtoKey).toString() + System.lineSeparator();
			}
			contador--;
		}
		return toStringProdutos;
	}
	
	/** Remove um Produto cadastrado da lista do Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 */
	public void removeProduto(String nomeProduto, String descricaoProduto) {
		if (hasProduto(nomeProduto, descricaoProduto)) {
			produtos.remove(Arrays.asList(nomeProduto, descricaoProduto));
			return;
		} 
		throw new IllegalArgumentException("Produto não cadastrado.");
	}
	
	/** Verifica se existe um produto cadastrado na lista do Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * 
	 * @return true or false (boolean)
	 */
	public boolean hasProduto(String nomeProduto, String descricaoProduto) {
		if (this.produtos.containsKey(Arrays.asList(nomeProduto, descricaoProduto))) {
			return true;
		} 
		return false;
	}
	
	/** Representação de um Fornecedor
	 *  Estilo: nome - email - telefone
	 *  
	 *  @return nome - email - telefone (String)
	 */
	@Override
	public String toString() {
		return super.toString() + " - " + super.email + " - " + this.telefoneFornecedor;
	}
	
	/** hashCode para nome do Fornecedor*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((super.nome == null) ? 0 : super.nome.hashCode());
		return result;
	}

	/** equals para nome do Fronecedor*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (super.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!super.nome.equals(other.nome))
			return false;
		return true;
	}
	
}
