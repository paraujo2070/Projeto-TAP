package br.faculdadenovaroma.tap.ecommerce.repositorioJDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;

public interface IRepositorioFornecedorJDBC {
	public boolean achou(String cpf);
	public void inserir(Fornecedor novoFornecedor) throws SQLException, ClassNotFoundException;
	public Fornecedor consultar(String cnpj) throws SQLException, ClassNotFoundException;
	public ArrayList<Fornecedor> listar() throws ClassNotFoundException, SQLException;
	public void alterar(Fornecedor fornecedor) throws ClassNotFoundException, SQLException;
	public void excluir(String cnpj) throws ClassNotFoundException, SQLException;
}
