package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    private Integer customerId;

    @Column(nullable = false)
    private String customerName;

    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
}
