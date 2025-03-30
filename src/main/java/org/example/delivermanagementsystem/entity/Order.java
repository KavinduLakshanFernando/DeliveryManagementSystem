package org.example.delivermanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    private String orderId;

    private String description;

    private String orderStatus;

    private Date date;

    private double amount;
    @ManyToOne
    private Destination destination;

    @ManyToOne
    private User user;

    @ManyToOne
    private Vehicle vehicle;
}
