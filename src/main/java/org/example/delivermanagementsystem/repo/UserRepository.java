package org.example.delivermanagementsystem.repo;

import org.example.delivermanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    boolean existsByEmail(String userName);

    int deleteByEmail(String userName);

}