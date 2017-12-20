package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.SQLException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Carrinho;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;

public interface IRepositorioCarrinhoJDBC {
	public boolean achou(String cpf);
	public void inserir(Produto produto) throws SQLException, ClassNotFoundException;
	public Carrinho listar() throws ClassNotFoundException, SQLException;
	public void alterar(Produto produto, int quantidade) throws ClassNotFoundException, SQLException;
	public void excluir(Produto produto) throws ClassNotFoundException, SQLException;
}
