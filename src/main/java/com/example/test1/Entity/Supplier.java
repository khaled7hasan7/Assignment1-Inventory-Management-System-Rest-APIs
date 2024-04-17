package com.example.test1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sname", nullable = false)
    private String name;

    @Column(name = "sphone", nullable = false)
    private String phone;

    @Column(name = "scity", nullable = false)
    private String city;

    @Column(name = "semail")
    private String email;

    @Column(name = "description", nullable = false)
    private String description;

    // Constructors, getters, and setters
}