package defaultpackage;

public class Pessoa {
	protected String nome;
	protected String email;
	
	public Pessoa(String nome, String email) {
		if (nome == null) throw new NullPointerException("Nome nao pode ser nulo");
		if (nome.trim().equals("")) throw new IllegalArgumentException("Nome nao pode ser vazio");
		
		if (email == null) throw new NullPointerException("Email nao pode ser nulo");
		if (email.trim().equals("")) throw new IllegalArgumentException("Email nao pode ser vazio");
		
		this.nome = nome;
		this.email = email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
