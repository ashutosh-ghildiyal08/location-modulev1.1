package com.location.LocationModule.Listener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.location.LocationModule.Response.UserDto;
import com.location.LocationModule.Service.UserService;
import com.location.LocationModule.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UserListener {

    @Autowired
    UserService userService;
    @Autowired
    ObjectMapper mapper;



    @JmsListener(destination = "user")
    public void consume(String str) throws JsonProcessingException {
        System.out.println(str);

        List<String> strSplit = Stream.of(str.split(",", 2))
                .collect(Collectors.toList());
        String actionStr = strSplit.get(0);
        String message = strSplit.get(1);

        List<String> actionSplit = Stream.of(actionStr.split("=", 2))
                .collect(Collectors.toList());
        String action = actionSplit.get(1);

        //2. Convert JSON to User objects


        switch (action){
            case "add":
                System.out.println("add");

                UserDto jsonToUser = mapper.readValue(message, UserDto.class);
                System.out.println(jsonToUser);
                userService.addUser( jsonToUser);
                break;

            case "delete":
                List<String> messageSplit = Stream.of(message.split("=", 2))
                        .collect(Collectors.toList());
                String id = messageSplit.get(1);
                Integer userId= Integer.parseInt(id);
                System.out.println("delete id = "+userId);
                userService.removeUser(userId);
                break;

            default:
                System.out.println("Wrong action");
                break;
        }


    }
}