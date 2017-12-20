package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Cliente;
import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;
import br.faculdadenovaroma.tap.ecommerce.util.JPAUtil;

public class RepsitorioFornecedor implements IRepositorioFornecedorJPA {

	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean achou(String cnpj) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Fornecedor novoFornecedor) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(novoFornecedor);

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
	public Fornecedor consultar(String cnpj) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> listar() throws HibernateException {
		
		entityManager = JPAUtil.getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select u from Fornecedor u");
		List<Fornecedor> results = query.getResultList();

		entityManager.flush();
		transaction.commit();

		entityManager.close();
		
		return results;
	}

	@Override
	public void alterar(Fornecedor fornecedor, int id) throws HibernateException {
		try {

			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			fornecedor = entityManager.find(fornecedor.getClass(), id);
			
			fornecedor.setCnpj(fornecedor.getCnpj());
			fornecedor.setEmail(fornecedor.getEmail());
			fornecedor.setEndereco(fornecedor.getEndereco());
			fornecedor.setNome(fornecedor.getNome());
			fornecedor.setNomeRepresentante(fornecedor.getNomeRepresentante());
			fornecedor.setTelefone(fornecedor.getTelefone());
			fornecedor.setSigla(fornecedor.getSigla());
			
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
	public void excluir(Fornecedor fornecedor, int id) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			fornecedor = entityManager.find(fornecedor.getClass(), id);
			entityManager.remove(fornecedor);

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
