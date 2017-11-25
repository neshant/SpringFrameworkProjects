package com.mycompany.jpa.springjpahibernateexample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users", catalog = "test")
public class Users {

	@Id
	@Column(name = "user_id") // default . If this annotation is not used then default name is java class //
								// variable name
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String name;
	private Integer salary;
	// optional field name teamname
	private String hasTeamName;

	private Users(UserBuilder userBuilder) {
		this.name = userBuilder.getName();
		this.salary = userBuilder.getSalary();
		this.hasTeamName = userBuilder.getHasTeamName();
		this.usersLog = userBuilder.getUsersLog();
	}

	private Users() {
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_log_ids", referencedColumnName = "user_id")
	private List<UsersLog> usersLog;

	public List<UsersLog> getUsersLog() {
		return usersLog;
	}

	// public void setUsersLog(List<UsersLog> usersLog) {
	// this.usersLog = usersLog;
	// }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	public Integer getSalary() {
		return salary;
	}
	//
	// public void setSalary(Integer salary) {
	// this.salary = salary;
	// }

	// optional field
	public String getHasTeamName() {
		return hasTeamName;
	}

	// public void setHasTeamName(String hasTeamName) {
	// this.hasTeamName = hasTeamName;
	// }

	public static class UserBuilder {

		private String name;
		private Integer salary;
		private String hasTeamName;
		private List<UsersLog> usersLog;

		public UserBuilder(String name, Integer salary) {

			this.name = name;
			this.salary = salary;
		}

		public List<UsersLog> getUsersLog() {
			return usersLog;
		}

		public UserBuilder setUsersLog(List<UsersLog> usersLog) {
			this.usersLog = usersLog;
			return this;
		}

		public String getName() {
			return name;
		}

		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public Integer getSalary() {
			return salary;
		}

		public UserBuilder setSalary(Integer salary) {
			this.salary = salary;
			return this;
		}

		public String getHasTeamName() {
			return hasTeamName;
		}

		public UserBuilder setHasTeamName(String hasTeamName) {
			this.hasTeamName = hasTeamName;
			return this;
		}

		public Users build() {
			return new Users(this);

		}

	}

}
