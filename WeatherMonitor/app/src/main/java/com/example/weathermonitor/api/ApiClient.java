package com.example.weathermonitor.api;

import com.example.weathermonitor.ResponseLocation;
import com.example.weathermonitor.ResponseWeatherType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("/api/location/search/")
    Call<List<ResponseLocation>> enterName(@Query("query") String enterName);

    @GET("/api/location/{WoeId}/")
    Call<ResponseWeatherType> responseWeatherType(@Path("WoeId") String responseWeatherType);


}
