package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;

public interface IRepositorioFuncionarioJPA {
	public boolean achou(String cpf) throws HibernateException;
	public void inserir(Funcionario novoFuncionario) throws HibernateException;
	public Funcionario consultar(String cpf) throws HibernateException;
	public List<Funcionario> listar() throws HibernateException;
	public void alterar(Funcionario funcionario, int id) throws HibernateException;
	public void excluir(Funcionario funcionario, int id) throws HibernateException;
	public Funcionario logar(String user, String password) throws HibernateException;
}
