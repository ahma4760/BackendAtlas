package com.example.backendatlas.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrdersDTO(int id, List<Long> productIds, Long userId, boolean isActive, boolean isAccepted, LocalDateTime time) {
}
