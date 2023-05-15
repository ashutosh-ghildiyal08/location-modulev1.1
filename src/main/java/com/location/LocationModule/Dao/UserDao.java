package com.location.LocationModule.Dao;


import com.location.LocationModule.Repository.UserRepository;
import com.location.LocationModule.Response.UserDto;
import com.location.LocationModule.Translator.ObjectTranslator;
import com.location.LocationModule.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    ObjectTranslator objectTranslator;

    @Autowired
    UserRepository userRepository;

    public UserDto save(UserDto jsonToUser) {
        UserEntity userEntity = objectTranslator.translate(jsonToUser, UserEntity.class );
        UserEntity savedUserEntity = userRepository.save(userEntity);
        UserDto savedUserDto = objectTranslator.translate(savedUserEntity, UserDto.class);
        return savedUserDto;

    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
