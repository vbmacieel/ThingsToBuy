package com.example.thingstobuy.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thingstobuy.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "product.db";
    private static ProductDatabase sInstance;

    public static synchronized ProductDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = createDatabase(context);
        }
        return sInstance;
    }

    private static ProductDatabase createDatabase(final Context context) {
        return Room.databaseBuilder(context,
                ProductDatabase.class, DATABASE_NAME).build();
    }

    public abstract ProductDao productDao();
}
