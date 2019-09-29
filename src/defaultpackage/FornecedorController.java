package defaultpackage;

import java.util.HashMap;

public class FornecedorController {
	private HashMap<String, Fornecedor> fornecedores;
	
	public FornecedorController() {
		this.fornecedores = CadastroController.getMapaFornecedores();
	}
	
	public String getFornecedor(String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
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
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Email nulo", emailFornecedor);
			Utilitarios.EmptyException("Email vazio", emailFornecedor);
			this.fornecedores.get(nomeFornecedor).setEmail(emailFornecedor);
			return;
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public void setFornecedorTelefone(String telefoneFornecedor, String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Telefone nulo", telefoneFornecedor);
			Utilitarios.EmptyException("Telefone vazio", telefoneFornecedor);
			this.fornecedores.get(nomeFornecedor).setTelefone(telefoneFornecedor);
			return;
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			if (CadastroController.hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).setProdutoValor(valorProduto, nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			if (CadastroController.hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				return this.fornecedores.get(nomeFornecedor).getProduto(nomeProduto, descricaoProduto) + System.lineSeparator();
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getProdutos(String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).getProdutos();
		}
		throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public String getProdutos() {
		String toStringProdutos = "";
		int contador = fornecedores.size();
		for (String fornecedorKey : fornecedores.keySet()) {
			if (contador != 0) {
				toStringProdutos += fornecedores.get(fornecedorKey).getProdutos() + " | " + System.lineSeparator();
			} else {
				toStringProdutos += fornecedores.get(fornecedorKey).getProdutos() + System.lineSeparator();
			}
		}
		return toStringProdutos;
	}
	
	public void removeFornecedor(String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			fornecedores.remove(nomeFornecedor);
			return;
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public void removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			if (CadastroController.hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricaoProduto);
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
}
