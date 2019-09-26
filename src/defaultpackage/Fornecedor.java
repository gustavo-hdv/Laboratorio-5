package defaultpackage;

import java.util.HashSet;

public class Fornecedor extends Pessoa {
	private String telefone;
	private HashSet<Produto> produtos;
	public Fornecedor(String nome, String email, String telefone) {
		super(nome, email);
		
		if (telefone == null) throw new NullPointerException("Telefone nao pode ser nulo");
		if (telefone.trim().equals("")) throw new IllegalArgumentException("Telefone nao pode ser vazio");
		this.telefone = telefone;
	}
	
	public void setTelefone(String telefone) {
		if (telefone == null) throw new NullPointerException("Telefone nao pode ser nulo");
		if (telefone.trim().equals("")) throw new IllegalArgumentException("Telefone nao pode ser vazio");
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + super.email + " - " + this.telefone;
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
