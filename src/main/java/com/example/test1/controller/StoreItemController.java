package com.example.test1.controller;


import com.example.test1.Entity.StoreItem;
import com.example.test1.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;




@Controller
@RestController
public class StoreItemController {


    @Autowired
    private StoreItemService storeItemService;




    @GetMapping(value = "/itemstore")
    public ResponseEntity<List<StoreItem>> getAllStoreItem() {
        List<StoreItem> storeItem = storeItemService.getAllStoreItem();
        return new ResponseEntity<>(storeItem, HttpStatus.OK);
    }



    @GetMapping(value ="/itemstore/{id}")
    public ResponseEntity<StoreItem> getStoreItemById(@PathVariable long id) {
        Optional<StoreItem> storeItem = storeItemService.getStoreItemById(id);
        return storeItem.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




    @PostMapping(value="/itemstore")
    public ResponseEntity<StoreItem> createStoreItem(@RequestBody StoreItem storeItem) {
        StoreItem createdStoreItem = storeItemService.createStoreItem(storeItem);
        return new ResponseEntity<>(createdStoreItem, HttpStatus.CREATED);
    }



    @PutMapping(value ="/itemstore/{id}")
    public ResponseEntity<StoreItem> updateStoreItem(@PathVariable long id, @RequestBody StoreItem storeItem) {
        Optional<StoreItem> existingStoreItemOptional = storeItemService.getStoreItemById(id);

        if (existingStoreItemOptional.isPresent()) {
            StoreItem existingStoreItem = existingStoreItemOptional.get();


            existingStoreItem.setStoreId(storeItem.getStoreId());
            existingStoreItem.setProductId(storeItem.getProductId());
            existingStoreItem.setTotalQuantity(storeItem.getTotalQuantity());

            StoreItem updatedStoreItem = storeItemService.updateStoreItem(existingStoreItem);
            return new ResponseEntity<>(updatedStoreItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PatchMapping(value = "/itemstore/{id}")
    public ResponseEntity<StoreItem> patchStoreItem(@PathVariable long id, @RequestBody StoreItem storeItem) {
        Optional<StoreItem> existingStoreItemOptional = storeItemService.getStoreItemById(id);

        if (existingStoreItemOptional.isPresent()) {
            StoreItem existingStoreItem = existingStoreItemOptional.get();


            if (storeItem.getStoreId() != null) {
                existingStoreItem.setStoreId(storeItem.getStoreId());
            }

            if (storeItem.getProductId() != null) {
                existingStoreItem.setProductId(storeItem.getProductId());
            }

            if (storeItem.getTotalQuantity() != 0) {
                existingStoreItem.setTotalQuantity(storeItem.getTotalQuantity());
            }


            StoreItem updatedStoreItem = storeItemService.updateStoreItem(existingStoreItem);
            return new ResponseEntity<>(updatedStoreItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping(value ="/itemstore/{id}")
    public ResponseEntity<String> deleteStoreItem(@PathVariable long id) {
        String deleted = storeItemService.deleteStoreItem(id);

        if (deleted.equals("StoreItem not found")) {
            return new ResponseEntity<>(deleted,HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(deleted,HttpStatus.NO_CONTENT);
        }
    }







}
