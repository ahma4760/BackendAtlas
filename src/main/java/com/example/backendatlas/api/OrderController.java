package com.example.backendatlas.api;

import com.example.backendatlas.dto.OrdersConverter;
import com.example.backendatlas.dto.OrdersDTO;
import com.example.backendatlas.entity.Orders;
import com.example.backendatlas.repository.OrdersRepository;
import com.example.backendatlas.service.OrderService;
import jakarta.persistence.criteria.Order;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    OrdersRepository ordersRepository;
    OrderService orderService;
    OrdersConverter ordersConverter;

    @Autowired
    public OrderController(OrdersRepository ordersRepository, OrderService orderService, OrdersConverter ordersConverter) {
        this.ordersRepository = ordersRepository;
        this.orderService = orderService;
        this.ordersConverter = ordersConverter;
    }

    @PostMapping("/order")
    public ResponseEntity<Orders> insertOrder(@RequestBody OrdersDTO ordersDTO) {
        Orders createdOrder = orderService.CreateOrder(ordersConverter.toEntity(ordersDTO));
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable("id") Long id) {
        Optional<Orders> result = ordersRepository.findById(id);
        if(result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }
    }

    @GetMapping("/order_active")
    public ResponseEntity<List<Orders>> getActiveOrders() {
        Optional<List<Orders>> result = ordersRepository.findByIsActiveTrue();
        if(result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }
    }

}
