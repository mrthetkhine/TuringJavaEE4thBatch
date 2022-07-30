package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByUsername(String username);
}
