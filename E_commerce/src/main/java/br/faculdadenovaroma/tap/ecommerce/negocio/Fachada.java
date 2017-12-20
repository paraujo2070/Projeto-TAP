package br.faculdadenovaroma.tap.ecommerce.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;
import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;
import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.excecao.EncontradoException;
import br.faculdadenovaroma.tap.ecommerce.excecao.NaoEncontradoException;
import br.faculdadenovaroma.tap.ecommerce.excecao.UsuarioOuSenhaInvalido;
import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.*;

public class Fachada {
	private static Fachada instancia;
	private FabricaRepositorio fabrica;
	
	private CadastroCliente cadCliente;
	private CadastroFornecedor cadFornecedor;
	private CadastroFuncionario cadFuncionario;
	private CadastroProduto cadProduto;
	private CadastroDepartamento cadDepartamento;
	
	private Fachada() {
		this.initCadastro();
	}
	
	public static Fachada getInstancia() {
		if (instancia == null)
			instancia = new Fachada();
		
		return instancia;
	}
	
	private void initCadastro() {
		this.fabrica = new FabricaRepositorio();
		
		IRepositorioClienteJDBC repCliente = (IRepositorioClienteJDBC) this.fabrica.criarIRepositorioClienteJDBC();
		IRepositorioFornecedorJDBC repFornecedor = (IRepositorioFornecedorJDBC) this.fabrica.criarIRepositorioFornecedorJDBC();
		IRepositorioFuncionarioJDBC repFuncionario = (IRepositorioFuncionarioJDBC) this.fabrica.criarIRepositorioFuncionarioJDBC();
		IRepositorioProdutoJDBC repProduto = (IRepositorioProdutoJDBC) this.fabrica.criarIRepositorioProdutoJDBC();
		IRepositorioDepartamentoJDBC repDepartamento = (IRepositorioDepartamentoJDBC) this.fabrica.criarIRepositorioDepartamentoJDBC();
		
		this.cadCliente = new CadastroCliente(repCliente);
		this.cadFornecedor = new CadastroFornecedor(repFornecedor);
		this.cadFuncionario = new CadastroFuncionario(repFuncionario);
		this.cadProduto = new CadastroProduto(repProduto);
		this.cadDepartamento = new CadastroDepartamento(repDepartamento);
	}
	
	public void inserirCliente(Cliente novoCliente) throws SQLException, EncontradoException, ClassNotFoundException {
		this.cadCliente.inserir(novoCliente);
	}
	
	public Cliente consultarCliente(String cpf) throws SQLException, NaoEncontradoException, ClassNotFoundException {
		return this.cadCliente.consultar(cpf);
	}
	
	public ArrayList<Cliente> listarCliente() throws SQLException, ClassNotFoundException {
		return this.cadCliente.listar();
	}
	
	public void alterarCliente(Cliente cliente, String cpf) throws SQLException, NaoEncontradoException, ClassNotFoundException {
		this.cadCliente.alterar(cliente, cpf);
	}
	
	public void excluirCliente(String cpf) throws SQLException, NaoEncontradoException, ClassNotFoundException {
		this.cadCliente.excluir(cpf);
	}
	
	public Cliente logarCliente(String cpf, String password) throws SQLException, UsuarioOuSenhaInvalido, ClassNotFoundException {
		return this.cadCliente.logar(cpf, password);
	}
	
	public void inserirFornecedor(Fornecedor novoFornecedor) throws SQLException, ClassNotFoundException {
		this.cadFornecedor.inserir(novoFornecedor);
	}
	
	public Fornecedor consultarFornecedor(String cnpj) throws SQLException, ClassNotFoundException {
		return this.cadFornecedor.consultar(cnpj);
	}
	
	public ArrayList<Fornecedor> listarFornecedor() throws SQLException, ClassNotFoundException {
		return this.cadFornecedor.listar();
	}
	
