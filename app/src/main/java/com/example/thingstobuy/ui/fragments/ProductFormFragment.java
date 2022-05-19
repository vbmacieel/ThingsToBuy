package com.example.thingstobuy.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thingstobuy.R;

public class ProductFormFragment extends Fragment {
    private EditText mProductTitle;
    private EditText mProductValue;
    private EditText mProductUrl;
    private EditText mProductImg;
    private Button mBtnAddNewProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        initUi(view);
        return view;
    }

    private void initUi(View view) {
        mProductTitle = view.findViewById(R.id.product_form_title);
        mProductValue = view.findViewById(R.id.product_form_value);
        mProductUrl = view.findViewById(R.id.product_form_site_url);
        mProductImg = view.findViewById(R.id.product_form_img);
        mBtnAddNewProduct = view.findViewById(R.id.btn_create_product);
    }
}
