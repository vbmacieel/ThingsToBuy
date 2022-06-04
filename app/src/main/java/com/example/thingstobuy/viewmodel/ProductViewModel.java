package com.example.thingstobuy.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thingstobuy.model.Product;
import com.example.thingstobuy.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private final ProductRepository mProductRepository;

    private final MutableLiveData<List<Product>> _products = new MutableLiveData<>();
    public final LiveData<List<Product>> products = _products;

    public ProductViewModel(final ProductRepository productRepository) {
        this.mProductRepository = productRepository;
    }

    public void getAllProducts() {
        _products.setValue(mProductRepository.getAllProducts());
    }

    public void createNewProduct(Product product) {
        mProductRepository.createNewProduct(product);
    }
}