	public void alterarFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
		this.cadFornecedor.alterar(fornecedor);
	}
	
	public void excluirFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
		this.cadFornecedor.excluir(fornecedor);
	}
	
	public void inserirFuncionario(Funcionario novoFuncionario) throws SQLException,ClassNotFoundException {
		this.cadFuncionario.inserir(novoFuncionario);
	}
	
	public Funcionario consultarFuncionario(String cpf) throws SQLException, ClassNotFoundException {
		return this.cadFuncionario.consultar(cpf);
	}
	
	public ArrayList<Funcionario> listarFuncionario() throws SQLException, ClassNotFoundException {
		return this.cadFuncionario.listar();
	}
	
	public void alterarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		this.cadFuncionario.alterar(funcionario);
	}
	
	public void excluirFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		this.cadFuncionario.excluir(funcionario);
	}
	
	public Funcionario logarFuncionario(String cpf, String password) throws SQLException, ClassNotFoundException {
		return this.cadFuncionario.logar(cpf, password);
	}
	
	public void inserirProduto(Produto novoProduto) throws SQLException, ClassNotFoundException {
		this.cadProduto.inserir(novoProduto);
	}
	
	public Produto consultarProduto(Produto produto) throws SQLException, ClassNotFoundException {
		return this.cadProduto.consultar(produto.getNome(), produto.getCodigo());
	}
	
	public ArrayList<Produto> listarProduto() throws SQLException, ClassNotFoundException {
		return this.cadProduto.listar();
	}
	
	public void alterarProduto(Produto produto, int codigo) throws SQLException, ClassNotFoundException {
		this.cadProduto.alterar(produto, codigo);
	}
	
	public void excluirProduto(Produto produto) throws SQLException, ClassNotFoundException {
		this.cadProduto.excluir(produto);
	}
	
	public void inserirDepartamento(Departamento novoDepartamento) throws SQLException, ClassNotFoundException {
		this.cadDepartamento.inserir(novoDepartamento);
	}
	
	public Departamento consultarDepartamento(String nome) throws SQLException, ClassNotFoundException {
		return this.cadDepartamento.consultar(nome);
	}
	
	public ArrayList<Departamento> listarDepartamento() throws SQLException, ClassNotFoundException {
		return this.cadDepartamento.listar();
	}
	
	public void alterarDepartamento(Departamento departamento) throws SQLException, ClassNotFoundException {
		this.cadDepartamento.alterar(departamento);
	}
	
	public void excluirDepartamento(Departamento departamento) throws SQLException, ClassNotFoundException {
		this.cadDepartamento.excluir(departamento);
	}
}
/*
public void inserirUsuario(String userName, String senha, String nome, String telefone, String email, int isAdministrador)
throws CamposEmBrancoException, EncontradoException, TamanhoDaSenhaException, Exception {
if(userName.isEmpty() || senha.isEmpty() || nome.isEmpty() || telefone.isEmpty() || email.isEmpty())
throw new CamposEmBrancoException("Campos em branco");
else if (tamanhoSenha(senha) <= 6) {
throw new TamanhoDaSenhaException("O tamanho da senha deve ser maior que 6 caracteres.");
}else {
Usuario usuario = new Usuario(userName, senha, nome, telefone, email, isAdministrador);
this.cadUsuario.inserir(usuario);
}
}

public Usuario consultarUsuario(String usuario) throws CamposEmBrancoException, UsuarioNaoEncontradoException, IOException,
ClassNotFoundException, Exception {
if (usuario.isEmpty())
throw new CamposEmBrancoException("Campo usu�rio em branco. Digite o usu�rio para a consulta.");

return this.cadUsuario.consultar(usuario);
}

public void alterarUsuario(String userName, String senha, String nome, String telefone, String email, int isAdministrador)
throws CamposEmBrancoException, NaoEncontradoException, Exception {
if(userName.isEmpty() || senha.isEmpty() || nome.isEmpty() || telefone.isEmpty() || email.isEmpty())
throw new CamposEmBrancoException("Campos em branco. Digite os campos para a altera��o");
else if (senha.length() <= 6){
throw new TamanhoDaSenhaException("O tamanho da senha deve ser maior que 6 caracteres.");
}else{
Usuario usuario = new Usuario(userName, senha, nome, telefone, email, isAdministrador);
this.cadUsuario.alterar(usuario);
}
}

public void excluirUsuario(String usuario) throws NaoEncontradoException, IOException, ClassNotFoundException, Exception {
if (usuario.isEmpty())
throw new CamposEmBrancoException("Informe o Campo Nome para a exclus�o.");
Usuario usuarios = consultarUsuario(usuario);
this.cadUsuario.excluir(usuarios);
}

public Usuario logarUsuario(String userName, String senha) throws CamposEmBrancoException, UsuarioNaoEncontradoException, IOException, ClassNotFoundException, Exception {
if (userName.isEmpty() || senha.isEmpty())
throw new CamposEmBrancoException("Campos em branco. Digite os campos para continuar");

return this.cadUsuario.logar(userName, senha);
}

public void inserirProduto(String codigoBarra, String nome, String fornecedor, String telefone, String email,
double valorCompra, double valorVenda, int qtdEstoque) throws IOException, ClassNotFoundException,
CamposEmBrancoException, EncontradoException, Exception {
if(codigoBarra.isEmpty() || nome.isEmpty() || fornecedor.isEmpty() || telefone.isEmpty() || email.isEmpty())
throw new CamposEmBrancoException("Digite os campos em branco para continuar.");

Produto produto = new Produto(codigoBarra, nome, fornecedor, telefone, email, valorCompra, valorVenda, qtdEstoque);		
this.cadProduto.inserir(produto);
}

public Produto consultarProduto(String codigo) throws CamposEmBrancoException, IOException, ClassNotFoundException, NaoEncontradoException, Exception {
if (codigo.isEmpty())
throw new CamposEmBrancoException("Campo c�digo em branco! Digite o c�digo de barras para continuar.");

return this.cadProduto.consultar(codigo);
}

public void alterarProduto(String codigoBarra, String nome, String fornecedor, String telefone, String email,
double valorCompra, double valorVenda, int qtdEstoque) throws IOException, ClassNotFoundException,
CamposEmBrancoException, NaoEncontradoException, Exception {
if(codigoBarra.isEmpty() || nome.isEmpty() || fornecedor.isEmpty() || telefone.isEmpty() || email.isEmpty())
throw new CamposEmBrancoException("Digite os campos em branco para continuar.");

Produto produto = new Produto(codigoBarra, nome, fornecedor, telefone, email, valorCompra, valorVenda, qtdEstoque);
this.cadProduto.alterar(produto);
}

public void excluirProduto(String codigo) throws CamposEmBrancoException, IOException, ClassNotFoundException, NaoEncontradoException, Exception {
if (codigo.isEmpty())
throw new CamposEmBrancoException("Campo c�digo em branco! Digite o c�digo de barras para continuar.");		
Produto produto = consultarProduto(codigo);
this.cadProduto.excluir(produto);
}

public void controleEstoque(String codigo, int qtd) {
this.cadProduto.controleEstoque(codigo, qtd);
}

public void vendas(ArrayList<Caixa> listaCaixa) {
this.cadCaixa.vendas(listaCaixa);
}

public ArrayList<Caixa> controleVendas(String data) {
return this.cadCaixa.controleVendas(data);
}

private int tamanhoSenha(String senha) {
return senha.length();
}*/