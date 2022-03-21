package com.example.thingstobuy.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thingstobuy.model.Product;

@Database(entities = {Product.class}, version = 2)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductsDao productsDao();
    private static ProductDatabase INSTANCE;

    public static ProductDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ProductDatabase.class, "product_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
