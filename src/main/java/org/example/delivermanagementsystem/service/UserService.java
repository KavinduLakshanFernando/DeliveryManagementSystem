package org.example.delivermanagementsystem.service;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.UserDTO;

public interface UserService {
    int saveUser( UserDTO userDTO);
}
