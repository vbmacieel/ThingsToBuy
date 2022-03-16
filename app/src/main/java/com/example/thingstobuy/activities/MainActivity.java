package com.example.thingstobuy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.thingstobuy.R;
import com.example.thingstobuy.fragments.ProductListFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultFragment();
        setUi();
    }

    private void setDefaultFragment() {
        ProductListFragment productListFragment = new ProductListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction().replace(R.id.fl_fragment, productListFragment);
        fragmentTransaction.commit();
    }

    private void setUi() {
         frameLayout = findViewById(R.id.fl_fragment);
    }
}