package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;
import br.faculdadenovaroma.tap.ecommerce.util.JPAUtil;

public class RepsitorioFuncionario implements IRepositorioFuncionarioJPA {

	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean achou(String cpf) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Funcionario novoFuncionario) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(novoFuncionario);

			entityManager.flush();
			transaction.commit();

		} catch (RuntimeException excepition) {
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (RuntimeException excepiton1) {
				}
			}
			throw excepition;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Funcionario consultar(String cpf) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> listar() throws HibernateException {
		
		entityManager = JPAUtil.getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select u from Funcionario u");
		List<Funcionario> results = query.getResultList();

		entityManager.flush();
		transaction.commit();

		entityManager.close();

	
		return results;
	}

	@Override
	public void alterar(Funcionario funcionario, int id) throws HibernateException {
		try {

			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			funcionario = entityManager.find(funcionario.getClass(), id);
			
			funcionario.setCelular(funcionario.getCelular());
			funcionario.setCpf(funcionario.getCpf());
			funcionario.setEmail(funcionario.getEmail());
			funcionario.setEndereco(funcionario.getEndereco());
			funcionario.setNome(funcionario.getNome());
			funcionario.setPassword(funcionario.getPassword());
			funcionario.setTelefone(funcionario.getTelefone());
			funcionario.setUser(funcionario.getUser());
			
			entityManager.flush();
			transaction.commit();

		} catch (RuntimeException excepition) {
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (RuntimeException excepiton1) {
				}
			}
			throw excepition;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void excluir(Funcionario funcionario, int id) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			funcionario = entityManager.find(funcionario.getClass(), 1);
			entityManager.remove(funcionario);

			entityManager.flush();
			transaction.commit();

		} catch (RuntimeException excepition) {
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (RuntimeException excepiton1) {
				}
			}
			throw excepition;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Funcionario logar(String user, String password) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
