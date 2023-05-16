package com.location.LocationModule.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.location.LocationModule.service.UserService;
import com.location.LocationModule.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper mapper;

    @JmsListener(destination = "demo")
    public void consume(String message) throws JsonProcessingException {

        //2. Convert JSON to List of Person objects
        //Define Custom Type reference for List<Person> type
        TypeReference<List<UserEntity>> mapType = new TypeReference<>() {};
        List<UserEntity> jsonToPersonList = mapper.readValue(message, mapType);
        for (UserEntity user: jsonToPersonList) {
            System.out.println(user);
        }
        userService.addUsers(jsonToPersonList);

    }
    @GetMapping("/users")
    public List<UserEntity> getAllLocation() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public String addUsers(List<UserEntity> userList) {
        userService.addUsers(userList);
        return "Users Saved";
    }



}

