package com.example.backendatlas.dto;

import com.example.backendatlas.entity.Orders;
import com.example.backendatlas.entity.Product;
import com.example.backendatlas.entity.User;
import com.example.backendatlas.repository.ProductRepository;
import com.example.backendatlas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersConverter {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    public OrdersDTO toDTO(Orders order) {
        List<Long> productIds = new ArrayList<>();
        List<Product> products = order.getProducts();
        for(Product p : products) {
            productIds.add(Long.valueOf(p.getId()));
        }
        return new OrdersDTO(
                order.getId(),
                productIds,
                order.getUser().getId(),
                order.isActive(),
                order.isAccepted(),
                order.getTime()
        );
    }

    public Orders toEntity(OrdersDTO ordersDTO) {
        User user = userRepository.findById(ordersDTO.userId()).get();
        List<Product> products = new ArrayList<>();
        for(Long id : ordersDTO.productIds()) {
            products.add(productRepository.findById(id).get());
        }

        return new Orders(
                ordersDTO.id(),
                products,
                user,
                ordersDTO.isAccepted(),
                ordersDTO.isActive(),
                ordersDTO.time()
        );
    }
}
