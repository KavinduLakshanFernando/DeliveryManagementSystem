package org.example.delivermanagementsystem.repo;

import org.example.delivermanagementsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
