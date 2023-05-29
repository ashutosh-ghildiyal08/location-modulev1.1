package com.location.LocationModule.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLocationMappingDto {
    private int id;
    private int userId;
    private int locationId;
}
