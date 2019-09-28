package defaultpackage;

public class Cliente extends Pessoa {
	private String localizacao;
	private String cpf;
	
	public Cliente(String nomeCliente, String emailCliente, String localizacaoCliente, String cpfCliente) {
		super(nomeCliente, emailCliente);
		Utilitarios.NullException("Localização nulo", localizacaoCliente);
		Utilitarios.NullException("CPF nulo", cpfCliente);
		Utilitarios.EmptyException("Localização vazio", localizacaoCliente);
		Utilitarios.EmptyException("CPF vazio", cpfCliente);
		
		this.localizacao = localizacaoCliente;
		this.cpf = cpfCliente;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setLocalizacao(String localizacaoCliente) {
		Utilitarios.NullException("Localização nulo", localizacaoCliente);
		Utilitarios.EmptyException("Localização vazio", localizacaoCliente);
		this.localizacao = localizacaoCliente;
	}
	
	public void setNome(String nomeCliente) {
		Utilitarios.NullException("Nome nulo", nomeCliente);
		Utilitarios.EmptyException("Nome vazio", nomeCliente);
		this.nome = nomeCliente;
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
