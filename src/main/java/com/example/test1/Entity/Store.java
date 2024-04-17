package com.example.test1.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "storeid",length = 5)
    private String storeId;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "description", length = 555)
    private String description;


}