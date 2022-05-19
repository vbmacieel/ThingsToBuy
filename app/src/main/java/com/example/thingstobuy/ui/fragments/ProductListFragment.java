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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thingstobuy.R;
import com.example.thingstobuy.adapter.ProductRecyclerViewAdapter;
import com.example.thingstobuy.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment {
    private FloatingActionButton mFabNewProducts;
    private ProductRecyclerViewAdapter mProductsRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        creatingRecyclerView(view);
        setUi(view);
        fabChangeFragment();
        return view;
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

    private void creatingRecyclerView(View view) {
        List<Product> productList = new ArrayList<>();
        RecyclerView recyclerViewProducts = view.findViewById(R.id.recycler_view_products);
        mProductsRecyclerViewAdapter = new ProductRecyclerViewAdapter(productList);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewProducts.setAdapter(mProductsRecyclerViewAdapter);
    }

    private void setUi(View view) {
        mFabNewProducts = view.findViewById(R.id.fab_new_product);
        mFabNewProducts.setImageResource(R.drawable.ic_add);
    }
}
