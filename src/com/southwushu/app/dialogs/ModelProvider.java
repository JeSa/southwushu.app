package com.southwushu.app.dialogs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.southwushu.app.models.Person;
import com.southwushu.app.persistence.PersistenceManager;

enum ModelProvider {
	INSTANCE;

	protected EntityManager em;
	private List<Person> persons;
	private List<Object> objects;

	private ModelProvider() {
		persons = new ArrayList<Person>();

		persons.add(new Person("Marie", "Dortmund"));
		persons.add(new Person("Holger", "Adams"));
		persons.add(new Person("Juliane", "Adams"));
	}

	public List<Person> getPersons() {
		//objects = PersistenceManager.execNamedQuery(Person.GET_ALL);
		
		Query query = em.createQuery("SELECT p.* FROM persons p");
		
	    return (List<Person>) query.getResultList();
	}

}