package pacotepadrao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/** Representação do Controlador de Fornecedores*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FornecedorController {
	/** Mapa de Fornecedores por seu nome */
	private HashMap<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
	private String criterio = null;
	
	/** Lista as compras dependendo do critério fornecido */
	public String listarCompras() {

		if (this.criterio == null) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}
		if (!(criterio.equals("Cliente") | criterio.equals("Fornecedor") | criterio.equals("Data"))) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}

		if (this.criterio.equals("Cliente")) {
			String ordenado = "";
			ArrayList<Compra> tempCompras = returnAllComprasFornecedor();
			Collections.sort(tempCompras, new CompararCliente());
			for (int i = 0; i < tempCompras.size(); i++) {
				if (i != 0) ordenado += " | ";
				ordenado += tempCompras.get(i).ordenarCliente();
			}
			return ordenado;
		}
		
		if (this.criterio.equals("Fornecedor")) {
			String ordenado = "";
			ArrayList<Compra> tempCompras = returnAllComprasFornecedor();
			Collections.sort(tempCompras, new CompararFornecedor());
			for (int i = 0; i < tempCompras.size(); i++) {
				if (i != 0) ordenado += " | ";
				ordenado += tempCompras.get(i).ordenarFornecedor();
			}
			return ordenado;
		}
		
		if (this.criterio.equals("Data")) {
			String ordenado = "";
			ArrayList<Compra> tempCompras = returnAllComprasFornecedor();
			Collections.sort(tempCompras, new CompararData());
			for (int i = 0; i < tempCompras.size(); i++) {
				if (i != 0) ordenado += " | ";
				ordenado += tempCompras.get(i).ordenarData();
			}
			return ordenado;
		}
		return null;
	}
	
	/** retorna todas as compras do fornecedor */
	private ArrayList<Compra> returnAllComprasFornecedor() {
		ArrayList<Compra> tempCompras = new ArrayList<Compra>();
		for (Fornecedor fornecedor : fornecedores.values()) {
			tempCompras.addAll(fornecedor.returnAllCompras());
		}
		return tempCompras;
	}
	
	/** Define o critério de ordenação 
	 * 
	 * @param criterio de ordenação (String) 
	 */
	public void ordenaPor(String criterio) {
		Utilitarios.NullException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.", criterio);
		Utilitarios.EmptyException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.", criterio);
		if (!(criterio.equals("Cliente") | criterio.equals("Fornecedor") | criterio.equals("Data"))) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
		this.criterio = criterio;
	}
	
	/** Realiza o pagamento do cliente removendo sua conta
	 * 
	 * @param cpf do cliente (String)
	 * @param nome do fornecedor (String)
	 */
	protected void removeConta(String cpfCliente, String nomeFornecedor) {
		Utilitarios.NullException("Erro ao remover conta: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro ao remover conta: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.NullException("Erro ao remover conta: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro ao remover conta: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		if (cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro ao remover conta: cpf invalido.");
		}
		if (!hasFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao remover conta: fornecedor nao existe.");
		}
		
		if (!hasDebito(cpfCliente, nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao remover conta: nao ha debito do cliente associado a este fornecedor.");
		}
		
		fornecedores.get(nomeFornecedor).removeConta(cpfCliente);
	}
	
	/** edita o desconto do combo
	 * 
	 * @param nome do combo (String)
	 * @param descrição do combo (String)
	 * @param nome do fornecedor (String)
	 * @param desconto do combo (double)
	 */
	public void editaCombo(String nomeCombo, String descricaoCombo, String nomeFornecedor, double novoFator) {
		Utilitarios.NullException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", nomeCombo);
		Utilitarios.EmptyException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", nomeCombo);
		Utilitarios.NullException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", descricaoCombo);
		Utilitarios.EmptyException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", descricaoCombo);
		Utilitarios.NullException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		if (!hasFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}
		if (!hasProduto(nomeCombo, descricaoCombo, nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		
		this.fornecedores.get(nomeFornecedor).editaCombo(nomeCombo, descricaoCombo, novoFator);
	}
	
	/** Adiciona um combo de produto
	 * 
	 * @param nome do fornecedor (String)
	 * @param nome do combo (String)
	 * @param descrição do combo (String)
	 * @param desconto do combo (double)
	 * @param produtos do combo (String)
	 */
	public void adicionaCombo(String nomeFornecedor, String nomeCombo, String descricaoCombo, double fator, String produtosCombo) {
		Utilitarios.NullException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", nomeCombo);
		Utilitarios.EmptyException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", nomeCombo);
		Utilitarios.NullException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", descricaoCombo);
		Utilitarios.EmptyException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", descricaoCombo);
		Utilitarios.NullException("Erro no cadastro de combo: combo deve ter produtos.", produtosCombo);
		Utilitarios.EmptyException("Erro no cadastro de combo: combo deve ter produtos.", produtosCombo);
		if (!hasFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		if (hasProduto(nomeCombo, descricaoCombo, nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
		if (fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		
		double valorProdutosCombo = calculaValorProdutosCombo(nomeFornecedor, produtosCombo);
		this.fornecedores.get(nomeFornecedor).adicionaCombo(nomeCombo, descricaoCombo, fator, valorProdutosCombo);
	}
	
	/** Calcula o valor de todos os produtos do combo
	 * 
	 * @param nome do fornecedor (String)
	 * @param produtos do combo (String)
	 * 
	 * @return valor de todos os produtos do combo (double)
	 */
	private double calculaValorProdutosCombo(String nomeFornecedor, String produtosCombo) {
		double valorTotal = 0.0;
		ArrayList<String> produtos = new ArrayList<>(Arrays.asList(produtosCombo.split(", ")));
		for (String produto : produtos) {
			if (produto.contains("+")) {
				throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			ArrayList<String> nomeDescricao = new ArrayList<>(Arrays.asList(produto.split(" - ")));
			if (!hasProduto(nomeDescricao.get(0), nomeDescricao.get(1), nomeFornecedor)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
			valorTotal += getValorProduto(nomeFornecedor, nomeDescricao.get(0), nomeDescricao.get(1));
		}
		return valorTotal;
	}
	
	/** retorna o valor de um produto
	 * 
	 * @param nome do fornecedor (String)
	 * @param nome do produto (String)
	 * @param descrição do produto (String)
	 */
	private double getValorProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		return fornecedores.get(nomeFornecedor).getValorProduto(nomeProduto, descricaoProduto);
	}
	
	/** Exibe a conta de um cliente para todos os fornecedores
	 *  Estilo: "Cliente: nomeCliente | nomeFornecedor | produto - data | nomeFornecedor | produto - data | ...
	 *  
	 *  @param cpf do cliente (String)
	 *  @param cliente controller para verificações do cliente
	 *  
	 *  @return ""Cliente: nomeCliente | nomeFornecedor | produto - data | nomeFornecedor | produto - data | ..." (String)
	 */
	public String exibeContasClientes(String cpfCliente, ClienteController clienteController) {
		Utilitarios.NullException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.", cpfCliente);
		if (cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		if (!clienteController.hasCliente(cpfCliente)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		
		String contasCliente = "Cliente: " + clienteController.getClienteNome(cpfCliente) + " | ";
		
		//Preenche lista de fornecedores
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>();
		for (Map.Entry<String, Fornecedor> fornecedor : this.fornecedores.entrySet()) {
			fornecedoresOrdenados.add(fornecedor.getValue());
		}
		
		//Ordena lista de fornecedores
		fornecedoresOrdenados.sort(Comparator.comparing(Fornecedor::toString));
		
		//Quantidade de débitos
		int contador = 0;
		for (Fornecedor fornecedor : fornecedoresOrdenados) {
			if (fornecedor.hasDebito(cpfCliente)) {
				contador += 1;
			}
		}
		
		//Preenche contasCliente
		for (Fornecedor fornecedor : fornecedoresOrdenados) {
			if (fornecedor.hasDebito(cpfCliente)) {
				if (contador != 1) {
					contasCliente += fornecedor.exibeContas(cpfCliente, fornecedor.getNome(), clienteController) + " | ";
				} else {
					contasCliente += fornecedor.exibeContas(cpfCliente, fornecedor.getNome(), clienteController);
				}
				contador--;
			}
		}
		if (contasCliente.equals("Cliente: " + clienteController.getClienteNome(cpfCliente) + " | ")) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		
		return contasCliente;
	}
	
	/** Exibe um conta de um cliente para determinado fornecedor
	 *  Estilo: "Cliente: nomeCliente | nomeFornecedor | produto - data | ...
	 *  
	 *  @param cpf do cliente (String)
	 *  @param nome do fornecedor (String)
	 *  @param cliente controller para verificações do cliente
	 *  
	 *  @return "Cliente: nomeCliente | nomeFornecedor | produto - data | ..." (String)
	 */
	public String exibeContas(String cpfCliente, String nomeFornecedor, ClienteController clienteController) {
		Utilitarios.NullException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.NullException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		if (cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
		if (!clienteController.hasCliente(cpfCliente)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		if (!hasFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
		return "Cliente: " + clienteController.getClienteNome(cpfCliente) + " | " + fornecedores.get(nomeFornecedor).exibeContas(cpfCliente, nomeFornecedor, clienteController);
	}
	
	/** Retorna o débito de um cliente para determinado fornecedor
	 * 
	 * @param cpf do cliente (String)
	 * @param nome do fornecedor (String)
	 * @param cliente controller para lista de clientes
	 * 
	 * @return débito do cliente formatado em 2 casas decimais
	 */
	public String getDebito(String cpfCliente, String nomeFornecedor, ClienteController clienteController) {
		Utilitarios.NullException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.", cpfCliente);
		if (cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		Utilitarios.NullException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (!hasFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		
		if (!clienteController.hasCliente(cpfCliente)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		} 
		
		if (!hasDebito(cpfCliente, nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
		
		return fornecedores.get(nomeFornecedor).getDebito(cpfCliente);
	}
	
	/** Adiciona a compra de um cliente no mapa de contas de um fornecedor
	 *  Observação: Cria uma conta com o débito do cliente e informações dos produtos comprados se ainda não existir
	 * 
	 * @param cpf do cliente (String) (tamanho 11)
	 * @param nome do fornecedor (String)
	 * @param data da compra (String) (tamanho 10)
	 * @param nome do produto (String)
	 * @param descricao do produto (String)
	 * @param clienteController (ClienteController)
	 */
	public void adicionaCompra(String cpfCliente, String nomeFornecedor, String dataCompra, String nomeProduto, String descricaoProduto, ClienteController clienteController) {
		Utilitarios.NullException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.EmptyException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.", cpfCliente);
		Utilitarios.NullException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", dataCompra);
		Utilitarios.EmptyException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", dataCompra);
		if (cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		if (dataCompra.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		Utilitarios.NullException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", descricaoProduto);
		
		if (!clienteController.hasCliente(cpfCliente)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
		
		if (!hasFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		} 
		
		fornecedores.get(nomeFornecedor).adicionaCompra(cpfCliente, dataCompra, nomeProduto, descricaoProduto, clienteController);

	}
	
	/** Cadastro de um Fornecedor
	 * 
	 * @param Nome do Fornecedor (String)
	 * @param Email do Fornecedor (String)
	 * @param Telefone do Fornecedor (String)
	 *
	 * @return Nome do Fornecedor (String)
	 */
	public String adicionaFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
		Utilitarios.NullException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", emailFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", emailFornecedor);
		Utilitarios.NullException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", telefoneFornecedor);
		Utilitarios.EmptyException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", telefoneFornecedor);
		
		if (!hasFornecedor(nomeFornecedor)) {
			this.fornecedores.put(nomeFornecedor, new Fornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor));
			return nomeFornecedor;
		} throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
	}
	
	/** Cadastro de um produto
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Valor do Produto (double)
	 * @param Nome do Fornecedor (String)
	 */
	public void adicionaProduto(String nomeProduto, String descricaoProduto, double valorProduto, String nomeFornecedor) {
		Utilitarios.NullException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.NumberException("Erro no cadastro de produto: preco invalido.", valorProduto);
		
		if (hasFornecedor(nomeFornecedor)) {
			if (!hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, valorProduto);
				return;
			} throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		} throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
	}
	
	/** Representação do Fornecedor
	 *  Estilo: nome - email - telefone
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - email - telefone (String)
	 */
	public String exibeFornecedor(String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}
	
	/** Representação de todos os Fornecedores
	 *  Estilo: nome - email - telefone | nome - email - telefone | ...
	 *  
	 *  @return nome - email - telefone | ...
	 */
	public String getFornecedores() {
		String toStringFornecedores = "";
		
		//Preenche lista com fornecedores
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>();
		for (Map.Entry<String, Fornecedor> fornecedor : fornecedores.entrySet()) {
			fornecedoresOrdenados.add(fornecedor.getValue());
		}
		
		//Ordena lista de fornecedores
		fornecedoresOrdenados.sort(Comparator.comparing(Fornecedor::toString));
		
		//Preenche toStringFornecedores
		for (int i = 0; i < fornecedoresOrdenados.size(); i++) {
			if (i != 0) toStringFornecedores += " | ";
			toStringFornecedores += fornecedoresOrdenados.get(i).toString();
		}

		return toStringFornecedores;
	}
	
	/** Edita um fornecedor recebendo o nome, atributo e novo valor
	 * 
	 * @param nome do fornecedor (String)
	 * @param atributo a ser editado (String)
	 * @param novo valor para o atributo (String)
	 */
	public void editaFornecedor(String nomeFornecedor, String atributo, String novoValor) {
		Utilitarios.NullException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", atributo);
		Utilitarios.EmptyException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", atributo);
		Utilitarios.NullException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		else if (atributo.equals("email")) {
			setFornecedorEmail(novoValor, nomeFornecedor);
		}
		else if (atributo.equals("telefone")) {
			setFornecedorTelefone(novoValor, nomeFornecedor);
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	
	/** Edita o valor de um produto
	 * 
	 * @param nome do produto (String)
	 * @param descrição do produto (String)
	 * @param nome do fornecedor (String)
	 * @param novo valor do produto (double)
	 */
	public void editaProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor, double novoValor) {
		Utilitarios.NullException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.NumberException("Erro na edicao de produto: preco invalido.", novoValor);
		
		setProdutoValor(novoValor, nomeProduto, descricaoProduto, nomeFornecedor);
		
	}
	
	/** Determina o valor do Produto
	 * 
	 * @param Valor do Produto (double)
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	private void setProdutoValor(double valorProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NumberException("Erro na edicao de produto: preco invalido.", valorProduto);
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).setProdutoValor(valorProduto, nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		} throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
	}
	
	/** Determina o Email de um Fornecedor
	 * 
	 * @param Email do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	private void setFornecedorEmail(String emailFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", emailFornecedor);
			Utilitarios.EmptyException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", emailFornecedor);
			this.fornecedores.get(nomeFornecedor).setEmail(emailFornecedor);
			return;
		}
		throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
	}
	
	/** Determina o Telefone de um Fornecedor
	 * 
	 * @param Telefone do Fornecedor (String)
	 * @param Nome do Fornecedor (String)
	 */
	private void setFornecedorTelefone(String telefoneFornecedor, String nomeFornecedor) {
		if (hasFornecedor(nomeFornecedor)) {
			Utilitarios.NullException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", telefoneFornecedor);
			Utilitarios.EmptyException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", telefoneFornecedor);
			this.fornecedores.get(nomeFornecedor).setTelefone(telefoneFornecedor);
			return;
		}
		throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
	}
	
	
	/** Representação de um Produto
	 *  Estilo: nome - descrição - valor
	 * 
	 *  @param Nome do Produto (String)
	 *  @param Descrição do Produto (String)
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return nome - descrição - valor(2df) (String)
	 */
	public String exibeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		Utilitarios.NullException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.NullException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				return this.fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricaoProduto);
			} throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		} throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}
	
	/** Representação de todos os Produtos de um Fornecedor
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @param Nome do Fornecedor (String)
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String exibeProdutos(String nomeFornecedor) {
		Utilitarios.NullException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (hasFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).exibeProdutos();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}
	
	/** Representação de todos os Produtos dos Fornecedores
	 *  Estilo: nomeFornecedor - nomeProduto - descrição - valor | ...
	 *  
	 *  @return NomeFornecedor - nomeProduto - descrição - valor | ... (String)
	 */
	public String exibeProdutos() {
		String toStringProdutos = "";
		
		//Preenche lista de fornecedores
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>();
		for (Map.Entry<String, Fornecedor> fornecedor : fornecedores.entrySet()) {
			fornecedoresOrdenados.add(fornecedor.getValue());
		}
		
		//Ordena lista de fornecedores
		fornecedoresOrdenados.sort(Comparator.comparing(Fornecedor::toString).thenComparing(Fornecedor::exibeProdutos));
		
		//Preenche toStringProdutos
		int contador = fornecedoresOrdenados.size();
		for (Fornecedor fornecedor : fornecedoresOrdenados) {
			if (contador != 1) {
				toStringProdutos += fornecedor.exibeProdutos() + " | ";
			} else {
				toStringProdutos += fornecedor.exibeProdutos();
			}
			contador--;
		}
		return toStringProdutos;
	}
	
	/** Remove um Fornecedor cadastrado
	 * 
	 * @param Nome do Fornecedor (String)
	 */
	public void removeFornecedor(String nomeFornecedor) {
		Utilitarios.NullException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (hasFornecedor(nomeFornecedor)) {
			this.fornecedores.remove(nomeFornecedor);
			return;
		} throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
	}
	
	/** Remove um Produto de um Fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	public void removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		Utilitarios.NullException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.NullException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.NullException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		Utilitarios.EmptyException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		Utilitarios.EmptyException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", descricaoProduto);
		Utilitarios.EmptyException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		
		if (hasFornecedor(nomeFornecedor)) {
			if (hasProduto(nomeProduto, descricaoProduto, nomeFornecedor)) {
				this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricaoProduto);
				return;
			} throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		} throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
	}
	
	/** Verifica se existe determinado fornecedor cadastrado
	 * 
	 * @param Nome do Fornecedor (String)
	 */
	protected boolean hasFornecedor(String nomeFornecedor) {
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			return true;
		} return false;
	}
	
	/** Verifica se existe um produto cadastrado em um fornecedor
	 * 
	 * @param Nome do Produto (String)
	 * @param Descrição do Produto (String)
	 * @param Nome do Fornecedor (String)
	 */
	private boolean hasProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if (this.fornecedores.get(nomeFornecedor).hasProduto(nomeProduto, descricaoProduto)) {
			return true;
		} return false;
	}
	
	/** Verifica se um cliente tem débito em um fornecedor
	 * 
	 * @param cpf do cliente (String)
	 * @param nome do fornecedor (String)
	 */
	protected boolean hasDebito(String cpfCliente, String nomeFornecedor) {
		if (fornecedores.get(nomeFornecedor).hasDebito(cpfCliente)) {
			return true;
		} return false;
	}
}
