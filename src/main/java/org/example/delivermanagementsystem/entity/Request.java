package org.example.delivermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reqId;
    private String status;

    @ManyToOne
    private Driver driver;

    public Request(String status, Driver driver) {
        this.status = status;
        this.driver = driver;
    }
}
