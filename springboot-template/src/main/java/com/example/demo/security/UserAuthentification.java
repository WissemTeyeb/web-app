package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

  public abstract class UserAuthentification {

   public String getUserId(){

       Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
       userApp user= (userApp) authentication.getPrincipal();
       return user.getId();
    }
}
