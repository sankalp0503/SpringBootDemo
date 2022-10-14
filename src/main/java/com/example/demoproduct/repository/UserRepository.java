package com.example.demoproduct.repository;

import com.example.demoproduct.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {

}
