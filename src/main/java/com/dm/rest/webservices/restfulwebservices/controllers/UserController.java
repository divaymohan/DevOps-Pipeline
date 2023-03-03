package com.dm.rest.webservices.restfulwebservices.controllers;

import com.dm.rest.webservices.restfulwebservices.daos.UserDaoService;
import com.dm.rest.webservices.restfulwebservices.dtos.User;
import com.dm.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService service){
        this.userDaoService = service;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();

    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id"+id);
        return user;

    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
