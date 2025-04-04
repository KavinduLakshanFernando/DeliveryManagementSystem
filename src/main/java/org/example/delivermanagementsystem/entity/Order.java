//package org.example.delivermanagementsystem.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.JdbcTypeCode;
//import org.hibernate.type.SqlTypes;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column( columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
//    private UUID orderId;
//
//    private String description;
//
//    private String orderStatus;
//
//    private Date date;
//
//    private double amount;
//    @ManyToOne
//    private Destination destination;
//
//    @ManyToOne
//    private User user;
//
////    @ManyToOne
////    private Vehicle vehicle;
//}
