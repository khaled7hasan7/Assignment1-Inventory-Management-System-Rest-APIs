package com.example.test1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "store_items")
public class StoreItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pid", nullable = false)
    private String productId;

    @Column(name = "storeid", length = 5, nullable = false)
    private String storeId;

    @Column(name = "TotalQuntity", nullable = false)
    private int totalQuantity;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pid", referencedColumnName = "pid", insertable = false, updatable = false)
//    private Product product;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "storeid", referencedColumnName = "storeid", insertable = false, updatable = false)
//    private Store store;


}