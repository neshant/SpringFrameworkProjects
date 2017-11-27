package com.mycompany.jpa.springjpahibernateexample.model;

import java.util.List;

import lombok.Data;

@Data
public class Person {

	private List<Habbit> habbits;

	private String firstName;

	private String lastName;

	private Integer drivingLicense;

	public void setDrivingLicense(Integer drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getFirstName() {
		return firstName;
	}

	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getDrivingLicense() {
		return drivingLicense;
	}

	public Person setDrivingLicense(int drivingLicense) {
		this.drivingLicense = drivingLicense;
		return this;
	}


	public List<Habbit> getHabbits() {
		return habbits;
	}

	public Person setHabbits(List<Habbit> habbits) {
		this.habbits = habbits;
		return this;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((habbits == null) ? 0 : habbits.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (habbits == null) {
			if (other.habbits != null)
				return false;
		} else if (!habbits.equals(other.habbits))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", drivingLicense=" + drivingLicense + "]";
	}

}
