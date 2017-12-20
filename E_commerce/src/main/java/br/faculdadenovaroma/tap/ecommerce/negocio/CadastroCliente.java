package br.faculdadenovaroma.tap.ecommerce.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;
import br.faculdadenovaroma.tap.ecommerce.excecao.EncontradoException;
import br.faculdadenovaroma.tap.ecommerce.excecao.NaoEncontradoException;
import br.faculdadenovaroma.tap.ecommerce.excecao.UsuarioOuSenhaInvalido;
import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.IRepositorioClienteJDBC;

public class CadastroCliente {
	private IRepositorioClienteJDBC repCliente;
	
	public CadastroCliente(IRepositorioClienteJDBC repCliente) {
		if (repCliente == null)
			System.out.println("Error...");
		else
			this.repCliente = repCliente;
	}
	
	public void inserir(Cliente novoCliente) throws SQLException, EncontradoException, ClassNotFoundException {
		if(!this.repCliente.achou(novoCliente.getPessoa().getCpf())) {
			this.repCliente.inserir(novoCliente);
		}else
			throw new EncontradoException("Esse usuário "+novoCliente.getPessoa().getNome()+" j� se encontra cadastrado no nosso banco de dados."
					+ "Caso tenha perdido a senha, siga o procedimento para poder alterar.");
	}
	
	public Cliente consultar(String cpf) throws SQLException, NaoEncontradoException, ClassNotFoundException {
		Cliente cliente = null;

		if(this.repCliente.achou(cpf)) {
			cliente = this.repCliente.consultar(cpf);
		}else
			throw new NaoEncontradoException("Cliente n�o cadastrado no sistema.");

		return cliente;
	}
	
	public ArrayList<Cliente> listar() throws SQLException, ClassNotFoundException {
		return this.repCliente.listar();
	}
	
	public void alterar(Cliente cliente, String cpf) throws SQLException, NaoEncontradoException, ClassNotFoundException {
		if(this.repCliente.achou(cpf)) {
			this.repCliente.alterar(cliente);
		}else
			throw new NaoEncontradoException("Cliente n�o cadastrado no sistema.");		
	}
	
	public void excluir(String cpf) throws SQLException, NaoEncontradoException, ClassNotFoundException {
		if(this.repCliente.achou(cpf)) {
			this.repCliente.excluir(cpf);
		}else
			throw new NaoEncontradoException("Cliente n�o cadastrado no sistema.");
	}
	
	public Cliente logar(String cpf, String password) throws SQLException, UsuarioOuSenhaInvalido, ClassNotFoundException {
		Cliente cliente = this.repCliente.consultar(cpf);

		if (cliente == null)
			throw new UsuarioOuSenhaInvalido("Usu�rio ou Senha Inv�lidos.");
		else {
			if (!cliente.getPassword().equalsIgnoreCase(password)) {
				cliente = null;
				throw new UsuarioOuSenhaInvalido("Usu�rio ou Senha Inv�lidos.");
			}
		}
		
		return cliente;
	}
}