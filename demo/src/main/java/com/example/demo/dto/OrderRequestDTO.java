package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderRequestDTO {
    @JsonFormat(timezone = "yyyy-mm-dd")
    private LocalDate orderDate;
    @NotNull (message = "Customer ID cannot be null")
    private Integer customerId;
    @NotNull (message = "Employee ID cannot be null")
    private Integer employeeId;
}
