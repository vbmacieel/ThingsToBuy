package com.example.thingstobuy.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.thingstobuy.model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<Product> getAllProducts();

    @Insert
    void createNewProduct(Product product);

    @Delete
    void deleteProduct(Product product);
}
