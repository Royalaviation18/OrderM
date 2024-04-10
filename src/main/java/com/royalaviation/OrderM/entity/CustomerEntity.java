package com.royalaviation.OrderM.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
}
