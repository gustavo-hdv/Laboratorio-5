package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.ProdutoSimples;

/**
* Representação de testes da classe Produto
*/
class testProduto {
	private ProdutoSimples produto1 = new ProdutoSimples("Mouse", "MousePC", 39.99);
	private ProdutoSimples produto2 = new ProdutoSimples("Mouse", "MousePC", 79.89);
	private ProdutoSimples produto3 = new ProdutoSimples("Teclado", "TecladoPC", 39.99);
	
	
	@Test
	void testHashCode() {
		assertEquals(produto1.hashCode(), produto2.hashCode());
	}

	@SuppressWarnings("unused")
	@Test
	void Constructor() {
		try {
			ProdutoSimples testProduto = new ProdutoSimples("test", "test", 999);
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void NullConstructor() {
		try {
			ProdutoSimples testProduto = new ProdutoSimples(null, "test", 999);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			ProdutoSimples testProduto = new ProdutoSimples("test", null, 999);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}
	
	@SuppressWarnings("unused")
	@Test
	void EmptyConstructor() {
		try {
			ProdutoSimples testProduto = new ProdutoSimples("", "test", 999);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			ProdutoSimples testProduto = new ProdutoSimples("test", "", 999);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			ProdutoSimples testProduto = new ProdutoSimples("test", "test", -999);
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
