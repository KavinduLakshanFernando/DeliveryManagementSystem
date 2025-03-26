package org.example.delivermanagementsystem.service.impl;

import org.example.delivermanagementsystem.dto.OrderDTO;
import org.example.delivermanagementsystem.entity.Order;
import org.example.delivermanagementsystem.repo.OrderRepository;
import org.example.delivermanagementsystem.service.OrderService;
import org.example.delivermanagementsystem.utill.VarList;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

   @Autowired
   private ModelMapper modelMapper;


    @Override
    public int saveOrder(OrderDTO orderdto) {

        if (orderdto.getUser() == null) {
            return VarList.Bad_Request; // Handle this scenario appropriately
        }

        // If OID is not null, check if it already exists
        if (orderdto.getOid() != null && orderRepository.existsById(orderdto.getOid())) {
            return VarList.Not_Found; // If the order already exists, return "Not Found"
        }

        // Save the order (with a non-null user)
        orderRepository.save(modelMapper.map(orderdto, Order.class));
        return VarList.Created;



    }

    @Override
    public int updateOrder(OrderDTO orderdto) {
        if (orderdto.getOid() != null && orderRepository.existsById(orderdto.getOid())) {
            return VarList.Not_Found;
        }
        orderRepository.save(modelMapper.map(orderdto, Order.class));
        return VarList.Created;
    }
}

