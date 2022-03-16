package com.example.thingstobuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thingstobuy.R;
import com.example.thingstobuy.adapter.ProductRecyclerViewAdapter;
import com.example.thingstobuy.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment {
    private FloatingActionButton fabNewProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        creatingRecyclerView(view);
        setUi(view);
        return view;
    }

    private void creatingRecyclerView(View view) {
        RecyclerView recyclerViewProducts = view.findViewById(R.id.recycler_view_products);
        List<Product> productList = new ArrayList<>();
        ProductRecyclerViewAdapter productRecyclerViewAdapter =
                new ProductRecyclerViewAdapter(productList, requireContext());
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewProducts.setAdapter(productRecyclerViewAdapter);
    }

    private void setUi(View view) {
        fabNewProduct = view.findViewById(R.id.fab_new_product);
        fabNewProduct.setImageResource(R.drawable.ic_add);
    }
}
