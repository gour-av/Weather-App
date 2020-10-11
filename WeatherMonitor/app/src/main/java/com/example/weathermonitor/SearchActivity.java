package com.example.weathermonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

/*
Activity to search the weather report based on the input
 */
public class SearchActivity extends AppCompatActivity {

    private AutoCompleteTextView atv_search_bar;
    private Button btn_search_get_btn;
    private String []  hello  = new String [] { "sunday", "monday", "tuesday", "thursday" };
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initViews();
        setOnclickListeners();
        adapter = new ArrayAdapter<>(SearchActivity.this, android.R.layout.simple_list_item_1,hello);
        atv_search_bar.setAdapter(adapter);
        atv_search_bar.setThreshold(1);
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
        atv_search_bar = (AutoCompleteTextView) findViewById(R.id.atv_search_bar);


        Bundle bundle = getIntent().getExtras();
        String venName = bundle.getString("city");

        //atv_search_bar.setText(venName);
    }

}