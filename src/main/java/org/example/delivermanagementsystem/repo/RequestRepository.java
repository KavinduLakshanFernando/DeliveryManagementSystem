package org.example.delivermanagementsystem.repo;

import org.example.delivermanagementsystem.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
