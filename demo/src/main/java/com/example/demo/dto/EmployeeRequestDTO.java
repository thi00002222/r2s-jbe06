package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeRequestDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate; // Use String to simplify date handling in DTO
    private Integer supervisorId; // Use Integer to represent the supervisor's employeeId
}
