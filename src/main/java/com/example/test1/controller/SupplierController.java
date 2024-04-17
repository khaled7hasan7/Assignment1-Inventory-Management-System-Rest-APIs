package com.example.test1.controller;


import com.example.test1.Entity.Supplier;
import com.example.test1.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@Controller
@RestController
public class SupplierController {



    @Autowired
    private SupplierService supplierService;




    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> supplier = supplierService.getAllSuppliers();
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }



    @GetMapping(value ="/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
        Optional<Supplier> supplier = supplierService.getSuppliersById(id);
        return supplier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




    @PostMapping(value="/suppliers")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier createdSupplier = supplierService.createSupplier(supplier);
        return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
    }



    @PutMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
        Optional<Supplier> existingSupplierOptional = supplierService.getSuppliersById(id);

        if (existingSupplierOptional.isPresent()) {

            Supplier existingSupplier = existingSupplierOptional.get();
            existingSupplier.setName(supplier.getName());
            existingSupplier.setPhone(supplier.getPhone());
            existingSupplier.setCity(supplier.getCity());
            existingSupplier.setEmail(supplier.getEmail());
            existingSupplier.setDescription(supplier.getDescription());

            Supplier updatedSupplier = supplierService.updateSupplier(existingSupplier);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PatchMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> patchSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
        Optional<Supplier> existingSupplierOptional = supplierService.getSuppliersById(id);

        if (existingSupplierOptional.isPresent()) {
            Supplier existingSupplier = existingSupplierOptional.get();

            if (supplier.getName() != null) {
                existingSupplier.setName(supplier.getName());
            }
            if (supplier.getDescription() != null) {
                existingSupplier.setDescription(supplier.getDescription());
            }
            if (supplier.getCity() != null) {
                existingSupplier.setCity(supplier.getCity());
            }
            if (supplier.getEmail() !=null) {
                existingSupplier.setEmail(supplier.getEmail());
            }
            if (supplier.getPhone() != null) {
                existingSupplier.setPhone(supplier.getPhone());
            }

            Supplier updatedSupplier = supplierService.updateSupplier(existingSupplier);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("suppliers/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable int id) {
        String deleted = supplierService.deleteSupplier(id);

        if (deleted.equals("Supplier not found")) {
            return new ResponseEntity<>(deleted,HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(deleted,HttpStatus.NO_CONTENT);
        }
    }


}
