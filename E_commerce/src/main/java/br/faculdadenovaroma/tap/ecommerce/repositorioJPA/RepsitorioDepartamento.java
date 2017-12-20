package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;
import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.util.JPAUtil;

public class RepsitorioDepartamento implements IRepositorioDepartamentoJPA{
	
	EntityManager entityManager = null;
	EntityTransaction transaction = null;


	@Override
	public boolean achou(int codigo) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Departamento novoDepartamento) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(novoDepartamento);

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
	public Departamento consultar(int codigo) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> listar() throws HibernateException {
		
		entityManager = JPAUtil.getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select u from Departamento u");
		List<Departamento> results = query.getResultList();

		entityManager.flush();
		transaction.commit();

		entityManager.close();

		return results;
	}

	@Override
	public void alterar(Departamento departamento, int codigo) throws HibernateException {
		try {

			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			departamento = entityManager.find(departamento.getClass(), codigo);

			departamento.setCodigo(departamento.getCodigo());
			departamento.setNome(departamento.getNome());

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
	public void excluir(Departamento departamento, int codigo) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			departamento = entityManager.find(departamento.getClass(), 1);
			entityManager.remove(departamento);

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

	
}
