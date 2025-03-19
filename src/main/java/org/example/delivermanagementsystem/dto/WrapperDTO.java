package org.example.delivermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.delivermanagementsystem.entity.Driver;
import org.example.delivermanagementsystem.entity.Vehicle;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WrapperDTO {
    private String email;
    private DriverDTO driver;
    private VehicleDTO vehicle;
}
