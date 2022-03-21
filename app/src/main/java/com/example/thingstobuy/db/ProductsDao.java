package com.example.thingstobuy.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.thingstobuy.model.Product;

import java.util.List;

@Dao
public interface ProductsDao {
    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProducts();

    @Insert
    void insertProduct(Product product);

    @Delete
    void deleteProduct(Product product);
}
