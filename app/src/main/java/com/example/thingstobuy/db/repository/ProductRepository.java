package com.example.thingstobuy.db.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.thingstobuy.db.ProductDatabase;
import com.example.thingstobuy.db.ProductsDao;
import com.example.thingstobuy.model.Product;

import java.util.List;

public class ProductRepository {
    private ProductsDao mProductDao;
    private LiveData<List<Product>> mProductList;

    public ProductRepository(Application application) {
        ProductDatabase db = ProductDatabase.getDatabase(application);
        mProductDao = db.productsDao();
        mProductList = mProductDao.getAllProducts();
    }

    public LiveData<List<Product>> getAllProducts() {
        return mProductList;
    }

    public void insertProduct(Product product) {
        new insertAsyncTask(mProductDao).execute(product);
    }

    private static class insertAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductsDao mAsyncProductDao;

        private insertAsyncTask(ProductsDao productsDao) {
            mAsyncProductDao = productsDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            mAsyncProductDao.insertProduct(products[0]);
            return null;
        }
    }
}
