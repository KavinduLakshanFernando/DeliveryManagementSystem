package org.example.delivermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long driverId;
    private String licencenumber;
    private String expirydate;
    private String licenceimg;
    private String status;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicle;

    public Driver(String licencenumber, String expirydate, String licenceimg, String status, User user) {
        this.licencenumber = licencenumber;
        this.expirydate = expirydate;
        this.licenceimg = licenceimg;
        this.status = status;
        this.user = user;
    }
    @OneToMany(mappedBy = "driver")
    private List<Request> requests;
}
