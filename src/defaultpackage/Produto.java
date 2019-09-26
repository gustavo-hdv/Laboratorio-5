package defaultpackage;

import java.text.DecimalFormat;

public class Produto {
	private String nome;
	private String descricao;
	private double valor;
	
	public Produto(String nome, String descricao, double valor) {
		if (nome == null) throw new NullPointerException("Nome nao pode ser nulo");
		if (nome.trim().equals("")) throw new IllegalArgumentException("Nome nao pode ser vazio");
		
		if (descricao == null) throw new NullPointerException("Descricao nao pode ser nulo");
		if (descricao.trim().equals("")) throw new IllegalArgumentException("Descricao nao pode ser vazio");
		
		if (valor < 0) throw new IllegalArgumentException("Valor nao pode ser negativo");
		
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public void setValor(double valor) {
		if (valor < 0) throw new IllegalArgumentException("Valor nao pode ser negativo");
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		DecimalFormat df2 = new DecimalFormat("#.##");
		return this.nome + " - " + this.descricao + " - R$" + df2.format(this.valor);
	}
}
