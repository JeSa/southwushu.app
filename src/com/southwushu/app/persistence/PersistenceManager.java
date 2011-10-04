package com.southwushu.app.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersistenceManager {
	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("development");
	private static EntityManager manager = managerFactory.createEntityManager();
	
	public static void save(Object o) {
		manager.getTransaction().begin();
		manager.persist(o);
		manager.getTransaction().commit();
	}
	
	public static List<Object> execNamedQuery(String name) {
		Query query = manager.createNamedQuery(name);
		return query.getResultList();
	}
	
	public static Object execSingleNQuery(String name, Object id) {
		Query query = manager.createNamedQuery(name);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public static List<Object> execNamedQuery(String name, Object id) {
		Query query = manager.createNamedQuery(name);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	@Override
	protected void finalize() throws Throwable {
		manager.close();
		managerFactory.close();
		super.finalize();
	}
}
