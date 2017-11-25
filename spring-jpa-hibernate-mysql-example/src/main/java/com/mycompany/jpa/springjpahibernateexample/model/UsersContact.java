package com.mycompany.jpa.springjpahibernateexample.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_contact", catalog = "test")
public class UsersContact {

	public UsersContact(Integer id, Integer phoneNo) {

		this.id = id;
		this.phoneNo = phoneNo;
	}

	public UsersContact() {

	}

	/**
	 * this column is the primary of this table
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer phoneNo;

	/**
	 * usercontact_id will be foreign key in current table and referenced column will be primary key from users table 
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usercontact_id", referencedColumnName = "user_id")
	private Users users;

	public Integer getId() {
		return id;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public Users getUsers() {
		return users;
	}

	public UsersContact setUsers(Users users) {
		this.users = users;
		return this;
	}

	// public void setId(Integer id) {
	// this.id = id;
	// return this;
	// }

	public UsersContact setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}

}
