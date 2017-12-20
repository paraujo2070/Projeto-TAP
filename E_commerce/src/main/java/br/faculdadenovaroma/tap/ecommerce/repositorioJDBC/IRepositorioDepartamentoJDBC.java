package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;

public interface IRepositorioDepartamentoJDBC {
	public boolean achou(String nome);
	public void inserir(Departamento novoDepartamento) throws SQLException, ClassNotFoundException;
	public Departamento consultar(String nome) throws SQLException, ClassNotFoundException;
	public ArrayList<Departamento> listar() throws ClassNotFoundException, SQLException;
	public void alterar(Departamento departamento) throws ClassNotFoundException, SQLException;
	public void excluir(String nome) throws ClassNotFoundException, SQLException;
}
