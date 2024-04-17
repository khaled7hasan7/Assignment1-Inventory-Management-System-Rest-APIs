package com.example.test1.service;

import com.example.test1.Entity.Supplier;
import com.example.test1.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;




@Service
public class SupplierService {


    private SupplierRepository supplierRepository;



    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {

        this.supplierRepository = supplierRepository;

    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();

    }


    public Optional<Supplier> getSuppliersById(int id) {
        return supplierRepository.findById(id);
    }



    public Supplier createSupplier(Supplier  supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public String deleteSupplier(int id) {

        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
            return "Supplier deleted  ==> id = " +id;
        }
        else {
            return "Supplier not found";
        }

    }



}