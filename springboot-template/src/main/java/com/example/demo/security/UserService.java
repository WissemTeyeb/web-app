package com.example.demo.security;

import com.example.demo.errors.NotFoundException;
import com.example.demo.errors.UserAlreadyExist;
import com.example.demo.model.ToDO;
import com.example.demo.repo.DataRepo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private userRepo uRepo;

    private final Log logger = LogFactory.getLog(UserService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public userApp
    loadUserByUsername(String email) throws UsernameNotFoundException {
        // return findUserByEmail(s);
        //here an example because we have with id=1919 only one user//

        return uRepo.findByEmail(email);


    }

    public void saveObject(userApp user) {

        uRepo.insert(user);
    }

    public userApp findUserByEmail(String email) {
        return (userApp) uRepo.findByEmail(email);
    }

    public List<userApp> findUserAll() {
        return uRepo.findAll();

    }

    public Optional<userApp> findUserByID(String id) {
        return uRepo.findById(id);

    }

    public void saveUser(signUpRequest user) {
        if (uRepo.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExist("User with user email " + user.getEmail() + " is already exist");
        } else {
            userApp u = new userApp(user.getUsername(), user.getEmail(), passwordEncoder.encode(user.getPassword()));
            uRepo.save(u);
        }
    }


}




