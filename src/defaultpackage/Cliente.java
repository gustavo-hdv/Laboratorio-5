package defaultpackage;

public class Cliente extends Pessoa {
	private String localizacao;
	private String cpf;
	
	public Cliente(String nome, String email, String localizacao, String cpf) {
		super(nome, email);
		
		if (localizacao == null) throw new NullPointerException("Localizacao nao pode ser nulo");
		if (localizacao.trim().equals("")) throw new IllegalArgumentException("Localizacao nao pode ser vazio");
		
		if (cpf == null) throw new NullPointerException("Cpf nao pode ser nulo");
		if (cpf.trim().equals("")) throw new IllegalArgumentException("Cpf nao pode ser vazio");

		this.localizacao = localizacao;
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setLocalizacao(String localizacao) {
		if (localizacao == null) throw new NullPointerException("Localizacao nao pode ser nulo");
		if (localizacao.trim().equals("")) throw new IllegalArgumentException("Localizacao nao pode ser vazio");
		this.localizacao = localizacao;
	}
	
	public void setNome(String nome) {
		if (nome == null) throw new NullPointerException("Nome nao pode ser nulo");
		if (nome.trim().equals("")) throw new IllegalArgumentException("Nome nao pode ser vazio");
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		if (email == null) throw new NullPointerException("Email nao pode ser nulo");
		if (email.trim().equals("")) throw new IllegalArgumentException("Email nao pode ser vazio");
		this.email = email;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
}
