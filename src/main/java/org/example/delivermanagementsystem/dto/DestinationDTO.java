package org.example.delivermanagementsystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DestinationDTO {

    @NotNull(message = "Distance ID cannot be null")
    private long distanceId;

    @NotNull(message = "Delivery address cannot be null")
    @Size(min = 5, max = 255, message = "Delivery address must be between 5 and 255 characters")
    private String deliveryAddress;

    @NotNull(message = "Pickup point cannot be null")
    @Size(min = 5, max = 255, message = "Pickup point must be between 5 and 255 characters")
    private String pickupPoint;

    @NotNull(message = "Distance cannot be null")
    @Min(value = 0, message = "Distance must be greater than or equal to 0")
    @Max(value = 1000, message = "Distance must be less than or equal to 1000")
    private Double distance;
}

