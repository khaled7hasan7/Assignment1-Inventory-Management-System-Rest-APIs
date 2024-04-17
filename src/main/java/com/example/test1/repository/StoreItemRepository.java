package com.example.test1.repository;


import com.example.test1.Entity.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreItemRepository  extends JpaRepository<StoreItem, Long> {
}
