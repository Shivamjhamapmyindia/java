package com.learningrestapi.learningrestapi.repository;

import com.learningrestapi.learningrestapi.model.UserModel;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Repository;
public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByEmail(String email);
    
}
