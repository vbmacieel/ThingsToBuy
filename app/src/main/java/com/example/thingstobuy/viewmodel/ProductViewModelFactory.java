package com.example.thingstobuy.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.thingstobuy.repository.ProductRepository;

public class ProductViewModelFactory implements ViewModelProvider.Factory {

    private final ProductRepository mProductRepository;

    public ProductViewModelFactory(ProductRepository mProductRepository) {
        this.mProductRepository = mProductRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProductViewModel.class)) {
            return (T) new ProductViewModel(this.mProductRepository);
        } else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
