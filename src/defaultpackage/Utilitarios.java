package defaultpackage;

public class Utilitarios {
	public static void NullException(String mensagem, String valor) {
		if (valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
	
	public static void EmptyException(String mensagem, String valor) {
		if (valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void NumberException(String mensagem, double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
