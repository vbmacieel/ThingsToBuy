package com.example.thingstobuy.repository;

import com.example.thingstobuy.database.ProductDao;
import com.example.thingstobuy.database.ProductDatabase;
import com.example.thingstobuy.model.Product;

import java.util.List;

public class ProductRepository {

    private final ProductDatabase mProductDatabase;

    public ProductRepository(final ProductDatabase productDatabase) {
        this.mProductDatabase = productDatabase;
    }

    public List<Product> getAllProducts() {
        return getProductDao().getAllProducts();
    }

    public void createNewProduct(Product product) {
        getProductDao().createNewProduct(product);
    }

    public void deleteProduct(Product product) {
        getProductDao().deleteProduct(product);
    }

    private ProductDao getProductDao() {
        return mProductDatabase.productDao();
    }
}
