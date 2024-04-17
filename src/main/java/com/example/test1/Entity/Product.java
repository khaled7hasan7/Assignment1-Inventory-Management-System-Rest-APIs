package com.example.test1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private String id;

    @Column(name = "pname")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "categoryid")
    private Long categoryId;

    @Column(name = "purchasing_price")
    private double purchasingPrice;

    @Column(name = "selling_price")
    private double sellingPrice;


}




