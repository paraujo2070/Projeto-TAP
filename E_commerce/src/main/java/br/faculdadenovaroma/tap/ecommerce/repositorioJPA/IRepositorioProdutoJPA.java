package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;

public interface IRepositorioProdutoJPA {
	public boolean achou(int codigo) throws HibernateException;
	public void inserir(Produto novoProduto) throws HibernateException;
	public Produto consultar(int codigo) throws HibernateException;
	public List<Produto> listar() throws HibernateException;
	public List<Produto> filtrar(Departamento departamento) throws HibernateException;
	public void alterar(Produto produto, int codigo) throws HibernateException;
	public void excluir(Produto produto, int codigo) throws HibernateException;
}
