package com.location.LocationModule.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddLocationRequest {
    private String loc_name;
    private int loc_code;

}
