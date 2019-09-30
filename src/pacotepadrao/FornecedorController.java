package pacotepadrao;

/** Representação do Controlador de Fornecedores*/

import java.util.HashMap;

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
	public String cadastraFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		if (!hasFornecedor(nomeFornecedor)) {
			this.fornecedores.put(nomeFornecedor, new Fornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor));
			return nomeFornecedor;
		} throw new IllegalArgumentException("Fornecedor já cadastrado.");
	}
	
	/** Cadastro de um produto
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Valor do Produto (double)
	 * @param Nome do Fornecedor (String)
	 */
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (!hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, valorProduto);
				return;
			} throw new IllegalArgumentException("Produto já cadastrado");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	/** Representação do Fornecedor
	 *  Estilo: nome - email - telefone
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - email - telefone (String)
	 */
	public String getFornecedor(String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).toString();
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	/** Representação de todos os Fornecedores
	 *  Estilo: nome - email - telefone | nome - email - telefone | ...
	 *  
	 *  @return nome - email - telefone | ...
	 */
	public String getFornecedores() {
		String toStringFornecedores = "";
		int contador = this.fornecedores.size();
		for (String nomeFornecedor: this.fornecedores.keySet()) {
			if (contador != 1) {
				toStringFornecedores += this.fornecedores.get(nomeFornecedor).toString() + " | ";
			} else {
				toStringFornecedores += this.fornecedores.get(nomeFornecedor).toString() + System.lineSeparator();
			}
			contador--;
		}
		return toStringFornecedores;
	}
	
	/** Determina o Email de um Fornecedor
	 * 
	 * @param Email do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void setFornecedorEmail(String emailFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Email nulo", emailFornecedor);
			Utilitarios.EmptyException("Email vazio", emailFornecedor);
			this.fornecedores.get(nomeFornecedor).setEmail(emailFornecedor);
			return;
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	/** Determina o Telefone de um Fornecedor
	 * 
	 * @param Telefone do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void setFornecedorTelefone(String telefoneFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Telefone nulo", telefoneFornecedor);
			Utilitarios.EmptyException("Telefone vazio", telefoneFornecedor);
			this.fornecedores.get(nomeFornecedor).setTelefone(telefoneFornecedor);
			return;
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	/** Determina o valor do Produto
	 * 
	 * @param Valor do Produto (double)
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).setProdutoValor(valorProduto, nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
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
	public String getProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				return this.fornecedores.get(nomeFornecedor).getProduto(nomeProduto, descricaoProduto) + System.lineSeparator();
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	/** Representação de todos os Produtos de um Fornecedor
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String getProdutos(String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).getProdutos();
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	/** Representação de todos os Produtos dos Fornecedores
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String getProdutos() {
		String toStringProdutos = "";
		int contador = this.fornecedores.size();
		for (String fornecedorKey : this.fornecedores.keySet()) {
			if (contador != 1) {
				toStringProdutos += this.fornecedores.get(fornecedorKey).getProdutos() + " | ";
			} else {
				toStringProdutos += this.fornecedores.get(fornecedorKey).getProdutos() + System.lineSeparator();
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
		if (hasFornecedor(nomeFornecedor)) {
			this.fornecedores.remove(nomeFornecedor);
			return;
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	/** Remove um Produto de um Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
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
