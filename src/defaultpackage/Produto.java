package defaultpackage;

import java.text.DecimalFormat;

public class Produto {
	private String nome;
	private String descricao;
	private double valor;
	
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
	
	public void setValor(double valorProduto) {
		Utilitarios.NumberException("Valor negativo", valorProduto);
		this.valor = valorProduto;
	}
	
	@Override
	public String toString() {
		DecimalFormat df2 = new DecimalFormat("#.##");
		return this.nome + " - " + this.descricao + " - R$" + df2.format(this.valor);
	}
}
