package com.location.LocationModule.Service;

import com.location.LocationModule.Dao.LocationDao;
import com.location.LocationModule.Dao.UserLocationDao;
import com.location.LocationModule.Repository.UserLocationRepository;
import com.location.LocationModule.Response.LocationDto;
import com.location.LocationModule.Translator.ObjectTranslator;
import com.location.LocationModule.entity.UserLocationMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLocationService {
@Autowired
UserLocationRepository userLocationRepository;

    @Autowired
    ObjectTranslator objectTranslator;
    @Autowired
    static
    UserLocationDao userLocationDao;

//    public void assigningUser(int userId, int locationId) {
//        UserLocationMapping userLocationMapping = new UserLocationMapping();
//        userLocationMapping.setLocation_Id(locationId);
//        userLocationMapping.setUser_Id(userId);
//       userLocationRepository.save(userLocationMapping);
//
//    }
public void assignUser(int userId, int locationId){
    UserLocationMapping userLocationMapping = new UserLocationMapping();
       userLocationMapping.setLocation_Id(locationId);
     userLocationMapping.setUser_Id(userId);
    userLocationDao.save(userLocationMapping);
}

}

