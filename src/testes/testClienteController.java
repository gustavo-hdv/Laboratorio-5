package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.ClienteController;

/**
* Representação de testes da classe ClienteController
*/
class testClienteController {
	private ClienteController clienteController = new ClienteController();
	
	@Test
	void Construct() {
		try {
			clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	void NullConstruct() {
		try {
			clienteController.adicionaCliente(null, "@test", "testCity", "12345678999");
			fail("Era esperado exceção ao passar nome nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			clienteController.adicionaCliente("Teste", null, "testCity", "12345678999");
			fail("Era esperado exceção ao passar email nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			clienteController.adicionaCliente("Teste", "@test", null, "12345678999");
			fail("Era esperado exceção ao passar localização nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			clienteController.adicionaCliente("Teste", "@test", "testCity", null);
			fail("Era esperado exceção ao passar cpf nulo.");
		} catch (NullPointerException e) {
			
		}
	}
	
	void EmptyConstruct() {
		try {
			clienteController.adicionaCliente(" ", "@test", "testCity", "12345678999");
			fail("Era esperado exceção ao passar nome vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			clienteController.adicionaCliente("Teste", " ", "testCity", "12345678999");
			fail("Era esperado exceção ao passar email vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			clienteController.adicionaCliente("Teste", "@test", "", "12345678999");
			fail("Era esperado exceção ao passar localização vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			clienteController.adicionaCliente("Teste", "@test", "testCity", "");
			fail("Era esperado exceção ao passar cpf vazio.");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testGetCliente() {
		try {
			clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
			assertEquals(clienteController.exibeCliente("12345678999"), "Gustavo - CG - @ccc");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.adicionaCliente("", "@ccc", "CG", "12345678999");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}

	}

	/**
	@Test
	void testGetClientes() {
		clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
		clienteController.adicionaCliente("Gustavo", "@hotmail", "CG", "12345678888");
		assertEquals(clienteController.getClientes(), "Gustavo - CG - @hotmail | Gustavo - CG - @ccc\n");
	}

	@Test
	void testSetClienteLocalizacao() {
		clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
		try {
			clienteController.setClienteLocalizacao("Campina Grande", "12345678999");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.setClienteLocalizacao("", "12345678999");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			clienteController.setClienteLocalizacao(null, "12345678999");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			clienteController.setClienteLocalizacao("@gmail", "11111111111");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}
	*/

	/**
	@Test
	void testSetClienteNome() {
		clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
		try {
			clienteController.setClienteNome("Ovatsug", "12345678999");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.setClienteNome("", "12345678999");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			clienteController.setClienteNome(null, "12345678999");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			clienteController.setClienteNome("@gmail", "11111111111");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}
	*/
	
	/**
	@Test
	void testSetClienteEmail() {
		clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
		try {
			clienteController.setClienteEmail("@hotmaill", "12345678999");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.setClienteEmail("", "12345678999");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			clienteController.setClienteEmail(null, "12345678999");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			clienteController.setClienteEmail("@gmail", "11111111111");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}
	*/

	@Test
	void testRemoveCliente() {
		clienteController.adicionaCliente("Gustavo", "@ccc", "CG", "12345678999");
		try {
			clienteController.removeCliente("12345678999");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.removeCliente("11111111111");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
		
		}
	}
}
