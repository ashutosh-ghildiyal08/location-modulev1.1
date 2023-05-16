package com.location.LocationModule.service;

import com.location.LocationModule.dao.UserLocationDao;
import com.location.LocationModule.repository.UserLocationRepository;
import com.location.LocationModule.response.UserLocationMappingDto;
import com.location.LocationModule.translator.ObjectTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    userLocationMappingDto.setLocation_Id(locationId);
    userLocationMappingDto.setUser_Id(userId);
    return userLocationDao.save(userLocationMappingDto);
}

}

