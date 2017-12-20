package br.faculdadenovaroma.tap.ecommerce.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.repositorioJDBC.IRepositorioDepartamentoJDBC;

public class CadastroDepartamento {
	private IRepositorioDepartamentoJDBC repDepartamento;
	
	public CadastroDepartamento(IRepositorioDepartamentoJDBC repDepartamento) {
		if(repDepartamento == null)
			System.out.println("Error");
		else
			this.repDepartamento = repDepartamento;
	}
	
	public void inserir(Departamento novoDepartamento) throws SQLException, ClassNotFoundException {
		if(!this.repDepartamento.achou(novoDepartamento.getNome())) {
			this.repDepartamento.inserir(novoDepartamento);
		}else
			System.out.println("Error");
			//throw new EncontradoException("Usuário "+usuario.getNome()+" já cadastrado!");
	}
	
	public Departamento consultar(String nome) throws SQLException, ClassNotFoundException {
		Departamento departamento = null;

		if(this.repDepartamento.achou(nome)) {
			departamento = this.repDepartamento.consultar(nome);
		}else
			System.out.println("Error");
			//throw new UsuarioNaoEncontradoException("Usuário "+userName+" não está cadastrado!");

		return departamento;
	}
	
	public ArrayList<Departamento> listar() throws SQLException, ClassNotFoundException {
		return this.repDepartamento.listar();
	}
	
	public void alterar(Departamento departamento) throws SQLException, ClassNotFoundException {
		if(this.repDepartamento.achou(departamento.getNome())) {
			this.repDepartamento.alterar(departamento);
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");		
	}
	
	public void excluir(Departamento departamento) throws SQLException, ClassNotFoundException {
		if(this.repDepartamento.achou(departamento.getNome())) {
			this.repDepartamento.excluir(departamento.getNome());
		}else
			System.out.println("Error");
			//throw new NaoEncontradoException("Usuário "+usuario.getNome()+" não está cadastrado!");
	}
}