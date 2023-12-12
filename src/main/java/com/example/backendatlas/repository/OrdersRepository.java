package com.example.backendatlas.repository;

import com.example.backendatlas.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Optional<List<Orders>> findByIsActiveTrue();
}
