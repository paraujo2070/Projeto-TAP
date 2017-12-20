package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;

public interface IRepositorioDepartamentoJPA {
	public boolean achou(int codigo) throws HibernateException;
	public void inserir(Departamento novoDepartamento) throws HibernateException;
	public Departamento consultar(int codigo) throws HibernateException;
	public List<Departamento> listar() throws HibernateException;
	public void alterar(Departamento departamento, int codigo) throws HibernateException;
	public void excluir(Departamento departamento, int codigo) throws HibernateException;
}
