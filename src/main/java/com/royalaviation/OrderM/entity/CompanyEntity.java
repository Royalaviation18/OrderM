package com.royalaviation.OrderM.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name="company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
}
