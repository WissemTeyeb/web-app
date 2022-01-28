package com.example.demo.service;


import com.example.demo.errors.DataAlreadyExistForUser;
import com.example.demo.errors.NotFoundException;
import com.example.demo.repo.DataRepo;
import com.example.demo.model.ToDO;
import com.example.demo.security.userApp;
import com.example.demo.security.userRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ToDoService {

    @Autowired
    private DataRepo dataRepository;
    @Autowired
    private userRepo uRepo;

    public List<userApp> getUsers() {
        return uRepo.findAll();
    }

    public List<ToDO> getDataById(String id) {
        try {
            //here we have only one user with id=1919
            if (uRepo.findById(id).isPresent()) {
                return dataRepository.findAllByUserID(id);

            } else {
                return null;
            }


        } catch (NoSuchElementException ex) {
            throw new NotFoundException("data not found  !");
        }
    }

    public void removeObjectById(String id) {

        dataRepository.deleteById(id);
    }

    public ToDO saveObject(ToDO o) {
        /*try{
            return
        }catch (NoSuchElementException ex){*/
        throw new DataAlreadyExistForUser("data already exist!");
        // }

    }


}
