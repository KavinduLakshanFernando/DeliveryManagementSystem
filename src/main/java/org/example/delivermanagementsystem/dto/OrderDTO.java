package org.example.delivermanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.delivermanagementsystem.entity.User;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
    private UUID Oid;

    @NotBlank(message = "OrderType is required")
    private String orderType;

    @NotBlank(message = "VehicleType is required")
    private String vehicleType;

    @NotBlank(message = "Location is required")
    private String location;

    private Date date;

    private User user;
}
