package org.example.delivermanagementsystem.service;

import org.example.delivermanagementsystem.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    int saveOrder(OrderDTO orderdto);
    int updateOrder(OrderDTO orderdto);
}
