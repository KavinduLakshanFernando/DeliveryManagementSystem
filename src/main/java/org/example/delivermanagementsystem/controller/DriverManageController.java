package org.example.delivermanagementsystem.controller;

import org.example.delivermanagementsystem.dto.ResponseDTO;
import org.example.delivermanagementsystem.dto.WrapperDTO;
import org.example.delivermanagementsystem.service.DriverService;
import org.example.delivermanagementsystem.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverManageController {

    @Autowired
    private DriverService driverService;
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('Driver')")
    public ResponseEntity<ResponseDTO> saveDriver(@RequestBody WrapperDTO wrapperDTO) {
        try {
            int res = driverService.saveDriver(wrapperDTO);
            switch (res) {
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", null));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
