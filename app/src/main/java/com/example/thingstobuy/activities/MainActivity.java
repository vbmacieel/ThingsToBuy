package com.example.thingstobuy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.thingstobuy.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    private void setUi() {
        FrameLayout frameLayout = findViewById(R.id.fl_fragment);
    }
}