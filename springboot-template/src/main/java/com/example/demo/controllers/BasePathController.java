package com.example.demo.controllers;


import com.example.demo.security.UserAuthentification;
import com.example.demo.security.UserService;
import com.example.demo.security.signUpRequest;
import com.example.demo.security.userApp;
import com.example.demo.service.ToDoService;
import com.example.demo.model.ToDO;
import com.example.demo.utile.preRun;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/url/api/v1")
@Api(value = "User Resource REST Endpoint", description = "Shows the user info")
public class BasePathController extends UserAuthentification {
    @Autowired
    private ToDoService service;
    @Autowired
    UserService userDetailsService;

    private final Log logger = LogFactory.getLog(BasePathController.class);

    @GetMapping(value = "/{name}")
    public String getNameController(@PathVariable String name) {

        return "hello from url/api/v1 " + name;

    }

    @ApiOperation(value = "getUsers1", notes = "get users2", nickname = "getUsers3")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "success result",
                    response = userApp.class, responseContainer = "List")})
    @GetMapping(value = "/users")
    public List<userApp> getUsersController() {

        List<userApp> result = service.getUsers();
        return result;

    }

    @GetMapping(value = "/data")
    public List<ToDO> getDataByUserController() {
        List<ToDO> result = service.getDataById(super.getUserId());
        return result;

    }

    @PostMapping(value = "/data/add")
    public ResponseEntity<ToDO> saveDataController(@RequestBody ToDO o) {
        o.setId(super.getUserId());
        ToDO result = service.saveObject(o);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/data/remove/{id}")
    public ResponseEntity<ToDO> removeDataController(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping(value = "/signup")
    public void signup(@RequestBody signUpRequest request) {
        userDetailsService.saveUser(request);

    }

}
