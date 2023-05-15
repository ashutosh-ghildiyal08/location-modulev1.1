package com.location.LocationModule.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class LocationEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loc_name", nullable = false)
    private String loc_name;

    @Column(name = "loc_code", nullable = false)
    private String loc_code;

    @ManyToMany(cascade =
            {
//                    CascadeType.DETACH,
//                    CascadeType.MERGE,
//                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch= FetchType.EAGER)

    @JoinTable(name = "location_user_mapping",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> userList;

}
