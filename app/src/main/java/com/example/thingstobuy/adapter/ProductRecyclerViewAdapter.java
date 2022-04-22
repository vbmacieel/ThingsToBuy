package com.example.thingstobuy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thingstobuy.R;
import com.example.thingstobuy.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductRecyclerViewAdapter extends
        RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder> {
    private final List<Product> productList;

    public ProductRecyclerViewAdapter(List<Product> products) {
        this.productList = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productValue.setText((int) product.getValue());
        Picasso.get().load(product.getImagePath()).into(holder.productImageUrl);
    }

    @Override
    public int getItemCount() {
        return productList == null ? 0 : productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView productName;
        private final TextView productValue;
        private final ImageView productImageUrl;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productValue = itemView.findViewById(R.id.product_value);
            productImageUrl = itemView.findViewById(R.id.product_image);
        }
    }
}
