package org.example.delivermanagementsystem.repo;

import org.example.delivermanagementsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
