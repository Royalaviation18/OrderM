package com.royalaviation.OrderM.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private String totalAmount;
    private String totalQuantity;
    private Date orderDate;
    private CompanyEntity companyEntity;
    private CustomerEntity customerEntity;
    private ItemEntity itemEntity;

}
