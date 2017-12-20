package br.faculdadenovaroma.tap.ecommerce.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;
import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.IRepositorioFuncionarioJDBC;

public class CadastroFuncionario {
	private IRepositorioFuncionarioJDBC repFuncionario;
	
	public CadastroFuncionario(IRepositorioFuncionarioJDBC repFuncionario) {
		if (repFuncionario == null)
			System.out.println("Error...");
		else
			this.repFuncionario = repFuncionario;
	}
	
	public void inserir(Funcionario novoFuncionario) throws SQLException, ClassNotFoundException {
		if(!this.repFuncionario.achou(novoFuncionario.getPessoa().getCpf())) {
			this.repFuncionario.inserir(novoFuncionario);
		}else
			System.out.println("Error");
			//throw new EncontradoException("Usuário "+usuario.getNome()+" já cadastrado!");
	}
	
	public Funcionario consultar(String cpf) throws SQLException, ClassNotFoundException {
		Funcionario funcionario = null;

		if(this.repFuncionario.achou(cpf)) {
			funcionario = this.repFuncionario.consultar(cpf);
		}else
			System.out.println("Error");
			//throw new UsuarioNaoEncontradoException("Usuário "+userName+" não está cadastrado!");

		return funcionario;
	}
	
	public ArrayList<Funcionario> listar() throws SQLException, ClassNotFoundException {
		return this.repFuncionario.listar();
	}
	
	public void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		if(this.repFuncionario.achou(funcionario.getPessoa().getCpf())) {
			this.repFuncionario.alterar(funcionario);
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");		
	}
	
	public void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		if(this.repFuncionario.achou(funcionario.getPessoa().getCpf())) {
			this.repFuncionario.excluir(funcionario.getPessoa().getCpf());
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");
	}
	
	public Funcionario logar(String cpf, String password) throws SQLException, ClassNotFoundException {
		Funcionario funcionario = this.repFuncionario.consultar(cpf);

		if (funcionario == null)
			System.out.println("Error");
			//throw new UsuarioNaoEncontradoException("Usuário ou Senha Inválidos.");
		else {
			if (!funcionario.getPassword().equalsIgnoreCase(password)) {
				funcionario = null;
				//throw new UsuarioNaoEncontradoException("Usuário ou Senha Inválidos.");
			}
		}
		
		return funcionario;
	}
}