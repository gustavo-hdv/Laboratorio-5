package defaultpackage;

import java.util.HashMap;

public class FornecedorController {
	private HashMap<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
	
	public String cadastraFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		if (!hasFornecedor(nomeFornecedor)) {
			this.fornecedores.put(nomeFornecedor, new Fornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor));
			return nomeFornecedor;
		} throw new IllegalArgumentException("Fornecedor já cadastrado.");
	}
	
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (!hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, valorProduto);
			} throw new IllegalArgumentException("Produto já cadastrado");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getFornecedor(String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			return this.getFornecedor(nomeFornecedor).toString() + System.lineSeparator();
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getFornecedores() {
		String toStringFornecedores = "";
		int contador = this.fornecedores.size();
		for (String nomeFornecedor: this.fornecedores.keySet()) {
			if (contador != 0) {
				toStringFornecedores += this.fornecedores.get(nomeFornecedor).toString() + " | " + System.lineSeparator();
			} else {
				toStringFornecedores += this.fornecedores.get(nomeFornecedor).toString() + System.lineSeparator();
			}
			contador--;
		}
		return toStringFornecedores;
	}
	
	public void setFornecedorEmail(String emailFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Email nulo", emailFornecedor);
			Utilitarios.EmptyException("Email vazio", emailFornecedor);
			this.fornecedores.get(nomeFornecedor).setEmail(emailFornecedor);
			return;
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public void setFornecedorTelefone(String telefoneFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Telefone nulo", telefoneFornecedor);
			Utilitarios.EmptyException("Telefone vazio", telefoneFornecedor);
			this.fornecedores.get(nomeFornecedor).setTelefone(telefoneFornecedor);
			return;
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).setProdutoValor(valorProduto, nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				return this.fornecedores.get(nomeFornecedor).getProduto(nomeProduto, descricaoProduto) + System.lineSeparator();
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getProdutos(String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).getProdutos();
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getProdutos() {
		String toStringProdutos = "";
		int contador = this.fornecedores.size();
		for (String fornecedorKey : this.fornecedores.keySet()) {
			if (contador != 0) {
				toStringProdutos += this.fornecedores.get(fornecedorKey).getProdutos() + " | " + System.lineSeparator();
			} else {
				toStringProdutos += this.fornecedores.get(fornecedorKey).getProdutos() + System.lineSeparator();
			}
			contador--;
		}
		return toStringProdutos;
	}
	
	public void removeFornecedor(String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			this.fornecedores.remove(nomeFornecedor);
			return;
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public void removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricaoProduto);
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	private boolean hasFornecedor(String nomeFornecedor) {
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			return true;
		} return false;
	}
	
	private boolean hasProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (this.fornecedores.get(nomeFornecedor).hasProduto(nomeProduto, descricaoProduto)) {
			return true;
		} return false;
	}
}
