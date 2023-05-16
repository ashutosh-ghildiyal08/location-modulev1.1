package com.location.LocationModule.repository;

import com.location.LocationModule.entity.UserLocationMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocationMappingEntity, Integer> {
//    List<Object> findById(int userId, int locationId);

//    void findById(int userId, int locationId);

}
