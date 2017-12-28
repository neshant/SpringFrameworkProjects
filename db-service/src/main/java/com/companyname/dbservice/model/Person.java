package com.companyname.dbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Person {

	@Id
	@GeneratedValue
	Long id;

	private Integer age;
	private String gender;
	private String ssnNumber;

	// JPA needs a private no arg constructor
	private Person() {
	}

}
