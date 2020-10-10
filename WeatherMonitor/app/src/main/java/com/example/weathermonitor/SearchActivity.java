package com.example.weathermonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
Activity to search the weather report based on the input
 */
public class SearchActivity extends AppCompatActivity {

    private EditText et_search_bar;
    private Button btn_search_get_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initViews();
        setOnclickListeners();
    }

    private void setOnclickListeners() {

        btn_search_get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intents for going to the next page
                 */
                Intent searchIntent = new Intent(SearchActivity.this, DisplayWeatherActivity.class);
                startActivity(searchIntent);
            }
        });
    }

    private void initViews() {

        btn_search_get_btn = findViewById(R.id.btn_search_get_btn);
        et_search_bar = findViewById(R.id.et_search_bar);

    }
}