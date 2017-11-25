package com.mycompany.jpa.springjpahibernateexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_log", catalog = "test")
public class UsersLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	private Integer id;

	private String log;

	@Column(name = "user_log_ids")
	private Integer user_log_ids;

	public UsersLog() {

	}


	public Integer getUser_log_ids() {
		return user_log_ids;
	}


	public void setUser_log_ids(Integer user_log_ids) {
		this.user_log_ids = user_log_ids;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

}
