package com.dm.rest.webservices.restfulwebservices.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class profileController {

    @Value("${spring.message:}")
    private String activeProfile;

    @GetMapping(path = "/api/profile")
    public String getCurrentProfile(){
        return activeProfile;

    }
}
