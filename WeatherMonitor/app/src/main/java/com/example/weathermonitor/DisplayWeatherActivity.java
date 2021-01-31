package com.example.weathermonitor;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermonitor.api.ApiClient;
import com.example.weathermonitor.api.Network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayWeatherActivity extends AppCompatActivity {

    private ProgressBar progressBarWeather;
    private String title, woeId;
    private RecyclerView recyclerViewWeather;
    private ResponseWeatherAdapter responseWeatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);
        getIntentData();
        init();
        fetchServer();
    }

    private void fetchServer() {

        ApiClient apiClient = Network.getInstance().create(ApiClient.class);

        Call<ResponseWeatherType> call = apiClient.responseWeatherType(woeId);

        call.enqueue(new Callback<ResponseWeatherType>() {
            @Override
            public void onResponse(Call<ResponseWeatherType> call, Response<ResponseWeatherType> response) {

                progressBarWeather.setVisibility(View.GONE);
                ResponseWeatherType responseWeatherType = response.body();
                setRecyclerData(responseWeatherType);
            }

            @Override
            public void onFailure(Call<ResponseWeatherType> call, Throwable t) {

            }
        });
    }

    private void setRecyclerData(ResponseWeatherType responseWeatherType) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewWeather.setLayoutManager(linearLayoutManager);

        responseWeatherAdapter = new ResponseWeatherAdapter(responseWeatherType.getConsolidatedWeather());
        recyclerViewWeather.setAdapter(responseWeatherAdapter);
    }


    private void init() {

        recyclerViewWeather = findViewById(R.id.recyclerViewWeather);
        progressBarWeather = findViewById(R.id.progressBarWeather);
    }

    private void getIntentData() {

        title = getIntent().getStringExtra("title");
        woeId = String.valueOf(getIntent().getIntExtra("woeid", 0));
    }


}