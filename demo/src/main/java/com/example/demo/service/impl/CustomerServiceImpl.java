package com.example.demo.service.impl;

import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

//    CREATE
    @Override
    public CustomerResponseDTO create(CustomerResponseDTO request) throws BadRequestException {


        if (repository.existsById(request.getCustomerId())) {
            throw new BadRequestException("Customer ID already exists.");
        }

        Customer customer = mapToEntity(request);
        return mapToResponse(repository.save(customer));
    }

//  UPDATE
    @Override
    public CustomerResponseDTO update(Integer id, CustomerResponseDTO request) {
        Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setCustomerName(request.getCustomerName());
        customer.setContactName(request.getContactName());
        customer.setCity(request.getCity());
        customer.setAddress(request.getAddress());
        customer.setCountry(request.getCountry());
        customer.setPostalCode(request.getPostalCode());
        return mapToResponse(repository.save(customer));
    }

    @Override
    public void delete(Integer id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Customer not found");
        }
        repository.deleteById(id);

    }

    @Override
    public CustomerResponseDTO getById(Integer id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToResponse(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<CustomerResponseDTO> getCustomersByName(String name) {
        List<Customer> customers = repository.findByCustomerNameContainingIgnoreCase(name);
        return customers.stream().map(this::mapToResponse).toList();
    }

//    sup function to map DTO to Entity and vice versa
    private Customer mapToEntity(CustomerResponseDTO request) {
        Customer customer = new Customer();
        customer.setCustomerId(request.getCustomerId());
        customer.setCustomerName(request.getCustomerName());
        customer.setContactName(request.getContactName());
        customer.setAddress(request.getAddress());
        customer.setCountry(request.getCountry());
        customer.setCity(request.getCity());
        customer.setPostalCode(request.getPostalCode());
        return customer;
    }

    private CustomerResponseDTO mapToResponse(Customer customer) {
        CustomerResponseDTO response = new CustomerResponseDTO();
        response.setCustomerId(customer.getCustomerId());
        response.setCustomerName(customer.getCustomerName());
        response.setContactName(customer.getContactName());
        response.setAddress(customer.getAddress());
        response.setCountry(customer.getCountry());
        response.setCity(customer.getCity());
        response.setPostalCode(customer.getPostalCode());
        return response;
    }
}
