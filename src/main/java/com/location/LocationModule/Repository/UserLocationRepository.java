package com.location.LocationModule.Repository;

import com.location.LocationModule.entity.UserLocationMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocationMapping, Integer> {
//    List<Object> findById(int userId, int locationId);

//    void findById(int userId, int locationId);

}
