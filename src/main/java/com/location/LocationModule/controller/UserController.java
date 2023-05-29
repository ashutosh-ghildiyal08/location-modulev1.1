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
@CrossOrigin(origins="http://localhost:3000/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper mapper;


    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public String addUsers(List<UserEntity> userList) {
        userService.addUsers(userList);
        return "Users Saved";
    }




}

