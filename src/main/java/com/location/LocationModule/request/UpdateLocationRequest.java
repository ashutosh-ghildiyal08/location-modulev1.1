package com.location.LocationModule.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UpdateLocationRequest {
    private int id;
    private String locName;
    private String locCode;
}
