package com.example.thingstobuy.viewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.thingstobuy.db.ProductDatabase;
import com.example.thingstobuy.db.repository.ProductRepository;
import com.example.thingstobuy.model.Product;

import java.util.List;

public class ProductDatabaseViewModel extends AndroidViewModel {

    private ProductRepository mProductRepository;
    private LiveData<List<Product>> mProductList;

    public ProductDatabaseViewModel(@NonNull Application application) {
        super(application);
        mProductRepository = new ProductRepository(application);
        mProductList = mProductRepository.getAllProducts();
    }

    public LiveData<List<Product>> getmProductList() {
        return mProductList;
    }

    public void insertProduct(Product product) {
        mProductRepository.insertProduct(product);
    }
}
