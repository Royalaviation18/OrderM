package com.royalaviation.OrderM.entity;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

}
