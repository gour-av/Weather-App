package com.example.weathermonitor;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermonitor.api.ApiClient;
import com.example.weathermonitor.api.Network;
import com.example.weathermonitor.api.ResponseRequestType;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
Activity to search the weather report based on the input
 */
public class SearchActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ResponseLocationAdapter responseLocationAdapter;

    private String[] lables;
    private ArrayAdapter<String> adapter;
    private ProgressBar pBar;
    private String Pass;
    private AutoCompleteTextView atv_search_bar;
    private Button btn_search_get_btn;
    private ArrayList<ResponseRequestType> respons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Resources res = getResources();
        lables = res.getStringArray(R.array.india_top_places);

        initViews();
        setOnclickListeners();

        adapter = new ArrayAdapter<>(SearchActivity.this, android.R.layout.simple_list_item_1, lables);
        atv_search_bar.setAdapter(adapter);
        atv_search_bar.setThreshold(1);

        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {
        responseLocationAdapter = new ResponseLocationAdapter(respons, new ResponseLocationAdapter.onClickListener() {
            @Override
            public void onClick(ResponseRequestType responseRequestType) {
                Intent intent = new Intent(SearchActivity.this, DisplayWeatherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", responseRequestType.getTitle());
                bundle.putString("woeid", String.valueOf(responseRequestType.getWoeid()));
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(responseLocationAdapter);
    }

    private void setOnclickListeners() {

        btn_search_get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pBar.setVisibility(View.VISIBLE);
                Pass = atv_search_bar.getText().toString();
                ApiClient apiClient = Network.getInstance().create(ApiClient.class);
                Call<ArrayList<ResponseRequestType>> call = apiClient.enterName(Pass);
                call.enqueue(new Callback<ArrayList<ResponseRequestType>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ResponseRequestType>> call, Response<ArrayList<ResponseRequestType>> response) {
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            respons = response.body();
                            responseLocationAdapter.updateDataSet(respons);
                            responseLocationAdapter.notifyDataSetChanged();
                            pBar.setVisibility(View.GONE);

                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ResponseRequestType>> call, Throwable t) {
                        Toast.makeText(SearchActivity.this, "Response Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    private void initViews() {

        btn_search_get_btn = findViewById(R.id.btn_search_get_btn);
        atv_search_bar = findViewById(R.id.atv_search_bar);
        mRecyclerView = findViewById(R.id.recycler);
        pBar = (ProgressBar) findViewById(R.id.pBar);

    }

}

