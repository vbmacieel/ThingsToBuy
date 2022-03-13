package com.example.thingstobuy.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thingstobuy.model.Product;

import java.util.List;

public class ProductRecyclerViewAdapter extends
        RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductRecyclerViewAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
