package com.example.test1.service;

import com.example.test1.Entity.Product;
import com.example.test1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {


    private ProductRepository productRepository;



    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

    public List <Product> getAllProducts() {
        return productRepository.findAll();

    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }



    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public String deleteProduct(String id) {

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted  ==> id = " +id;
        }
        else {
            return "Product not found";
        }

    }



}