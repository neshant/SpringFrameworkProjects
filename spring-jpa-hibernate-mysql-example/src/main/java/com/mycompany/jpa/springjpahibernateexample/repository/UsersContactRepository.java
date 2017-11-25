package com.mycompany.jpa.springjpahibernateexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.jpa.springjpahibernateexample.model.UsersContact;

public interface UsersContactRepository extends JpaRepository<UsersContact, Integer> {

}
