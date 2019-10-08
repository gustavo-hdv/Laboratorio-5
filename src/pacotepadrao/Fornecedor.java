package pacotepadrao;

/** Representação de um Fornecedor de Produtos */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Utilitarios.NullException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", emailFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", emailFornecedor);
		Utilitarios.NullException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", telefoneFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", telefoneFornecedor);
		
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	/** Determina o Telefone do Fornecedor
	 * 
	 * @param Telefone do Fornecedor (String)
	 */
	public void setTelefone(String telefoneFornecedor) {
		Utilitarios.NullException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", telefoneFornecedor);
		Utilitarios.EmptyException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", telefoneFornecedor);
		
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	public void setEmail(String emailFornecedor) {
		Utilitarios.NullException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo", emailFornecedor);
		Utilitarios.EmptyException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo", emailFornecedor);
		this.email = emailFornecedor;
	}
	
	/** Cadastra um Produto na lista do Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Valor do Produto (double)
	 */
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto) {
		Utilitarios.NullException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.NumberException("Erro no cadastro de produto: preco invalido.", valorProduto);
		
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
		Utilitarios.NullException("Erro na edicao de produto: nome nao pode ser vazia.", nomeProduto);
		Utilitarios.NullException("Erro na edicao de produto: descricao nao pode ser nulo.", descricaoProduto);
		Utilitarios.EmptyException("Erro na edicao de produto: nome nao pode ser vazio.", nomeProduto);
		Utilitarios.EmptyException("Erro na edicao de produto: descricao nao pode ser vazia.", descricaoProduto);
		Utilitarios.NumberException("Erro na edicao de produto: preco invalido.", valorProduto);
		
		if (hasProduto(nomeProduto, descricaoProduto)) {	
			ArrayList<String> key = new ArrayList<>(Arrays.asList(nomeProduto, descricaoProduto));
			this.produtos.get(key).setValor(valorProduto);
			return;
		}
		throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
	}
	
	/** Representação de um Produto
	 *  Estilo: nome - descrição - valor
	 *  
	 *  @param Nome do Produto (String)
	 *  @param Descriçaõ do Produto (String)
	 *
	 *  @return nome - descrição - valor (String)
	 */
	public String exibeProduto(String nomeProduto, String descricaoProduto) {	
		if (hasProduto(nomeProduto, descricaoProduto)) {
			ArrayList<String> key = new ArrayList<>(Arrays.asList(nomeProduto, descricaoProduto));
			return this.produtos.get(key).toString();
		} 
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
	}
	
	/** Representação de todos os Produtos do Fornecedor
	 *  Estilo: NomeFornecedor - NomeProduto - Descrição - Valor, ...
	 *  
	 * @return NomeFornecedor - NomeProduto - Descrição - Valor, ... (String)
	 */
	public String exibeProdutos() {
		if (this.produtos.size() == 0) {
			return super.toString() + " -";
		}
	
		String toStringProdutos = "";
		//Preenche lista de produtos
		List<Produto> produtosOrdenados = new ArrayList<>();
		for (Map.Entry<ArrayList<String>, Produto> produto : this.produtos.entrySet()) {
			produtosOrdenados.add(produto.getValue());
		}
		
		//Ordena lista de produtos
		produtosOrdenados.sort(Comparator.comparing(Produto::toString));
		
		//Preenche toStringProdutos
		int contador = produtosOrdenados.size();
		for (Produto produto : produtosOrdenados) {
			if (contador != 1) {
				toStringProdutos += super.toString() + " - " + produto.toString() + " | ";
			} else {
				toStringProdutos +=super.toString() + " - " + produto.toString();
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
		Utilitarios.NullException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		
		if (hasProduto(nomeProduto, descricaoProduto)) {
			produtos.remove(Arrays.asList(nomeProduto, descricaoProduto));
			return;
		} 
		throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
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

	/** equals para Nome do Fornecedor*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (super.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!super.nome.equals(other.nome))
			return false;
		return true;
	}
	
}
