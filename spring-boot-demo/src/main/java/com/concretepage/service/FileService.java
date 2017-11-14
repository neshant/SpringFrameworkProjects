package com.concretepage.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.concretepage.dao.FileDAO;
import com.concretepage.entity.Person;

/**
 * Service for processing the file received from the controller. Object created
 * here will be sent to the respective DAO class.
 * 
 * @author neshant
 *
 */
@Service("fileService")
public class FileService {
	@Qualifier("fileDAO")
	@Autowired
	private FileDAO fileDAO;

//	public synchronized boolean addPerson(List<Person> persons) {
		public synchronized boolean addPerson(Person person) {		

		// if (fileDAO.personExists(person.getName(), person.getPhoneNo())) {
		// return false;
		// } else {
//		fileDAO.addPerson(person);
		return true;
		// }

	}

	public void readFile(MultipartFile multipart) {

		fileDAO.addPerson(multipart);
//		File fileName = new File(multipart.getOriginalFilename());

		String line = null;
		List<Person> personList = new ArrayList<Person>();

//		try {
//			InputStream is = multipart.getInputStream();
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

		
			
//			while ((line = bufferedReader.readLine()) != null) {
//				// System.out.println(line);
//
//				String[] ar = line.split(",");
//				Person person = new Person();
//				person.setName(ar[0]);
//				person.setGender(ar[1]);
//				person.setPhoneNo(ar[2]);
//				personList.add(person);
//
//				if (personList.size() >= 9) {
//					addPerson(personList);
//					personList.clear();
//				}
//
//			}

//			bufferedReader.close();
//		} catch (FileNotFoundException ex) {
//			System.out.println("Unable to open file '" + fileName + "'");
//		} catch (IOException ex) {
//			System.out.println("Error reading file '" + fileName + "'");

//		}

	}

}
