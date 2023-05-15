package com.location.LocationModule.Service;


import com.location.LocationModule.Dao.UserDao;
import com.location.LocationModule.Repository.UserRepository;
import com.location.LocationModule.Response.UserDto;
import com.location.LocationModule.Translator.ObjectTranslator;
import com.location.LocationModule.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    ObjectTranslator objectTranslator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDao userDao;

    public List<UserEntity> getAllUser()
    {
        List<UserEntity> user = new ArrayList<UserEntity>(userRepository.findAll());
        return user;
    }
    public void saveOrUpdate(UserEntity user)
    {
        userRepository.save(user);

    }


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUsers(List<UserEntity> userList) {
        userRepository.saveAll(userList);
    }

    public void  addUser(UserDto jsonToUser) {
        userDao.save( jsonToUser);
    }

    public void removeUser(int id){
        userDao.deleteById(id);
    }
}

