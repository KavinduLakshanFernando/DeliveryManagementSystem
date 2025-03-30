package org.example.delivermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long distanceId;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private String pickupPoint;

    @Column(nullable = false)
    private Double distance;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders;

}
