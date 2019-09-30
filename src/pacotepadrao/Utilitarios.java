package pacotepadrao;

/** Representação de lançadores de exceção */

public class Utilitarios {
	/** Lança NullPointerException ao receber algo nulo
	 * 
	 * @param Mensagem do usuário (String)
	 * @param Valor a ser analisado (String)
	 */
	public static void NullException(String mensagem, String valor) {
		if (valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
	
	/** Lança IllegalArgumentException ao receber algo vazio
	 * 
	 * @param Mensagem do usuário (String)
	 * @param Valor a ser analisado (String)
	 */
	public static void EmptyException(String mensagem, String valor) {
		if (valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	/** Lança IllegalArgumentException ao receber um número negativo
	 * 
	 * @param Mensagem do usuário (String)
	 * @param Valor a ser analisado (double)
	 */
	public static void NumberException(String mensagem, double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
