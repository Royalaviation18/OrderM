package com.royalaviation.OrderM.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
}
