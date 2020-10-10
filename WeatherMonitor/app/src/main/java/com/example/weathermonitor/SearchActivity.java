package com.example.weathermonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private ResponseAdapter responseAdapter;

    private String Pass;

    private EditText et_search_bar;
    private Button btn_search_get_btn;
    private ArrayList<ResponseRequestType> respons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initViews();
        setOnclickListeners();
        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {
        responseAdapter = new ResponseAdapter(respons);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(responseAdapter);

    }

    private void setOnclickListeners() {

        btn_search_get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           Pass =  et_search_bar.getText().toString();
                ApiClient apiClient = Network.getInstance().create(ApiClient.class);
                Call<ArrayList<ResponseRequestType>> call = apiClient.enterName(Pass);
                call.enqueue(new Callback<ArrayList<ResponseRequestType>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ResponseRequestType>> call, Response<ArrayList<ResponseRequestType>> response) {
                        if (response.code()==HttpURLConnection.HTTP_OK){
                            respons = response.body();
                            responseAdapter.updateDataSet(respons);
                            responseAdapter.notifyDataSetChanged();

                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ResponseRequestType>> call, Throwable t) {
                        Toast.makeText(SearchActivity.this,"Response Failed"+t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

                    private void initViews() {

                        btn_search_get_btn = findViewById(R.id.btn_search_get_btn);
                        et_search_bar = findViewById(R.id.et_search_bar);
                        mRecyclerView = findViewById(R.id.recycler);

                    }
                }

