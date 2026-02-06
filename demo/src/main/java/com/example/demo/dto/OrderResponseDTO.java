package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderResponseDTO {
    private Integer orderId;
    private LocalDate orderDate;
    private Integer customerId;
    private Integer employeeId;
}
