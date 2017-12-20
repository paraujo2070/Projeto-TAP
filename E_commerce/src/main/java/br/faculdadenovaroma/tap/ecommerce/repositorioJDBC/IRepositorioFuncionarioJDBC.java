package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;

public interface IRepositorioFuncionarioJDBC {
	public boolean achou(String cpf);
	public void inserir(Funcionario novoFuncionario) throws SQLException, ClassNotFoundException;
	public Funcionario consultar(String cpf) throws SQLException, ClassNotFoundException;
	public ArrayList<Funcionario> listar() throws ClassNotFoundException, SQLException;
	public void alterar(Funcionario funcionario) throws ClassNotFoundException, SQLException;
	public void alterarUsuario(String user, String pass) throws ClassNotFoundException, SQLException;
	public void excluir(String cpf) throws ClassNotFoundException, SQLException;
}