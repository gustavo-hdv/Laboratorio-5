package defaultpackage;

public class Pessoa {
	protected String nome;
	protected String email;
	
	public Pessoa(String nome, String email) {
		Utilitarios.NullException("Nome nulo", nome);
		Utilitarios.NullException("Email nulo", email);
		Utilitarios.EmptyException("Nome vazio", nome);
		Utilitarios.EmptyException("Email vazio", email);
		
		this.nome = nome;
		this.email = email;
	}
	
	public void setEmail(String email) {
		Utilitarios.NullException("Email nulo", email);
		Utilitarios.EmptyException("Email vazio", email);
		
		this.email = email;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
