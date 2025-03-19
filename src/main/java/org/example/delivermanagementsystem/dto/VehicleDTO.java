package org.example.delivermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    private long vehicleId;
    private String vehicleModel;
    private String vehicleyear;
    private String vehicleNumber;
    private String InshuarnceCompany;
    private String vehicleimg;
    private String status;
}
