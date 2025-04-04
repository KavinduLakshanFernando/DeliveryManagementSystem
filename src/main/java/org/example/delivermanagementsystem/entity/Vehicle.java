package org.example.delivermanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleId;
    private String vehicleModel;
    private String vehicleyear;
    private String vehicleNumber;
    private String InshuarnceCompany;
    private String vehicleimg;
    private String status;

    @ManyToOne
    private Driver driver;

    public Vehicle( String vehicleModel, String vehicleyear, String vehicleNumber, String inshuarnceCompany, String vehicleimg, String status, Driver driver) {
        this.vehicleModel = vehicleModel;
        this.vehicleyear = vehicleyear;
        this.vehicleNumber = vehicleNumber;
        InshuarnceCompany = inshuarnceCompany;
        this.vehicleimg = vehicleimg;
        this.status = status;
        this.driver = driver;
    }

//    @OneToMany
//    private List<Order> orders;
}

