package com.example.test1.service;
import com.example.test1.Entity.Product;
import com.example.test1.Entity.Store;
import com.example.test1.Entity.StoreItem;
import com.example.test1.repository.ProductRepository;
import com.example.test1.repository.StoreItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;




@Service
public class StoreItemService {




    private StoreItemRepository storeItemRepository;


    @Autowired
    public StoreItemService(StoreItemRepository storeItemRepository) {

        this.storeItemRepository = storeItemRepository;

    }




    public List<StoreItem> getAllStoreItem() {
        return storeItemRepository.findAll();

      }

    public Optional<StoreItem> getStoreItemById(long id) {
        return storeItemRepository.findById(id);
    }




//    private StoreService storeService ;
//    private ProductService productService ;
//


//    public StoreItem createStoreItem(StoreItem storeItem) {
//        String storeId = storeItem.getStoreId();
//        String productId = storeItem.getProductId();
//
//        // Check if both product and store exist
//        Optional<Product> productOptional = productService.getProductById(productId);
//        Optional<Store> storeOptional = storeService.getStoresById(storeId);
//
//        if (productOptional.isPresent() && storeOptional.isPresent()) {
//            storeItem.setProduct(productOptional.get());
//            return storeItemRepository.save(storeItem);
//        } else {
//            throw new IllegalArgumentException("Product or Store not found");
//        }
//    }


    public StoreItem createStoreItem(StoreItem storeItem) {

        return storeItemRepository.save(storeItem);
    }

    public StoreItem updateStoreItem(StoreItem storeItem) {
        return storeItemRepository.save(storeItem);
    }

    public String deleteStoreItem(long id) {

        if (storeItemRepository.existsById(id)) {
            storeItemRepository.deleteById(id);
            return "StoreItem deleted  ==> id = " +id;
        }
        else {
            return "StoreItem not found";
        }

    }

}
