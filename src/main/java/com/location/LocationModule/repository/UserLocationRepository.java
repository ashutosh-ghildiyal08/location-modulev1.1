package com.location.LocationModule.repository;

import com.location.LocationModule.entity.UserLocationMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserLocationRepository extends JpaRepository<UserLocationMappingEntity, Integer> {

    List<UserLocationMappingEntity> findAllByLocationId(int locationId);

    void deleteAllByUserId(int id);
    @Modifying
    @Query("delete from UserLocationMappingEntity e where e.userId=:userId and e.locationId=:locationId")
    void deleteByUserIdAndLocationId(@Param(value = "userId") Integer userId,
                                                          @Param(value = "locationId") Integer locationId);


    UserLocationMappingEntity findByUserIdAndLocationId(int userId, int locationId);
}
