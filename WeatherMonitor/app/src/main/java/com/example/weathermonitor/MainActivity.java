package com.example.weathermonitor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermonitor.api.ApiClient;
import com.example.weathermonitor.api.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private SearchView sv_searchLocation;
    private RecyclerView recyclerViewLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {

        sv_searchLocation = findViewById(R.id.sv_searchLocation);
        recyclerViewLocation = findViewById(R.id.recyclerViewLocation);
        sv_searchLocation.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null) fetchServer(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null) fetchServer(newText);
                return false;
            }
        });

    }

    private void fetchServer(String query) {

        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        Call<List<ResponseLocation>> call = apiClient.enterName(query);

        call.enqueue(new Callback<List<ResponseLocation>>() {
            @Override
            public void onResponse(Call<List<ResponseLocation>> call, Response<List<ResponseLocation>> response) {

                List<ResponseLocation> responseLocations = response.body();
                setRecyclerData(responseLocations);
            }

            @Override
            public void onFailure(Call<List<ResponseLocation>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerData(List<ResponseLocation> responseLocations) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewLocation.setLayoutManager(linearLayoutManager);

        ResponseLocationAdapter responseLocationAdapter = new ResponseLocationAdapter(responseLocations, this);
        recyclerViewLocation.setAdapter(responseLocationAdapter);
    }

    @Override
    public void onItemCLick(int position, ResponseLocation responseLocation) {

        Intent intent = new Intent(getApplicationContext(), DisplayWeatherActivity.class);
        intent.putExtra("title", responseLocation.getTitle());
        intent.putExtra("woeid", responseLocation.getWoeid());
        startActivity(intent);
    }
}