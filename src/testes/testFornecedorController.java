package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.FornecedorController;

/**
* Representação de testes da classe FornecedorController
*/
class testFornecedorController {
	private FornecedorController fornecedorController = new FornecedorController();

	@Test
	void Construct() {
		try {
			fornecedorController.adicionaFornecedor("test", "@test", "73573");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@Test
	void NullConstruct() {
		try {
			fornecedorController.adicionaFornecedor(null, "@test", "73573");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.adicionaFornecedor("test", null, "73573");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.adicionaFornecedor("test", "@test", null);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}
	
	@Test
	void EmptyConstruct() {
		try {
			fornecedorController.adicionaFornecedor(" ", "@test", "73573");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.adicionaFornecedor("test", "", "73573");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.adicionaFornecedor("test", "@test", "   ");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testCadastraProduto() {
		fornecedorController.adicionaFornecedor("test", "@test", "73573");
		try {
			fornecedorController.adicionaProduto("Mouse", "MousePC", 78.99, "test");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@Test
	void testCadastraProdutoNull() {
		fornecedorController.adicionaFornecedor("test", "@test", "73573");
		try {
			fornecedorController.adicionaProduto(null, "MousePC", 78.99, "test");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {
			
		}
		try {
			fornecedorController.adicionaProduto("Mouse", null, 78.99, "test");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.adicionaProduto("Mouse", "MousePC", 78.99, null);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}
	
	@Test
	void testCadastraProdutoEmpty() {
		fornecedorController.adicionaFornecedor("test", "@test", "73573");
		try {
			fornecedorController.adicionaProduto("", "MousePC", 78.99, "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.adicionaProduto("Mouse", "  ", 78.99, "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.adicionaProduto("Mouse", "MousePC", -78.99, "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.adicionaProduto("Mouse", "MousePC", 78.99, " ");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testGetFornecedor() {
		fornecedorController.adicionaFornecedor("test", "@test", "73573");
		assertEquals(fornecedorController.exibeFornecedor("test"), "test - @test - 73573");
	}

	@Test
	void testGetFornecedores() {
		fornecedorController.adicionaFornecedor("test", "@test", "73573");
		fornecedorController.adicionaFornecedor("test1", "@test1", "735731");
		assertEquals(fornecedorController.getFornecedores(), "test - @test - 73573 | test1 - @test1 - 735731\n");
	}

	/**
	@Test
	void testSetFornecedorEmail() {
		fornecedorController.adicionaFornecedor("test", "@test", "73573");
		try {
			fornecedorController.setFornecedorEmail("@testtest", "test");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			fornecedorController.setFornecedorEmail("", "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.setFornecedorEmail(null, "test");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.setFornecedorEmail("@testtt", "naoexisto");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}
	*/
	
	/**
	@Test
	void testSetFornecedorTelefone() {
		fornecedorController.adicionaFornecedor("test", "@test", "73573");
		try {
			fornecedorController.setFornecedorTelefone("8888", "test");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			fornecedorController.setFornecedorTelefone("", "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.setFornecedorTelefone(null, "test");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.setFornecedorTelefone("88888", "naoexisto");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}
	*/
	
	/**
	@Test
	void testSetProdutoValor() {
		fornecedorController.adicionaFornecedor("tests", "@test", "73573");
		fornecedorController.adicionaProduto("Teclado", "TecladoPC", 78.99, "tests");
		try {
			fornecedorController.setProdutoValor(100.00, "Teclado", "TecladoPC", "tests");
		} catch (Exception e){
			fail("Não era esperado exceção");
		}
	}
	*/
	
	@Test
	void testGetProduto() {
		fornecedorController.adicionaFornecedor("tests", "@test", "73573");
		fornecedorController.adicionaProduto("Teclado", "TecladoPC", 78.99, "tests");
		try {
			assertEquals(fornecedorController.exibeProduto("Teclado", "TecladoPC", "tests"), "Teclado - TecladoPC - R$78,99");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}

	@Test
	void testGetProdutos() {
		fornecedorController.adicionaFornecedor("tests", "@test", "73573");
		fornecedorController.adicionaProduto("Teclado", "TecladoPC", 78.99, "tests");
		fornecedorController.adicionaProduto("Mouse", "MousePC", 78.99, "tests");
		try {
			assertEquals(fornecedorController.exibeProdutos("tests"), "tests - Teclado - TecladoPC - R$78,99, tests - Mouse - MousePC - R$78,99");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			fornecedorController.exibeProdutos("naoexiste");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testRemoveFornecedor() {
		fornecedorController.adicionaFornecedor("tests", "@test", "73573");
		try {
			fornecedorController.removeFornecedor("tests");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			fornecedorController.removeFornecedor("naoexiste");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	void testRemoveProduto() {
		fornecedorController.adicionaFornecedor("tests", "@test", "73573");
		fornecedorController.adicionaProduto("Teclado", "TecladoPC", 78.99, "tests");
		try {
			fornecedorController.removeProduto("Teclado", "TecladoPC", "tests");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			fornecedorController.removeProduto("naoexiste", "naoexiste", "tests");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			fornecedorController.removeProduto("Teclado", "TecladoPC", "naoexiste");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

}
