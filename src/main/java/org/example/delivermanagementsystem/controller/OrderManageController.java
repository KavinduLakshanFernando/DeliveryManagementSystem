package org.example.delivermanagementsystem.controller;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.OrderDTO;
import org.example.delivermanagementsystem.dto.ResponseDTO;
import org.example.delivermanagementsystem.service.OrderService;
import org.example.delivermanagementsystem.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderManageController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/saveOrder")
    public ResponseEntity<ResponseDTO> saveOrder(@RequestBody @Valid OrderDTO orderdto) {
        System.out.println(orderdto);

        try {
            int res =  orderService.saveOrder(orderdto);
            switch (res){
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created,"Succsess",orderdto));
                }

                case VarList.Conflict -> {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(new ResponseDTO(VarList.Conflict,"Duplicate Entry",orderdto));
                }

                default -> {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }

            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(new ResponseDTO(VarList.Bad_Request,"Order Not Success",e.getMessage()));
        }


    }


}
