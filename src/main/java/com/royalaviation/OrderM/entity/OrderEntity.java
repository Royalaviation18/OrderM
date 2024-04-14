package com.royalaviation.OrderM.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalAmount;
    private String totalQuantity;
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name="companyId")
    private CompanyEntity companyEntity;

    @ManyToOne
    @JoinColumn(name="customerId")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name="itemId")
    private ItemEntity itemEntity;
}
