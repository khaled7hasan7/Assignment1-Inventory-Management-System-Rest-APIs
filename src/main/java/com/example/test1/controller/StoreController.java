package com.example.test1.controller;


import com.example.test1.Entity.Store;
import com.example.test1.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
@RestController
public class StoreController {

    @Autowired
      private StoreService storeService ;



    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllstores() {
        List<Store> store = storeService.getAllStores();
        return new ResponseEntity<>(store, HttpStatus.OK);

    }

    @PostMapping(value="/stores")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store createdstore = storeService.createStore(store);
        return new ResponseEntity<>(createdstore, HttpStatus.CREATED);
    }

    @GetMapping(value ="/stores/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable String id) {
        Optional<Store> store = storeService.getStoresById(id);
        return store.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PutMapping("/stores/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable String id, @RequestBody Store store) {
        Optional<Store> StoreOptional = storeService.getStoresById(id);

        if (StoreOptional.isPresent()) {
            Store existingStore = StoreOptional.get();

            existingStore.setDescription(store.getDescription());
            existingStore.setLocation(store.getLocation());
            Store updatedStore = storeService.updateStore(existingStore);
            return new ResponseEntity<>(updatedStore, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PatchMapping("/stores/{id}")
    public ResponseEntity<Store> patchProduct(@PathVariable String id, @RequestBody Store store) {
        Optional<Store> ProductOptional = storeService.getStoresById(id);

        if (ProductOptional.isPresent()) {
            Store existingStore = ProductOptional.get();


            if (store.getDescription() != null) {
                existingStore.setDescription(store.getDescription());
            }

            if (store.getLocation() != null) {
                existingStore.setLocation(store.getLocation());
            }


            Store updatedStore = storeService.updateStore(existingStore);
            return new ResponseEntity<>(updatedStore, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/stores/{id}")
    public ResponseEntity<String> deleteStore(@PathVariable String id) {
        String deleted = storeService.deleteStore(id);

        if (deleted.equals("Store not found")) {
            return new ResponseEntity<>(deleted,HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(deleted,HttpStatus.NO_CONTENT);
        }
    }





}
