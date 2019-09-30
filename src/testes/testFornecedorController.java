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
			fornecedorController.cadastraFornecedor("test", "@test", "73573");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@Test
	void NullConstruct() {
		try {
			fornecedorController.cadastraFornecedor(null, "@test", "73573");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.cadastraFornecedor("test", null, "73573");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.cadastraFornecedor("test", "@test", null);
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
	}
	
	@Test
	void EmptyConstruct() {
		try {
			fornecedorController.cadastraFornecedor(" ", "@test", "73573");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.cadastraFornecedor("test", "", "73573");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.cadastraFornecedor("test", "@test", "   ");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testCadastraProduto() {
		fornecedorController.cadastraFornecedor("test", "@test", "73573");
		try {
			fornecedorController.cadastraProduto("Mouse", "MousePC", 78.99, "test");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}
	
	@Test
	void testCadastraProdutoNull() {
		fornecedorController.cadastraFornecedor("test", "@test", "73573");
		try {
			fornecedorController.cadastraProduto(null, "MousePC", 78.99, "test");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {
			
		}
		try {
			fornecedorController.cadastraProduto("Mouse", null, 78.99, "test");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			fornecedorController.cadastraProduto("Mouse", "MousePC", 78.99, null);
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}
	
	@Test
	void testCadastraProdutoEmpty() {
		fornecedorController.cadastraFornecedor("test", "@test", "73573");
		try {
			fornecedorController.cadastraProduto("", "MousePC", 78.99, "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.cadastraProduto("Mouse", "  ", 78.99, "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.cadastraProduto("Mouse", "MousePC", -78.99, "test");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			fornecedorController.cadastraProduto("Mouse", "MousePC", 78.99, " ");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testGetFornecedor() {
		fornecedorController.cadastraFornecedor("test", "@test", "73573");
		assertEquals(fornecedorController.getFornecedor("test"), "test - @test - 73573");
	}

	@Test
	void testGetFornecedores() {
		fornecedorController.cadastraFornecedor("test", "@test", "73573");
		fornecedorController.cadastraFornecedor("test1", "@test1", "735731");
		assertEquals(fornecedorController.getFornecedores(), "test - @test - 73573 | test1 - @test1 - 735731\n");
	}

	@Test
	void testSetFornecedorEmail() {
		fornecedorController.cadastraFornecedor("test", "@test", "73573");
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

	@Test
	void testSetFornecedorTelefone() {
		fornecedorController.cadastraFornecedor("test", "@test", "73573");
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


	@Test
	void testSetProdutoValor() {
		fornecedorController.cadastraFornecedor("tests", "@test", "73573");
		fornecedorController.cadastraProduto("Teclado", "TecladoPC", 78.99, "tests");
		try {
			fornecedorController.setProdutoValor(100.00, "Teclado", "TecladoPC", "tests");
		} catch (Exception e){
			fail("Não era esperado exceção");
		}
	}

	@Test
	void testGetProduto() {
		fornecedorController.cadastraFornecedor("tests", "@test", "73573");
		fornecedorController.cadastraProduto("Teclado", "TecladoPC", 78.99, "tests");
		try {
			assertEquals(fornecedorController.getProduto("Teclado", "TecladoPC", "tests"), "Teclado - TecladoPC - R$78,99\n");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
	}

	@Test
	void testGetProdutos() {
		fornecedorController.cadastraFornecedor("tests", "@test", "73573");
		fornecedorController.cadastraProduto("Teclado", "TecladoPC", 78.99, "tests");
		fornecedorController.cadastraProduto("Mouse", "MousePC", 78.99, "tests");
		try {
			assertEquals(fornecedorController.getProdutos("tests"), "tests - Teclado - TecladoPC - R$78,99 | tests - Mouse - MousePC - R$78,99\n");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			fornecedorController.getProdutos("naoexiste");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void testRemoveFornecedor() {
		fornecedorController.cadastraFornecedor("tests", "@test", "73573");
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
		fornecedorController.cadastraFornecedor("tests", "@test", "73573");
		fornecedorController.cadastraProduto("Teclado", "TecladoPC", 78.99, "tests");
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
