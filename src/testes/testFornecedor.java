package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.Fornecedor;

/**
* Representação de testes da classe Fornecedor
*/
class testFornecedor {
	private Fornecedor fornecedor1 = new Fornecedor("Gustavo", "@ccc", "8812345");
	private Fornecedor fornecedor2 = new Fornecedor("Ovatsug", "@ccc", "8712344");
	private Fornecedor fornecedor3 = new Fornecedor("Gustavo", "@hotmail", "8354321");
	
	
	@Test
	void testHashCode() {
		assertEquals(fornecedor1.hashCode(), fornecedor3.hashCode());
	}

	@Test
	void testToString() {
		assertEquals(fornecedor2.toString(), "Ovatsug - @ccc - 8712344");
	}

	@SuppressWarnings("unused")
	@Test
	void Construct() {
		try {
			Fornecedor fornecedorTest = new Fornecedor("test", "@test", "73573");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void NullConstruct() {
		try {
			Fornecedor fornecedorTest = new Fornecedor(null, "@test", "73573");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			Fornecedor fornecedorTest = new Fornecedor("test", null, "73573");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			Fornecedor fornecedorTest = new Fornecedor("test", "@test", null);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void EmptyConstruct() {
		try {
			Fornecedor fornecedorTest = new Fornecedor(" ", "@test", "73573");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			Fornecedor fornecedorTest = new Fornecedor("test", "", "73573");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			Fornecedor fornecedorTest = new Fornecedor("test", "@test", "   ");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testSetTelefone() {
		try {
			fornecedor1.setTelefone("11111");
		} catch (Exception e){
			fail("Não era esperado exceção");
		}
		try {
			fornecedor1.setTelefone("");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e){

		}
		try {
			fornecedor1.setTelefone(null);
			fail("Era esperado exceção");
		} catch (NullPointerException e){

		}
	}

	@Test
	void testSetEmail() {
		try {
			fornecedor1.setEmail("@hacked");
		} catch (Exception e){
			fail("Não era esperado exceção");
		}
		try {
			fornecedor1.setEmail("");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e){

		}
		try {
			fornecedor1.setEmail(null);
			fail("Era esperado exceção");
		} catch (NullPointerException e){

		}
	}
	
	@Test
	void testCadastraProduto() {
		try {
			fornecedor1.cadastraProduto("Mouse", "MousePC", 78.99);
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@Test
	void testCadastraProdutoNull() {
		try {
			fornecedor1.cadastraProduto(null, "MousePC", 78.99);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {
		}
		try {
			fornecedor1.cadastraProduto("Mouse", null, 78.99);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}
	
	@Test
	void testCadastraProdutoEmpty() {
		try {
			fornecedor1.cadastraProduto("", "MousePC", 78.99);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedor1.cadastraProduto("Mouse", "  ", 78.99);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedor1.cadastraProduto("Mouse", "MousePC", -78.99);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testSetProdutoValor() {
		fornecedor1.cadastraProduto("Mouse", "MousePC", 78.99);
		try {
			fornecedor1.setProdutoValor(100.99, "Mouse", "MousePC");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			fornecedor1.setProdutoValor(-99.98, "Mouse", "MousePC");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testGetProduto() {
		fornecedor1.cadastraProduto("Mouse", "MousePC", 78.99);
		assertEquals(fornecedor1.getProduto("Mouse", "MousePC"), "Mouse - MousePC - R$78,99");
	}

	@Test
	void testGetProdutos() {
		fornecedor1.cadastraProduto("Mouse", "MousePC", 78.99);
		fornecedor1.cadastraProduto("Teclado", "tecladoPC", 199.99);
		assertEquals(fornecedor1.getProdutos(), "Gustavo - Mouse - MousePC - R$78,99 | Gustavo - Teclado - tecladoPC - R$199,99\n");
	}

	@Test
	void testRemoveProduto() {
		fornecedor1.cadastraProduto("Mouse", "MousePC", 78.99);
		try {
			fornecedor1.removeProduto("Mouse", "MousePC");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}

	@Test
	void testHasProduto() {
		fornecedor1.cadastraProduto("Mouse", "MousePC", 78.99);
		assertEquals(fornecedor1.hasProduto("Mouse", "MousePC"), true);
	}

	@Test
	void testEqualsObject() {
		assertEquals(fornecedor1, fornecedor3);
	}

}
