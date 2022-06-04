package com.example.thingstobuy.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thingstobuy.R;
import com.example.thingstobuy.adapter.ProductRecyclerViewAdapter;
import com.example.thingstobuy.database.ProductDatabase;
import com.example.thingstobuy.model.Product;
import com.example.thingstobuy.repository.ProductRepository;
import com.example.thingstobuy.viewmodel.ProductViewModel;
import com.example.thingstobuy.viewmodel.ProductViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductListFragment extends Fragment {

    private FloatingActionButton mFabNewProducts;
    private ProductViewModel mProductViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setUi(view);
        fabChangeFragment();
        setViewModel();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mProductViewModel.products.observe(this, this::creatingRecyclerView);
    }

    private void fabChangeFragment() {
        mFabNewProducts.setOnClickListener(view -> {
            ProductFormFragment productFormFragment = new ProductFormFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fl_fragment, productFormFragment, null)
                    .commit();
        });
    }

    private void creatingRecyclerView(List<Product> products) {
        RecyclerView recyclerViewProducts = requireView().findViewById(R.id.recycler_view_products);
        ProductRecyclerViewAdapter mProductsRecyclerViewAdapter =
                new ProductRecyclerViewAdapter(products);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewProducts.setAdapter(mProductsRecyclerViewAdapter);
    }

    private void setViewModel() {
        ProductDatabase db = ProductDatabase.getInstance(getContext());
        ProductRepository productRepository = new ProductRepository(db);
        ProductViewModelFactory productViewModelFactory =
                new ProductViewModelFactory(productRepository);
        mProductViewModel = new ViewModelProvider(this, productViewModelFactory)
                .get(ProductViewModel.class);
    }

    private void setUi(View view) {
        mFabNewProducts = view.findViewById(R.id.fab_new_product);
        mFabNewProducts.setImageResource(R.drawable.ic_add);
    }
}
