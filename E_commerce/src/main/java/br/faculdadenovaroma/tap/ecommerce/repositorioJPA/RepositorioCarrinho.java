package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Carrinho;
import br.faculdadenovaroma.tap.ecommerce.util.JPAUtil;

public class RepositorioCarrinho implements IRepositorioCarrinhoJPA {

	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean achou(int codigo) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Carrinho carrinho) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(carrinho);

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
	public Carrinho consultar(int codigo) throws HibernateException {
		return null;
	}

	@Override
	public List<Carrinho> listar() throws HibernateException {

		entityManager = JPAUtil.getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select u from Carrinho u");
		List<Carrinho> results = query.getResultList();

		entityManager.flush();
		transaction.commit();

		entityManager.close();

		return results;
	}

	@Override
	public void alterar(Carrinho carrinho, int codigo) throws HibernateException {
		try {

			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			carrinho = entityManager.find(carrinho.getClass(), codigo);

			carrinho.setProdutos(carrinho.getProdutos());
			carrinho.setQuantidade(carrinho.getQuantidade());
			carrinho.setValorTotal(carrinho.getValorTotal());

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
	public void excluir(Carrinho carrinho, int codigo) throws HibernateException {

		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			carrinho = entityManager.find(carrinho.getClass(), codigo);
			entityManager.remove(carrinho);

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
