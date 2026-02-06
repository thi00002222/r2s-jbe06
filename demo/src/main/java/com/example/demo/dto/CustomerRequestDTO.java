package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerRequestDTO {
    @NotNull(message = "Customer ID cannot be null")
    private Integer customerId;

    @NotBlank(message = "Customer Name cannot be null")
    private String customerName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;

}
