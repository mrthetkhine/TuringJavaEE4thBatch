package com.turing.javaee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turing.javaee.model.User;



@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	User findByName(String name);
}
