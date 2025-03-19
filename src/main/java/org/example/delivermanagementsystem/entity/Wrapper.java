package org.example.delivermanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wrapper {
    private String email;
    private Driver driver;
    private Vehicle vehicle;
}
