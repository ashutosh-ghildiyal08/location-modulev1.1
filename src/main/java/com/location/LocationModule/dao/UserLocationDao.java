package com.location.LocationModule.dao;

import com.location.LocationModule.entity.LocationEntity;
import com.location.LocationModule.entity.UserEntity;
import com.location.LocationModule.repository.UserLocationRepository;
import com.location.LocationModule.repository.UserRepository;
import com.location.LocationModule.response.UserDto;
import com.location.LocationModule.response.UserLocationMappingDto;
import com.location.LocationModule.translator.ObjectTranslator;
import com.location.LocationModule.entity.UserLocationMappingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserLocationDao {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserLocationRepository userLocationRepository;

    @Autowired
    ObjectTranslator objectTranslator;

    public UserLocationMappingDto save(UserLocationMappingDto userLocationMappingDto) {
        UserLocationMappingEntity userLocationMapping = objectTranslator
                .translate(userLocationMappingDto, UserLocationMappingEntity.class);
        UserLocationMappingEntity savedUserLocationMapping = userLocationRepository.save(userLocationMapping);
        UserLocationMappingDto responseUserLocationMappingDto = objectTranslator
                .translate(savedUserLocationMapping, UserLocationMappingDto.class);
        return responseUserLocationMappingDto;

    }

    public List<UserDto> assignedUserList(int locationId) {
        List<UserLocationMappingEntity> userLocationMappingEntities = userLocationRepository.findAllByLocationId(locationId);
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserLocationMappingEntity userLocationMappingEntity: userLocationMappingEntities) {
            Integer userId = userLocationMappingEntity.getUserId();
            UserEntity userEntity = userRepository.findById(userId).get();
            UserDto userDto = objectTranslator.translate(userEntity, UserDto.class);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    public UserLocationMappingDto deleteByUserIdAndLocationId(int userId, int locationId) {
        UserLocationMappingEntity userLocationMapping = userLocationRepository.findByUserIdAndLocationId(userId,locationId);
        UserLocationMappingDto responseUserLocationMappingDto = objectTranslator
                .translate(userLocationMapping, UserLocationMappingDto.class);
        userLocationRepository.deleteByUserIdAndLocationId(userId, locationId);
        return responseUserLocationMappingDto;
    }
}
