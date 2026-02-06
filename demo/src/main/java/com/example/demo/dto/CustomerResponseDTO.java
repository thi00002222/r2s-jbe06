package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDTO {
    private Integer customerId;
    private String customerName;
    private String contactName;
    private String postalCode;
    private String city;
    private String country;
    private String address;


    public boolean existsById(Integer customerId) {
        return false;
    }



}
