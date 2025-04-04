package org.example.delivermanagementsystem.service;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.WrapperDTO;

public interface DriverService {
    int saveDriver(WrapperDTO wrapperDTO);
}
