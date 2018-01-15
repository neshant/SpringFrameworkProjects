package lambda.observable;

import java.time.LocalDate;
import java.util.List;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static int compareByAge2(Person a) {
		return 1;
	}

	public Object printPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Person> createRoster() {
		// TODO Auto-generated method stub
		return null;
	}
}