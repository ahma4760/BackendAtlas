package com.example.backendatlas.service;

import com.example.backendatlas.entity.Orders;
import com.example.backendatlas.repository.OrdersRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrdersRepository orderRepository;

    @Autowired
    public OrderService(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders CreateOrder(Orders order) {
        order.setId(0);
        orderRepository.save(order);
        return order;
    }
}
