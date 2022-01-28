package com.example.demo.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import java.util.*;

@ApiModel
@Document(collection="users")
public class userApp implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private String id;//id for the user
    private Collection<? extends GrantedAuthority> authorities;
    @ApiModelProperty(notes = "email of the user")
    private String email;


    public String password;

    private String username;

    public userApp(String id,String username,  String password,  Collection<? extends GrantedAuthority> authorities) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.authorities=authorities;
    }
    @PersistenceConstructor
    public userApp(String username, String email,String password) {

        this.username=username;
        this.password=password;
        this.email=email;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void eraseCredentials(){
        this.password=null;
    }

    public String getId() {
        return id;
    }

    public userApp(String id, Collection<? extends GrantedAuthority> authorities, String email, String password, String username) {
        this.id = id;
        this.authorities = authorities;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
