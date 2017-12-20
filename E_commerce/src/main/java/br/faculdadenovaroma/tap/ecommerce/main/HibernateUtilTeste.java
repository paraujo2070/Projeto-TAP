package br.faculdadenovaroma.tap.ecommerce.main;

import javax.persistence.EntityManager;

import br.faculdadenovaroma.tap.ecommerce.util.JPAUtil;

public class HibernateUtilTeste {

	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
	//	session.close();
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.close();
	}

}
