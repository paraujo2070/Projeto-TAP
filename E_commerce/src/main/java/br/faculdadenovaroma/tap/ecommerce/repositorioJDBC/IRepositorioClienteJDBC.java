package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;

public interface IRepositorioClienteJDBC {
	public boolean achou(String cpf) throws SQLException;
	public void inserir(Cliente novoCliente) throws SQLException, ClassNotFoundException;
	public Cliente consultar(String cpf) throws SQLException, ClassNotFoundException;
	public ArrayList<Cliente> listar() throws ClassNotFoundException, SQLException;
	public void alterar(Cliente cliente) throws ClassNotFoundException, SQLException;
	public void alterarUsuario(String user, String pass) throws ClassNotFoundException, SQLException;
	public void excluir(String cpf) throws ClassNotFoundException, SQLException;
	public Cliente logar(String user, String password) throws SQLException;
}
