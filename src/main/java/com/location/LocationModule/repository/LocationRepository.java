package com.location.LocationModule.repository;

import com.location.LocationModule.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface LocationRepository extends JpaRepository<LocationEntity,Integer> {


}