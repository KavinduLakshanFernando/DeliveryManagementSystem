package org.example.delivermanagementsystem.service;


import org.example.delivermanagementsystem.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}