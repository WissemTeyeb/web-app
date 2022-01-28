package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @RequestMapping(value= {"/",""})
    public String getHomeContr(){

        return "Home page !";

    }
    @GetMapping(value= "name/{name}")
    public String getNameController( @PathVariable String name){

        return "HoMy name " +name ;

    }
}
