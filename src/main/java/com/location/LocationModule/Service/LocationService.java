package com.location.LocationModule.Service;


import com.location.LocationModule.Dao.LocationDao;
import com.location.LocationModule.Repository.LocationRepository;
import com.location.LocationModule.Response.LocationDto;
import com.location.LocationModule.Translator.ObjectTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService {
    @Autowired
    ObjectTranslator objectTranslator;
    @Autowired
    LocationDao locationDao;
    @Autowired
    LocationRepository locationRepository;
    public List<LocationDto> getAllLocation() {
        return locationDao.getAllLocation();
    }

    public LocationDto getSingleLocation(int locationId){

        return locationDao.getSingleLocation(locationId);
    }


    public LocationDto addLocation(LocationDto locationDto)
    {

        LocationDto responseLocationDto = locationDao.addLocation(locationDto);
        return responseLocationDto;

    }
    public void deleteLocation(int locationId) {
        locationDao.deleteLocation(locationId);
    }


    public LocationDto updateLocation(LocationDto locationDto) {
        LocationDto responseLocationDto = locationDao.updateLocation(locationDto);
        return responseLocationDto;
    }



}

