package com.location.LocationModule.controller;


import com.location.LocationModule.request.AddLocationRequest;
import com.location.LocationModule.request.UpdateLocationRequest;
import com.location.LocationModule.response.LocationDto;
import com.location.LocationModule.response.LocationResponse;
import com.location.LocationModule.response.UserLocationMappingDto;
import com.location.LocationModule.service.LocationService;
import com.location.LocationModule.service.UserLocationService;
import com.location.LocationModule.translator.ObjectTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    UserLocationService userLocationService;

    @Autowired
    ObjectTranslator objectTranslator;

    @GetMapping("/location")
    public ResponseEntity<List<LocationResponse>> getAllLocation() {
        List<LocationDto> locations = locationService.getAllLocation();
        List<LocationResponse> locationsResponses = new ArrayList<>();
        for (LocationDto location : locations) {
            LocationResponse locationResponse = objectTranslator.translate(location, LocationResponse.class);
            locationsResponses.add(locationResponse);
        }
        return new ResponseEntity<>(locationsResponses, HttpStatus.OK);
    }
    @GetMapping("/location/{locationId}")
    public ResponseEntity<LocationResponse> getSingleLocation (@PathVariable int locationId) {
        LocationDto responseLocationDto = locationService.getSingleLocation(locationId);
        LocationResponse locationResponse = objectTranslator.translate(responseLocationDto, LocationResponse.class);
        return new ResponseEntity<>(locationResponse, HttpStatus.OK);
    }
    @PostMapping("/location")
    public ResponseEntity<LocationResponse>  addLocation( @RequestBody AddLocationRequest addLocationRequest) {
        LocationDto locationDto = objectTranslator.translate(addLocationRequest, LocationDto.class);
        LocationDto responseLocationDto = locationService.addLocation(locationDto);
        LocationResponse locationResponse = objectTranslator.translate(responseLocationDto, LocationResponse.class);
        return new ResponseEntity<>(locationResponse, HttpStatus.CREATED);


    }

    @DeleteMapping("/location/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable int locationId) {

        locationService.deleteLocation(locationId);

        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }

    @PutMapping("/location")
    public ResponseEntity<LocationResponse> updateLocation(@RequestBody UpdateLocationRequest updateLocationRequest) {
        LocationDto locationDto = objectTranslator.translate(updateLocationRequest, LocationDto.class);
        LocationDto responseLocationDto = locationService.updateLocation(locationDto);
        LocationResponse locationResponse = objectTranslator.translate(responseLocationDto, LocationResponse.class);
        return new ResponseEntity<>(locationResponse, HttpStatus.CREATED);
    }


    @PostMapping("/location/{userId}/{locationId}")
    public ResponseEntity<UserLocationMappingDto> assignUser(@PathVariable int userId, @PathVariable int locationId ){
        UserLocationMappingDto userLocationMappingDto = userLocationService.assignUser(userId,locationId);
       return new ResponseEntity<>(userLocationMappingDto, HttpStatus.CREATED);
    }




}

