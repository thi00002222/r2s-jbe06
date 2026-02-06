package com.example.demo.service;

import com.example.demo.dto.CustomerResponseDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO create(CustomerResponseDTO request) throws BadRequestException;

    CustomerResponseDTO update(Integer id, CustomerResponseDTO request);

    void delete(Integer id);

    CustomerResponseDTO getById(Integer id);

    List<CustomerResponseDTO> getAllCustomers();

    List<CustomerResponseDTO> getCustomersByName(String city);
}
