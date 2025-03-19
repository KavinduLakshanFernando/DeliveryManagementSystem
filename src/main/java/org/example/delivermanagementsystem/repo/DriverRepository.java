package org.example.delivermanagementsystem.repo;

import org.example.delivermanagementsystem.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByLicencenumber(String licencenumber);
}
