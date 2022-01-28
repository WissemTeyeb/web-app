package com.example.demo.security;

import com.example.demo.model.ToDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepo extends MongoRepository<userApp,String> {
    public userApp findByEmail(String email);
    public userApp findByUsername(String username);


}
