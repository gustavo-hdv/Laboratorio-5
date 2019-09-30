package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.Utilitarios;

/**
* Representação de testes da classe Utilitarios
*/
class testUtilitarios {
	private Utilitarios utilitarios = new Utilitarios();
	
	@SuppressWarnings("static-access")
	@Test
	void testEmptyException() {
		try {
			utilitarios.EmptyException("Valor vazio", " ");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@SuppressWarnings("static-access")
	@Test
	void testNullException() {
		try {
			utilitarios.NullException("Valor nulo", null);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {
			
		};
	}

	@SuppressWarnings("static-access")
	@Test
	void testNumberException() {
		try {
			utilitarios.NumberException("Valor negativo", -52.3);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

}
