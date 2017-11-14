package com.concretepage.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.concretepage.entity.Person;

//@Transactional // removing transactional because batch processing will spawn mutiple
// transactions for each object created.
@Repository("fileDAO")
public class FileDAO {

	// @PersistenceContext
	// private EntityManager entityManager;
	@Autowired
	private EntityManagerFactory emf;

	// public void addPerson(List<Person> persons) {
	public void addPerson(MultipartFile multipart) {

		EntityManager entityManager = emf.createEntityManager();
		// entityManager.getTransaction().begin();
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		int batchSize = 0;

		String line = null;
		List<Person> personList = new ArrayList<Person>();

		try {
			InputStream is = multipart.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				batchSize++;

				String[] ar = line.split(",");
				Person person = new Person();
				person.setName(ar[0]);
				person.setGender(ar[1]);
				person.setPhoneNo(ar[2]);
//				personList.add(person);
				entityManager.persist(person);

				if (batchSize >= 29) {
					// addPerson(personList);
					// personList.clear();
					entityManager.flush();
					entityManager.clear();
					
					batchSize=0;
				}
				

			}

			entityManager.flush();
			entityManager.clear();
			et.commit();
			entityManager.close();
		} catch (FileNotFoundException ex) {
			// System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			// System.out.println("Error reading file '" + fileName + "'");

		}

		// - - - - - - - - - - - - - - Hibernate/JPA Batch Insert example - - - - - - -
		// - - - - -

		// EntityManager entityManager = emf.createEntityManager();
		//// entityManager.getTransaction().begin();
		// EntityTransaction et=entityManager.getTransaction();
		// et.begin();
		// for (Person person : persons) {

		// entityManager.persist(person);

		// if (batchSize == 29) {

		// }
		// batchSize++;
		// }
		// entityManager.flush();
		// entityManager.clear();
		// et.commit();
		// entityManager.getTransaction().commit();

		// entityManager.close();
		// emf.close();

		// public boolean personExists(String name, String phoneNo) {
		// String hql = "FROM Person as person WHERE person.name = ? and person.phoneNo
		// = ?";
		// int count = entityManager.createQuery(hql).setParameter(1,
		// name).setParameter(2, phoneNo).getResultList()
		// .size();
		// return count > 0 ? true : false;
		// }
	}
}
