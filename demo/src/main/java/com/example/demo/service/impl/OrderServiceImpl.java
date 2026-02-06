package com.example.demo.service.impl;


import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Order;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository OrderRepository;
    private final CustomerRepository CustomerRepository;
    private final EmployeeRepository EmployeeRepository;

//    CREATE
    @Override
    public OrderResponseDTO create(OrderRequestDTO request) {
        Customer customer = CustomerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Employee employee = EmployeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Order order = new Order();
        order.setOrderDate(request.getOrderDate());
        order.setCustomer(customer);
        order.setEmployee(employee);
        return map(OrderRepository.save(order));
    }

    @Override
    public OrderResponseDTO update(Integer id, OrderRequestDTO request) {
        Order order = OrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        Customer customer = CustomerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Employee employee = EmployeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        order.setCustomer(customer);
        order.setEmployee(employee);
        order.setOrderDate(request.getOrderDate());

        return map(OrderRepository.save(order));
    }


    @Override
    public void delete(Integer id) {
        Order order = OrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        OrderRepository.delete(order);
    }

    @Override
    public OrderResponseDTO getById(Integer id) {
        Order order = OrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return map(order);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {

        return OrderRepository.findAll().stream().map(this::map).toList();
    }

    @Override
    public List<OrderResponseDTO> getByEmployee(Integer employeeId) {
        return OrderRepository.findOrdersByEmployeeWithDetails(employeeId).stream().map(this::map).toList();
    }

    @Override
    public List<OrderResponseDTO> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        return OrderRepository.findOrdersWithDetailsBetween(startDate, endDate).stream().map(this::map).toList();
    }

    private OrderResponseDTO map(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getOrderId());
        dto.setOrderDate(order.getOrderDate());
        dto.setCustomerId(order.getCustomer().getCustomerId());
        dto.setEmployeeId(order.getEmployee().getEmployeeId());
        return dto;
    }
}
