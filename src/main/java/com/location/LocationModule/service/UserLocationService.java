package com.location.LocationModule.service;

import com.location.LocationModule.dao.UserLocationDao;
import com.location.LocationModule.repository.UserLocationRepository;
import com.location.LocationModule.response.UserDto;
import com.location.LocationModule.response.UserLocationMappingDto;
import com.location.LocationModule.translator.ObjectTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLocationService {
@Autowired
UserLocationRepository userLocationRepository;

    @Autowired
    ObjectTranslator objectTranslator;
    @Autowired
    UserLocationDao userLocationDao;

public UserLocationMappingDto assignUser(int userId, int locationId){
    UserLocationMappingDto userLocationMappingDto = new UserLocationMappingDto();
    userLocationMappingDto.setLocationId(locationId);
    userLocationMappingDto.setUserId(userId);
    return userLocationDao.save(userLocationMappingDto);
}

    public List<UserDto> assignedUserList(int locationId) {
        return userLocationDao.assignedUserList(locationId);
    }

    public UserLocationMappingDto unAssignUser(int userId, int locationId) {
         return userLocationDao.deleteByUserIdAndLocationId(userId,locationId);
    }
}

