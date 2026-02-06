package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_CustomerId(Integer customerId);

    @Query("SELECT o FROM Order o JOIN FETCH o.employee e JOIN FETCH o.customer c WHERE o.orderDate between :from AND :to")
    List<Order> findOrdersWithDetailsBetween(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query("SELECT o FROM Order o JOIN FETCH o.employee e JOIN FETCH o.customer c WHERE e.employeeId = :employeeId")
    List<Order> findOrdersByEmployeeWithDetails(@Param("employeeId") Integer employeeId);
}
