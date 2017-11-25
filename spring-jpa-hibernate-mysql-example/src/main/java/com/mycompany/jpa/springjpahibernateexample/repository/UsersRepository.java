package com.mycompany.jpa.springjpahibernateexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.jpa.springjpahibernateexample.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	List<Users> findByName(String name);

	List<Users> findBySalary(Integer salary);

}
