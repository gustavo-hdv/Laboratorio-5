package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.Pessoa;

/**
* Representação de testes da classe Pessoa
*/
class testPessoa {
	
	@SuppressWarnings("unused")
	@Test
	void Construct() {
		try {
			Pessoa testPessoa = new Pessoa("Gustavo", "@ccc");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void NullConstruct() {
		try {
			Pessoa testPessoa = new Pessoa(null, "@ccc");
		} catch (NullPointerException e) {
			fail("Não era esperado exceção");
		}
		try {
			Pessoa testPessoa = new Pessoa("Gustavo", null);
		} catch (NullPointerException e) {
			fail("Não era esperado exceção");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void EmptyConstruct() {
		try {
			Pessoa testPessoa = new Pessoa("", "@ccc");
		} catch (IllegalArgumentException e) {
			fail("Não era esperado exceção");
		}
		try {
			Pessoa testPessoa = new Pessoa("Gustavo", "");
		} catch (IllegalArgumentException e) {
			fail("Não era esperado exceção");

		}
	}

	@Test
	void testSetEmail() {
		Pessoa testPessoa = new Pessoa("Gustavo", "@ccc");
		try {
			testPessoa.setEmail("@hotmail");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			testPessoa.setEmail("");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			testPessoa.setEmail(null);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}

	@Test
	void testToString() {
		Pessoa testPessoa = new Pessoa("Gustavo", "@ccc");
		assertEquals(testPessoa.toString(), "Gustavo");
	}

}
