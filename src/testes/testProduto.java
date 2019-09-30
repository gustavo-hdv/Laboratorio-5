package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.Produto;

/**
* Representação de testes da classe Produto
*/
class testProduto {
	private Produto produto1 = new Produto("Mouse", "MousePC", 39.99);
	private Produto produto2 = new Produto("Mouse", "MousePC", 79.89);
	private Produto produto3 = new Produto("Teclado", "TecladoPC", 39.99);
	
	
	@Test
	void testHashCode() {
		assertEquals(produto1.hashCode(), produto2.hashCode());
	}

	@SuppressWarnings("unused")
	@Test
	void Constructor() {
		try {
			Produto testProduto = new Produto("test", "test", 999);
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void NullConstructor() {
		try {
			Produto testProduto = new Produto(null, "test", 999);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			Produto testProduto = new Produto("test", null, 999);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void EmptyConstructor() {
		try {
			Produto testProduto = new Produto("", "test", 999);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			Produto testProduto = new Produto("test", "", 999);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			Produto testProduto = new Produto("test", "test", -999);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testSetValor() {
		try {
			produto2.setValor(45.87);
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			produto2.setValor(-7.8);
			fail("Era esperado exceção");
		} catch (Exception e) {
			
		}
	}

	@Test
	void testToString() {
		assertEquals(produto1.toString(), "Mouse - MousePC - R$39,99");
	}

	@Test
	void testEqualsObject() {
		assertEquals(produto1, produto2);
		assertNotEquals(produto1, produto3);
	}

}
