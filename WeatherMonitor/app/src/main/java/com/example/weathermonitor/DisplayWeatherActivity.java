package com.example.weathermonitor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weathermonitor.api.ApiClient;
import com.example.weathermonitor.api.ConsolidatedWeatherItem;
import com.example.weathermonitor.api.Network;
import com.example.weathermonitor.api.ResponseWeatherType;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayWeatherActivity extends AppCompatActivity {

    private TextView WeatherState, WindDirection, Date, Min_Temp, Max_Temp, Wind_Speed, Air_Pressure;
    private String str_1, str_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);
        initViews();
        getIntentData();
        makeAPICall();

    }


    //Initializing all the views
    private void initViews() {
        WeatherState = findViewById(R.id.weatherState);
        WindDirection = findViewById(R.id.windDirection);
        Date = findViewById(R.id.date);
        Min_Temp = findViewById(R.id.minTemp);
        Max_Temp = findViewById(R.id.maxTemp);
        Wind_Speed = findViewById(R.id.windSpeed);
        Air_Pressure = findViewById(R.id.airPressure);

    }

    //Getting the data From the Other Activity;
    private void getIntentData() {
        Intent intent = getIntent();
        Bundle weatherBundle = intent.getBundleExtra("bundle");
        str_1 = weatherBundle.getString("title");
        str_2 = weatherBundle.getString("woeid");
    }

    //Establishing the API Call to get Response from the server
    private void makeAPICall() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);

        final Call<ResponseWeatherType> responseWeatherTypeCall = apiClient.responseWeatherType(str_2);
        responseWeatherTypeCall.enqueue(new Callback<ResponseWeatherType>() {

            @Override
            public void onResponse(Call<ResponseWeatherType> call, Response<ResponseWeatherType> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    ResponseWeatherType responseWeatherType = response.body();
                    String cwi_str = "";
                    String cwi_air = "";
                    String cwi_wind_Dir= "";
                    String cwi_Min_Temp="";
                    String cwi_Max_Temp = "";
                    String cwi_windSpeed = "";

                    for (ConsolidatedWeatherItem cwi : responseWeatherType.getConsolidatedWeather()) {
                        cwi_str += cwi.getApplicableDate() + ":" + cwi.getWeatherStateName() + "\n";
                        cwi_air += cwi.getApplicableDate() + ":" + cwi.getAirPressure() + "\n";
                        cwi_wind_Dir += cwi.getApplicableDate() + ":" + cwi.getWindDirection() + "\n";
                        cwi_Min_Temp += cwi.getApplicableDate() + ":" + cwi.getMinTemp() + "\n";
                        cwi_Max_Temp += cwi.getApplicableDate() + ":" + cwi.getMaxTemp() + "\n";
                        cwi_windSpeed += cwi.getApplicableDate() + ":" + cwi.getWindSpeed() + "\n";
                    }
                    setData(cwi_str, cwi_air, cwi_wind_Dir, cwi_Min_Temp, cwi_Max_Temp, cwi_windSpeed);

                }
            }

            @Override
            public void onFailure(Call<ResponseWeatherType> call, Throwable t) {
                Toast.makeText(DisplayWeatherActivity.this, "Response Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setData(String cwi_str, String cwi_air, String cwi_wind_Dir, String cwi_Min_Temp, String cwi_Max_Temp, String cwi_windSpeed) {
        WeatherState.setText(cwi_str);
        Air_Pressure.setText(cwi_air);
        WindDirection.setText(cwi_wind_Dir);
        Min_Temp.setText(cwi_Min_Temp);
        Max_Temp.setText(cwi_Max_Temp);
        Wind_Speed.setText(cwi_windSpeed);
    }
}