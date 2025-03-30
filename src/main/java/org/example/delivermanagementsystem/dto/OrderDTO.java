package org.example.delivermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    @NotBlank(message = "Order ID cannot be blank")
    private String orderId;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 5, max = 255, message = "Description must be between 5 and 255 characters")
    private String description;

    @NotBlank(message = "Order status cannot be blank")
    @Pattern(regexp = "PENDING|PROCESSING|COMPLETED|CANCELLED", message = "Invalid order status")
    private String orderStatus;

    @NotNull(message = "Date cannot be null")
    @PastOrPresent(message = "Order date cannot be in the future")
    private Date date;

    @Positive(message = "Amount must be positive")
    private double amount;
}
