package org.example.delivermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private long driverId;
    private String licencenumber;
    private String expirydate;
    private String licenceimg;
    private String status;
}
