package com.location.LocationModule.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationDto {
    private Integer id;

    private String loc_name;

    private String loc_code;




}
