package com.mycompany.jpa.springjpahibernateexample.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.jpa.springjpahibernateexample.model.Users;
import com.mycompany.jpa.springjpahibernateexample.model.UsersContact;
import com.mycompany.jpa.springjpahibernateexample.model.UsersLog;
import com.mycompany.jpa.springjpahibernateexample.repository.UsersContactRepository;

@RestController
@RequestMapping("/rest/userscontact")
public class UsersContactResource {

	// @Autowired spring also does contructorr inject is automatic
	private UsersContactRepository usersContactRepository;

	public UsersContactResource(UsersContactRepository usersContactResource) {
		this.usersContactRepository = usersContactResource;
	}

	@GetMapping(value = "/all")
	public List<UsersContact> getUsersContact() {
		return usersContactRepository.findAll();

	}

	@PostMapping(value = "/update/{name}")
	public List<UsersContact> update(@PathVariable final String name) {
		UsersContact usersContact = new UsersContact();

		// using builder patter and inner class Userbuider to create a new users class
	
		UsersLog usersLog = new UsersLog();
		usersLog.setLog("logged 1");
		UsersLog usersLog2 = new UsersLog();
		usersLog2.setLog("logged 2");
	
		Users user = new Users.UserBuilder(name, 20000000)
				.setHasTeamName("helpingTeam")
				.setUsersLog(Arrays.asList(usersLog,usersLog2))
				
				.build();
		usersContact.setPhoneNo(85723123).setUsers(user);
		usersContactRepository.save(usersContact);
		return getUsersContact();

	}

}
