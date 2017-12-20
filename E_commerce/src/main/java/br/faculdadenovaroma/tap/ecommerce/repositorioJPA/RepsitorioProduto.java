package br.faculdadenovaroma.tap.ecommerce.repositorioJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.util.JPAUtil;

public class RepsitorioProduto implements IRepositorioProdutoJPA {

	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean achou(int codigo) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserir(Produto novoProduto) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(novoProduto);

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
	public Produto consultar(int codigo) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listar() throws HibernateException {

		entityManager = JPAUtil.getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select u from Produtor u");
		List<Produto> results = query.getResultList();

		entityManager.flush();
		transaction.commit();

		entityManager.close();

		
		return results;
	}

	@Override
	public List<Produto> filtrar(Departamento departamento) throws HibernateException {
		return null;
	}

	@Override
	public void alterar(Produto produto, int codigo) throws HibernateException {
		try {

			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			produto = entityManager.find(produto.getClass(), codigo);

			produto.setDepartamento(produto.getDepartamento());
			produto.setCodigo(produto.getCodigo());
			produto.setFornecedor(produto.getFornecedor());
			produto.setInformacoes(produto.getInformacoes());
			produto.setNome(produto.getNome());
			produto.setPrecoVenda(produto.getPrecoVenda());
			produto.setQuantidade(produto.getQuantidade());

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
	public void excluir(Produto produto, int codigo) throws HibernateException {
		try {
			entityManager = JPAUtil.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			produto = entityManager.find(produto.getClass(), codigo);
			entityManager.remove(produto);

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
