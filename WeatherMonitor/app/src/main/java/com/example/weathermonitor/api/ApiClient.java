package com.example.weathermonitor.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("/api/location/search/")
    Call<ArrayList<ResponseRequestType>> enterName(@Query("query") String enterName);
    @GET("/api/location/{WoeId}/")
    Call<ResponseWeatherType> responseWeatherType(@Path("WoeId") String responseWeatherType);


}
