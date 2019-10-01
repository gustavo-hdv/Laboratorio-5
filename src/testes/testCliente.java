package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.Cliente;

/**
* Representação de testes da classe Cliente
*/
class testCliente {
	private Cliente cliente1 = new Cliente("Gustavo", "@ccc", "Campina Grande", "9999999-999");
	private Cliente cliente2 = new Cliente("Ovatsug", "@hotmail", "Campina Grande", "1111111-111");
	private Cliente cliente3 = new Cliente("TwoSouls", "@gmail", "Campina Grande", "9999999-999");
	private Cliente cliente4 = new Cliente("Gustavo", "@hotmail", "Campina Grande", "11111111111");
	
	@Test
	@SuppressWarnings("unused")
	void Construct() {
		try {
			Cliente testCliente = new Cliente("Teste", "@test", "testCity", "9999999-999");
		} catch (Exception e) {
			fail("Não era esperado uma exceção");
		}
	}
	
	@Test
	@SuppressWarnings("unused")
	void NullConstruct() {
		try {
			Cliente testCliente = new Cliente(null, "@test", "testCity", "9999999-999");
			fail("Era esperado exceção ao passar nome nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			Cliente testCliente = new Cliente("Teste", null, "testCity", "9999999-999");
			fail("Era esperado exceção ao passar email nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			Cliente testCliente = new Cliente("Teste", "@test", null, "9999999-999");
			fail("Era esperado exceção ao passar localização nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			Cliente testCliente = new Cliente("Teste", "@test", "testCity", null);
			fail("Era esperado exceção ao passar cpf nulo.");
		} catch (NullPointerException e) {
			
		}
	}
	
	@SuppressWarnings("unused")
	void EmptyConstruct() {
		try {
			Cliente testCliente = new Cliente(" ", "@test", "testCity", "9999999-999");
			fail("Era esperado exceção ao passar nome vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			Cliente testCliente = new Cliente("Teste", " ", "testCity", "9999999-999");
			fail("Era esperado exceção ao passar email vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			Cliente testCliente = new Cliente("Teste", "@test", "", "9999999-999");
			fail("Era esperado exceção ao passar localização vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			Cliente testCliente = new Cliente("Teste", "@test", "testCity", "");
			fail("Era esperado exceção ao passar cpf vazio.");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testHashCode() {
		assertEquals(cliente1.hashCode(), cliente3.hashCode());
	}

	@Test
	void testToString() {
		assertEquals(cliente2.toString(), "Ovatsug - Campina Grande - @hotmail");
	}
	
	@Test
	void testSetLocalizacao() {
		try {
			cliente1.setLocalizacao("LCC3");
		} catch (Exception e) {
			fail("Não era esperado uma exceção");
		}
		try {
			cliente1.setLocalizacao("");
			fail("Uma exceção era esperada.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			cliente1.setLocalizacao(null);
			fail("Uma exceção era esperada.");
		} catch (NullPointerException e) {
			
		}
	}

	@Test
	void testSetNome() {
		try {
			cliente1.setNome("Tristana");
		} catch (Exception e) {
			fail("Não era esperado uma exceção");
		}
		try {
			cliente1.setNome("");
			fail("Uma exceção era esperada.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			cliente1.setNome(null);
			fail("Uma exceção era esperada.");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	void testSetEmail() {
		try {
			cliente1.setEmail("@google");
		} catch (Exception e) {
			fail("Não era esperado uma exceção");
		}
		try {
			cliente1.setEmail("");
			fail("Uma exceção era esperada.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			cliente1.setEmail(null);
			fail("Uma exceção era esperada.");
		} catch (NullPointerException e) {
			
		}
	}

	@Test
	void testEqualsObject() {
		assertEquals(cliente1, cliente3);
		assertNotEquals(cliente1, cliente4);
	}

}
