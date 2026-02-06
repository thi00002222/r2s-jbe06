package com.example.demo.service;


import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface OrderService {
    OrderResponseDTO create(OrderRequestDTO request);
    OrderResponseDTO update(Integer id, OrderRequestDTO request);
    void delete(Integer id);
    OrderResponseDTO getById(Integer id);
    List<OrderResponseDTO> getAllOrders();
    List<OrderResponseDTO> getByEmployee(Integer customerId);
    List<OrderResponseDTO> getBetweenDates(LocalDate startDate, LocalDate endDate);

}
