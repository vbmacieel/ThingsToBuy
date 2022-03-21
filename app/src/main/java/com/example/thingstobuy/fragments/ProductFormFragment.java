package com.example.thingstobuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.thingstobuy.R;
import com.example.thingstobuy.db.ProductDatabase;

public class ProductFormFragment extends Fragment {

    private EditText productFormTitle;
    private EditText productFormValue;
    private EditText productFormUrl;
    private EditText productFormImg;
    private Button btnAddNewProduct;

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
        productFormTitle = view.findViewById(R.id.product_form_title);
        productFormValue = view.findViewById(R.id.product_form_value);
        productFormUrl = view.findViewById(R.id.product_form_site_url);
        productFormImg = view.findViewById(R.id.product_form_img);
        btnAddNewProduct = view.findViewById(R.id.btn_create_product);
    }
}
