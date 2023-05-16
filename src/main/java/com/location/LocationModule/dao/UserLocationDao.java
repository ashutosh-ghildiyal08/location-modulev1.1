package com.location.LocationModule.dao;

import com.location.LocationModule.repository.UserLocationRepository;
import com.location.LocationModule.response.UserLocationMappingDto;
import com.location.LocationModule.translator.ObjectTranslator;
import com.location.LocationModule.entity.UserLocationMappingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLocationDao {

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
}
