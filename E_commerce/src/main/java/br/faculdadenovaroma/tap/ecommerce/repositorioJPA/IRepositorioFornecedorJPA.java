package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;

public interface IRepositorioFornecedorJPA {
	public boolean achou(String cnpj) throws HibernateException;
	public void inserir(Fornecedor novoFornecedor) throws HibernateException;
	public Fornecedor consultar(String cnpj) throws HibernateException;
	public List<Fornecedor> listar() throws HibernateException;
	public void alterar(Fornecedor fornecedor, int id) throws HibernateException;
	public void excluir(Fornecedor cliente, int id) throws HibernateException;
}
