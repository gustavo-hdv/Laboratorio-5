package defaultpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Fornecedor extends Pessoa {
	private String telefoneFornecedor;
	private HashMap<ArrayList<String>, Produto> produtos = new HashMap<ArrayList<String>, Produto>();
	
	public Fornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		super(nomeFornecedor, emailFornecedor);
		Utilitarios.NullException("Telefone nulo", telefoneFornecedor);
		Utilitarios.EmptyException("Telefone vazio", telefoneFornecedor);
		
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	public void setTelefone(String telefoneFornecedor) {
		Utilitarios.NullException("Telefone nulo", telefoneFornecedor);
		Utilitarios.EmptyException("Telefone vazio", telefoneFornecedor);
		
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
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
	
	public String getProduto(String nomeProduto, String descricaoProduto) {
		if (hasProduto(nomeProduto, descricaoProduto)) {
			ArrayList<String> key = new ArrayList<>(Arrays.asList(nomeProduto, descricaoProduto));
			return this.produtos.get(key).toString();
		} 
		throw new IllegalArgumentException("Produto não cadastrado.");
	}
	
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
	
	public void removeProduto(String nomeProduto, String descricaoProduto) {
		if (hasProduto(nomeProduto, descricaoProduto)) {
			produtos.remove(Arrays.asList(nomeProduto, descricaoProduto));
			return;
		} 
		throw new IllegalArgumentException("Produto não cadastrado.");
	}
	
	public boolean hasProduto(String nomeProduto, String descricaoProduto) {
		if (this.produtos.containsKey(Arrays.asList(nomeProduto, descricaoProduto))) {
			return true;
		} 
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + super.email + " - " + this.telefoneFornecedor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((super.nome == null) ? 0 : super.nome.hashCode());
		return result;
	}

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
