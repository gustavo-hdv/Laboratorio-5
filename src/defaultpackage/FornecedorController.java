package defaultpackage;

import java.util.HashMap;

public class FornecedorController {
	private HashMap<String, Fornecedor> fornecedores;
	
	public FornecedorController() {
		this.fornecedores = CadastroController.getMapaFornecedores();
	}
	
	public void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			if (CadastroController.hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				fornecedores.get(nomeFornecedor).setProdutoValor(valorProduto, nomeProduto, descricaoProduto);
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
	
	public void getProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (CadastroController.hasFornecedor(nomeFornecedor)) {
			if (CadastroController.hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				fornecedores.get(nomeFornecedor).getProduto(nomeProduto, descricaoProduto);
			} throw new IllegalArgumentException("Produto não cadastrado.");
		} throw new IllegalArgumentException("Fornecedor não cadastrado.");
	}
}
