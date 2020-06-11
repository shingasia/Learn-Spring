package com.mongo.repositories;

import com.mongo.vo.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, String> {

}