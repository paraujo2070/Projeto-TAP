package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;

public interface IRepositorioClienteJPA {
	public boolean achou(String cpf) throws HibernateException;
	public void inserir(Cliente novoCliente) throws HibernateException;
	public Cliente consultar(String cpf) throws HibernateException;
	public List<Cliente> listar() throws HibernateException;
	public void alterar(Cliente cliente,int id) throws HibernateException;
	public void excluir(Cliente cliente) throws HibernateException;
	public Cliente logar(String user, String password) throws HibernateException;
}
