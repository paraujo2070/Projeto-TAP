package br.faculdadenovaroma.tap.ecommerce.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManager entityManager = createSessionFactory();

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	private static EntityManager createSessionFactory() {
		EntityManagerFactory factory;
		factory = Persistence.createEntityManagerFactory("E_commerce");
		return factory.createEntityManager();
	}
}
