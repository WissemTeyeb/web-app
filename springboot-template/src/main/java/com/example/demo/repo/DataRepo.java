package com.example.demo.repo;

import com.example.demo.model.ToDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DataRepo extends MongoRepository<ToDO,String> {
    public List<ToDO> findAllByUserID( String id);
}