package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;

public interface IRepositorioProdutoJDBC {
	public boolean achou(int cod);
	public void inserir(Produto novoProduto) throws SQLException, ClassNotFoundException;
	public Produto consultar(String nomeProd) throws SQLException, ClassNotFoundException;
	public ArrayList<Produto> listar() throws ClassNotFoundException, SQLException;
	public void alterar(Produto produto) throws ClassNotFoundException, SQLException;
	public void excluir(String nome) throws ClassNotFoundException, SQLException;
}