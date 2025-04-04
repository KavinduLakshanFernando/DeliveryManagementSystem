package org.example.delivermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WrapperDTO {
    private String email;
    private DriverDTO driver;
    private VehicleDTO vehicle;
}
