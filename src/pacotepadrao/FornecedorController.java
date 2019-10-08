package pacotepadrao;

import java.util.ArrayList;
import java.util.Comparator;

/** Representação do Controlador de Fornecedores*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FornecedorController {
	/** Mapa de Fornecedores por seu nome*/
	private HashMap<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
	
	/** Cadastro de um Fornecedor
	 * 
	 * @param Nome do Fornecedor (String)
	 * @param Email do Fornecedor (String)
	 * @param Telefone do Fornecedor (String)
	 *
	 * @return Nome do Fornecedor (String)
	 */
	public String adicionaFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		Utilitarios.NullException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", emailFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", emailFornecedor);
		Utilitarios.NullException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", telefoneFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", telefoneFornecedor);
		
		if (!hasFornecedor(nomeFornecedor)) {
			this.fornecedores.put(nomeFornecedor, new Fornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor));
			return nomeFornecedor;
		} throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
	}
	
	/** Cadastro de um produto
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Valor do Produto (double)
	 * @param Nome do Fornecedor (String)
	 */
	public void adicionaProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		Utilitarios.NullException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.NumberException("Erro no cadastro de produto: preco invalido.", valorProduto);
		
		if (hasFornecedor(nomeFornecedor)) {
			if (!hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, valorProduto);
				return;
			} throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		} throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
	}
	
	/** Representação do Fornecedor
	 *  Estilo: nome - email - telefone
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - email - telefone (String)
	 */
	public String exibeFornecedor(String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}
	
	/** Representação de todos os Fornecedores
	 *  Estilo: nome - email - telefone | nome - email - telefone | ...
	 *  
	 *  @return nome - email - telefone | ...
	 */
	public String getFornecedores() {
		String toStringFornecedores = "";
		
		//Preenche lista com fornecedores
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>();
		for (Map.Entry<String, Fornecedor> fornecedor : fornecedores.entrySet()) {
			fornecedoresOrdenados.add(fornecedor.getValue());
		}
		
		//Ordena lista de fornecedores
		fornecedoresOrdenados.sort(Comparator.comparing(Fornecedor::toString));
		
		//Preenche toStringFornecedores
		int contador = fornecedoresOrdenados.size();
		for (Fornecedor fornecedor: fornecedoresOrdenados) {
			if (contador != 1) {
				toStringFornecedores += fornecedor.toString() + " | ";
			} else {
				toStringFornecedores += fornecedor.toString();
			}
			contador--;
		}
		return toStringFornecedores;
	}
	
	/** Edita um fornecedor recebendo o nome, atributo e novo valor
	 * 
	 * @param nome do fornecedor (String)
	 * @param atributo a ser editado (String)
	 * @param novo valor para o atributo (String)
	 */
	public void editaFornecedor(String nomeFornecedor, String atributo, String novoValor) {
		Utilitarios.NullException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", atributo);
		Utilitarios.EmptyException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", atributo);
		Utilitarios.NullException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		else if (atributo.equals("email")) {
			setFornecedorEmail(novoValor, nomeFornecedor);
		}
		else if (atributo.equals("telefone")) {
			setFornecedorTelefone(novoValor, nomeFornecedor);
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	
	/** Edita o valor de um produto
	 * 
	 * @param nome do produto (String)
	 * @param descrição do produto (String)
	 * @param nome do fornecedor (String)
	 * @param novo valor do produto (double)
	 */
	public void editaProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor, double novoValor) {
		Utilitarios.NullException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.NumberException("Erro na edicao de produto: preco invalido.", novoValor);
		
		setProdutoValor(novoValor, nomeProduto, descricaoProduto, nomeFornecedor);
		
	}
	
	/** Determina o valor do Produto
	 * 
	 * @param Valor do Produto (double)
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	private void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NumberException("Erro na edicao de produto: preco invalido.", valorProduto);
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).setProdutoValor(valorProduto, nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		} throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
	}
	
	/** Determina o Email de um Fornecedor
	 * 
	 * @param Email do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	private void setFornecedorEmail(String emailFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", emailFornecedor);
			Utilitarios.EmptyException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", emailFornecedor);
			this.fornecedores.get(nomeFornecedor).setEmail(emailFornecedor);
			return;
		}
		throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
	}
	
	/** Determina o Telefone de um Fornecedor
	 * 
	 * @param Telefone do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	private void setFornecedorTelefone(String telefoneFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", telefoneFornecedor);
			Utilitarios.EmptyException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", telefoneFornecedor);
			this.fornecedores.get(nomeFornecedor).setTelefone(telefoneFornecedor);
			return;
		}
		throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
	}
	
	
	/** Representação de um Produto
	 *  Estilo: nome - descrição - valor
	 * 
	 *  @param Nome do Produto (String)
	 *  @param Descrição do Produto (String)
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - descrição - valor(2df) (String)
	 */
	public String exibeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		Utilitarios.NullException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				return this.fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricaoProduto);
			} throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		} throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}
	
	/** Representação de todos os Produtos de um Fornecedor
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String exibeProdutos(String nomeFornecedor) {
		Utilitarios.NullException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).exibeProdutos();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}
	
	/** Representação de todos os Produtos dos Fornecedores
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String exibeProdutos() {
		String toStringProdutos = "";
		
		//Preenche lista de fornecedores
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>();
		for (Map.Entry<String, Fornecedor> fornecedor : fornecedores.entrySet()) {
			fornecedoresOrdenados.add(fornecedor.getValue());
		}
		
		//Ordena lista de fornecedores
		fornecedoresOrdenados.sort(Comparator.comparing(Fornecedor::toString).thenComparing(Fornecedor::exibeProdutos));
		
		//Preenche toStringProdutos
		int contador = fornecedoresOrdenados.size();
		for (Fornecedor fornecedor : fornecedoresOrdenados) {
			if (contador != 1) {
				toStringProdutos += fornecedor.exibeProdutos() + " | ";
			} else {
				toStringProdutos += fornecedor.exibeProdutos();
			}
			contador--;
		}
		return toStringProdutos;
	}
	
	/** Remove um Fornecedor cadastrado
	 * 
	 * @param Nome do Fornecedor (String)
	 */
	public void removeFornecedor(String nomeFornecedor) {
		Utilitarios.NullException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (hasFornecedor(nomeFornecedor)) {
			this.fornecedores.remove(nomeFornecedor);
			return;
		} throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
	}
	
	/** Remove um Produto de um Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		Utilitarios.NullException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.NullException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		} throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
	}
	
	/** Verifica se existe determinado fornecedor cadastrado
	 * 
	 * @param Nome do Fornecedor (String)
	 */
	private boolean hasFornecedor(String nomeFornecedor) {
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			return true;
		} return false;
	}
	
	/** Verifica se existe um produto cadastrado em um fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	private boolean hasProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (this.fornecedores.get(nomeFornecedor).hasProduto(nomeProduto, descricaoProduto)) {
			return true;
		} return false;
	}
}
