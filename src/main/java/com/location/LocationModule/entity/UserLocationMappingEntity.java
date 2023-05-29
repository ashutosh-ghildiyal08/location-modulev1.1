package com.location.LocationModule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location_user_mapping")
public class UserLocationMappingEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_Id", nullable = false, unique = true)
    private int userId;

    @Column(name = "location_Id", nullable = false, unique = true)
    private int locationId;


}
