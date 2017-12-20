package br.faculdadenovaroma.tap.ecommerce.negocio;

import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.*;

public class FabricaRepositorio {
	public IRepositorioClienteJDBC criarIRepositorioClienteJDBC() {
		IRepositorioClienteJDBC repCliente = new RepositorioCliente();
		return repCliente;
	}
	
	public IRepositorioFornecedorJDBC criarIRepositorioFornecedorJDBC() {
		IRepositorioFornecedorJDBC repFornecedor = new RepositorioFornecedor();
		return repFornecedor;
	}
	
	public IRepositorioFuncionarioJDBC criarIRepositorioFuncionarioJDBC() {
		IRepositorioFuncionarioJDBC repFuncionario = new RepositorioFuncionario();
		return repFuncionario;
	}
	
	public IRepositorioProdutoJDBC criarIRepositorioProdutoJDBC() {
		IRepositorioProdutoJDBC repProduto = new RepositorioProduto();
		return repProduto;
	}
	
	public IRepositorioDepartamentoJDBC criarIRepositorioDepartamentoJDBC() {
		IRepositorioDepartamentoJDBC repDepartamento = new RepositorioDepartamento();
		return repDepartamento;
	}
}
