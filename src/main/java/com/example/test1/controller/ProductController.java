package com.example.test1.controller;


import com.example.test1.Entity.Product;
import com.example.test1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RestController
public class ProductController {


    @Autowired
    private ProductService productService;




    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



    @GetMapping(value ="/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




    @PostMapping(value="/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }



    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> existingProductOptional = productService.getProductById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategoryId(product.getCategoryId());
            existingProduct.setPurchasingPrice(product.getPurchasingPrice());
            existingProduct.setSellingPrice(product.getSellingPrice());

            Product updatedProduct = productService.updateProduct(existingProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PatchMapping("/products/{id}")
    public ResponseEntity<Product> patchProduct(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> existingProductOptional = productService.getProductById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            if (product.getName() != null) {
                existingProduct.setName(product.getName());
            }
            if (product.getDescription() != null) {
                existingProduct.setDescription(product.getDescription());
            }
            if (product.getCategoryId() != null) {
                existingProduct.setCategoryId(product.getCategoryId());
            }
            if (product.getPurchasingPrice() != 0) {
                existingProduct.setPurchasingPrice(product.getPurchasingPrice());
            }
            if (product.getSellingPrice() != 0) {
                existingProduct.setSellingPrice(product.getSellingPrice());
            }

            Product updatedProduct = productService.updateProduct(existingProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        String deleted = productService.deleteProduct(id);

        if (deleted.equals("Product not found")) {
            return new ResponseEntity<>(deleted,HttpStatus.NOT_FOUND);

        } else {
             return new ResponseEntity<>(deleted,HttpStatus.NO_CONTENT);
        }
    }







}
