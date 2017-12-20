package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Carrinho;

public interface IRepositorioCarrinhoJPA {
	public boolean achou(int codigo) throws HibernateException;
	public void inserir(Carrinho carrinho) throws HibernateException;
	public Carrinho consultar(int codigo) throws HibernateException;
	public List<Carrinho> listar() throws HibernateException;
	public void alterar(Carrinho carrinho, int codigo) throws HibernateException;
	public void excluir(Carrinho carrinho, int codigo) throws HibernateException;
}
