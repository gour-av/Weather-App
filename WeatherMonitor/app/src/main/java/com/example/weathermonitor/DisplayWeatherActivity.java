package com.example.weathermonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DisplayWeatherActivity extends AppCompatActivity {

    private RecyclerView rcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);
        initViews();
        setOnclickListeners();
    }

    private void setOnclickListeners() {

    }

    //Initializing all the views
    private void initViews() {

        rcView = findViewById(R.id.rcView);
    }
}