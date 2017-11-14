package com.concretepage.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.concretepage.entity.Person;

@Transactional
@Repository("fileDAO")
public class FileDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void addPerson(Person person) {
		entityManager.persist(person);
	}

	public boolean personExists(String name, String phoneNo) {
		String hql = "FROM Person as person WHERE person.name = ? and person.phoneNo = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name).setParameter(2, phoneNo).getResultList()
				.size();
		return count > 0 ? true : false;
	}
}
