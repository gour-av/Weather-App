package com.example.weathermonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayListofLocations extends AppCompatActivity {

    private RecyclerView rcViewLocations;
    private TextView tv_title_loc, tv_locationType_loc, tv_LatLong_loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_listof_locations);
        initViews();
    }

    private void initViews() {

        rcViewLocations = findViewById(R.id.rcViewLocations);
        tv_title_loc = findViewById(R.id.tv_title_loc);
        tv_locationType_loc = findViewById(R.id.tv_locationType_loc);
        tv_LatLong_loc = findViewById(R.id.tv_locationType_loc);
    }
}