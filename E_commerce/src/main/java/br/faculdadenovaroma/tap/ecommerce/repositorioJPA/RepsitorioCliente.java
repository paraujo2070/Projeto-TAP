package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;
import br.faculdadenovaroma.tap.ecommerce.util.JPAUtil;

public class RepsitorioCliente implements IRepositorioClienteJPA {

	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean achou(String cpf) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Cliente novoCliente) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(novoCliente);

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
	public Cliente consultar(String cpf) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() throws HibernateException {
		
		entityManager = JPAUtil.getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select u from Cliente u");
		List<Cliente> results = query.getResultList();

		entityManager.flush();
		transaction.commit();

		entityManager.close();

		
		return results;
	}

	@Override
	public void alterar(Cliente cliente, int id) throws HibernateException {
		try {

			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			cliente = entityManager.find(cliente.getClass(), id);
			
			cliente.setCelular(cliente.getCelular());
			cliente.setCpf(cliente.getCpf());
			cliente.setEmail(cliente.getEmail());
			cliente.setEndereco(cliente.getEndereco());
			cliente.setNome(cliente.getNome());
			cliente.setPassword(cliente.getPassword());
			cliente.setTelefone(cliente.getTelefone());
			cliente.setUser(cliente.getUser());

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
	public void excluir(Cliente cliente) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			cliente = entityManager.find(cliente.getClass(), 1);
			entityManager.remove(cliente);
			
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
	public Cliente logar(String user, String password) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
