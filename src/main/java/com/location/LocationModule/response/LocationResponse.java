package com.location.LocationModule.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    private Integer id;

    private String locName;

    private String locCode;

}
