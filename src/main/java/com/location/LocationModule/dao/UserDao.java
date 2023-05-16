package com.location.LocationModule.dao;


import com.location.LocationModule.repository.UserRepository;
import com.location.LocationModule.response.UserDto;
import com.location.LocationModule.translator.ObjectTranslator;
import com.location.LocationModule.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    ObjectTranslator objectTranslator;

    @Autowired
    UserRepository userRepository;

    public UserDto save(UserDto userDto) {
        UserEntity userEntity = objectTranslator.translate(userDto, UserEntity.class );
        UserEntity savedUserEntity = userRepository.save(userEntity);
        UserDto savedUserDto = objectTranslator.translate(savedUserEntity, UserDto.class);
        return savedUserDto;

    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
