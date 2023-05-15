package com.location.LocationModule.Dao;

import com.location.LocationModule.Repository.UserLocationRepository;
import com.location.LocationModule.entity.UserLocationMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLocationDao {

    @Autowired
    UserLocationRepository userLocationRepository;



    public void save(UserLocationMapping userLocationMapping) {
        userLocationRepository.save(userLocationMapping);

    }
}
