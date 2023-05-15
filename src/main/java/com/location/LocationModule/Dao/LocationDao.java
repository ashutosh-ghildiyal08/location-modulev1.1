package com.location.LocationModule.Dao;

import com.location.LocationModule.Repository.LocationRepository;
import com.location.LocationModule.Repository.UserLocationRepository;
import com.location.LocationModule.Response.LocationDto;
import com.location.LocationModule.Translator.ObjectTranslator;
import com.location.LocationModule.entity.LocationEntity;
import com.location.LocationModule.entity.UserLocationMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LocationDao {

    @Autowired
    ObjectTranslator objectTranslator;
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserLocationRepository userLocationRepository;

    public List<LocationDto> getAllLocation() {

        List<LocationEntity> locationsEntity = locationRepository.findAll();
        List<LocationDto> locationsDto = new ArrayList<>();
        for (LocationEntity location : locationsEntity) {
            LocationDto locationDto = objectTranslator.translate(location, LocationDto.class);
            locationsDto.add(locationDto);
        }

        return locationsDto;
    }
public LocationDto getSingleLocation(int locationId){
    LocationEntity location = locationRepository.findById(locationId).get();
    LocationDto locationDto = objectTranslator.translate(location, LocationDto.class);
    return locationDto;
}
    public LocationDto addLocation(LocationDto locationDto) {
LocationEntity locationEntity = objectTranslator.translate(locationDto, LocationEntity.class );
        LocationEntity savedLocationEntity = locationRepository.save(locationEntity);

        LocationDto savedLocationDto = objectTranslator.translate(savedLocationEntity, LocationDto.class);
        return savedLocationDto;

    }
    public void deleteLocation(int locationId) {
        locationRepository.deleteById(locationId);
    }
    public LocationDto updateLocation(LocationDto locationDto) {
//        int locationId = locationDto.getId();
        LocationEntity locationEntity= objectTranslator.translate(locationDto, LocationEntity.class);

        LocationEntity updatedLocationEntity = locationRepository.save(locationEntity);

        LocationDto updatedLocationDto = objectTranslator.translate(updatedLocationEntity, LocationDto.class);
        return updatedLocationDto;
//        System.out.println(updatedLocation);
//        return updatedLocation;
    }


}
