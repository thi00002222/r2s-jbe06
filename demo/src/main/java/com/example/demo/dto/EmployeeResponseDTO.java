package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Integer employeeId;
    private String fullName; // Combine firstName and lastName
    private LocalDate birthDate; // Use String to simplify date handling in DTO
    private Integer supervisorId; // Use Integer to represent the supervisor's employeeId
}
