package com.concretepage.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.concretepage.dao.FileDAO;
import com.concretepage.entity.Person;

@Service("fileService")
public class FileService {

	@Qualifier("fileDAO")
	@Autowired
	private FileDAO fileDAO;

	public synchronized boolean addPerson(Person person) {

		if (fileDAO.personExists(person.getName(), person.getPhoneNo())) {
			return false;
		} else {
			fileDAO.addPerson(person);
			return true;
		}

	}

	// public File convert(MultipartFile file)
	// {
	// File convFile = new File(file.getOriginalFilename());
	// convFile.createNewFile();
	// FileOutputStream fos = new FileOutputStream(convFile);
	// fos.write(file.getBytes());
	// fos.close();
	// return convFile;
	// }

	public void readFile(MultipartFile multipart) {

		File fileName = new File(multipart.getOriginalFilename());
		// try {
		//
		// multipart.transferTo(fileName);
		//
		// } catch (IllegalStateException | IOException e) {
		// System.out.println("Error reading file '" + multipart + "'");
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// This will reference one line at a time
		String line = null;

		try {
			InputStream is = multipart.getInputStream();
			// FileReader reads text files in the default encoding.
			// FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				String[] ar = line.split(",");
				Person person = new Person();
				person.setName(ar[0]);
				person.setGender(ar[1]);
				person.setPhoneNo(ar[2]);
				addPerson(person);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

	}

}
