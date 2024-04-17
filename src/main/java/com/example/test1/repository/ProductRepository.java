package com.example.test1.repository;

import com.example.test1.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends  JpaRepository<Product, String>{

}
