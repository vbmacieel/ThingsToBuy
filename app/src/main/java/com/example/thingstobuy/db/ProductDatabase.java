package com.example.thingstobuy.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.thingstobuy.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductsDao productsDao();
}
