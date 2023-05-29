package com.location.LocationModule.repository;

import com.location.LocationModule.entity.UserLocationMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserLocationRepository extends JpaRepository<UserLocationMappingEntity, Integer> {

    List<UserLocationMappingEntity> findAllByLocationId(int locationId);

    void deleteAllByUserId(int id);
}
