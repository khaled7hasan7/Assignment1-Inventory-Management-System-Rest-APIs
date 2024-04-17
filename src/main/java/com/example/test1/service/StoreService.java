package com.example.test1.service;

import com.example.test1.Entity.Store;
import com.example.test1.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {






    private StoreRepository storeRepository;



    @Autowired
    public StoreService(StoreRepository storeRepository) {

        this.storeRepository = storeRepository;

    }



    public List<Store> getAllStores() {
        return storeRepository.findAll();

    }

    public Optional<Store> getStoresById(String id) {
        return storeRepository.findById(id);
    }



    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public Store updateStore(Store store) {
        return storeRepository.save(store);
    }

    public String deleteStore(String id) {

        if (storeRepository.existsById(id)) {
            storeRepository.deleteById(id);
            return "store deleted => id = " +id;
        }
        else {
            return "Store not found";
        }

    }



}
