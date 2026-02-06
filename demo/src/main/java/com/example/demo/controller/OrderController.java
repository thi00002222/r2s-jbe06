package com.example.demo.controller;

import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    //    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ORDER_CREATE')")
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(request));
    }

    //    @PreAuthorize("hasRole('ADMIN','USER')")
    @PreAuthorize("hasAuthority('ORDER_VIEW')")
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    //    @PreAuthorize("hasRole('ADMIN')")
//@PreAuthorize("hasAuthority('ORDER_VIEW')")
    @PreAuthorize("hasAuthority('ORDER_ADMIN_VIEW')")
    @GetMapping("/by_id/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ORDER_ADMIN_VIEW')")
    @GetMapping("/by_employee/{employeeId}")
    public ResponseEntity<OrderResponseDTO> getOrderByEmployeeId(@PathVariable Integer employeeId) {
        return ResponseEntity.ok((OrderResponseDTO) orderService.getByEmployee(employeeId));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ORDER_ADMIN_VIEW')")
    @GetMapping("/between_dates")
    public ResponseEntity<OrderResponseDTO> getOrdersBetweenDates(@RequestParam String startDate, @RequestParam String endDate) {
        return ResponseEntity.ok((OrderResponseDTO) orderService.getBetweenDates(java.time.LocalDate.parse(startDate), java.time.LocalDate.parse(endDate)));
    }

    //    @PreAuthorize("hasRole('ADMIN','USER')")
    @PreAuthorize("hasAuthority('ORDER_UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Integer id, @Valid @RequestBody OrderRequestDTO request) {
        return ResponseEntity.ok(orderService.update(id, request));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ORDER_DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
