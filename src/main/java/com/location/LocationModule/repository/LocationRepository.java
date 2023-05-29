package com.location.LocationModule.repository;

import com.location.LocationModule.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public  interface LocationRepository extends JpaRepository<LocationEntity,Integer> {
    @Modifying
    @Query("update LocationEntity l set l.locCode = :code, l.locName = :name where l.id = :id")
    void updateLocation(@Param(value = "id") Integer id, @Param(value = "code") String code,
                                  @Param(value = "name") String name);

}
