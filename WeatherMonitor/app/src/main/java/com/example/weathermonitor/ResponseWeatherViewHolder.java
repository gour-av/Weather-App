package com.example.weathermonitor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ResponseWeatherViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView tv_weatherState, tv_windDirection, tv_date, tv_minTemp, tv_maxTemp, tv_windSpeed, tv_airPressure;

    public ResponseWeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {

        image = view.findViewById(R.id.image);
        tv_weatherState = view.findViewById(R.id.tv_weatherState);
        tv_windDirection = view.findViewById(R.id.tv_windDirection);
        tv_date = view.findViewById(R.id.tv_date);
        tv_minTemp = view.findViewById(R.id.tv_minTemp);
        tv_maxTemp = view.findViewById(R.id.tv_maxTemp);
        tv_windSpeed = view.findViewById(R.id.tv_windSpeed);
        tv_airPressure = view.findViewById(R.id.tv_airPressure);
    }

    public void setData(ConsolidatedWeatherItem consolidatedWeatherItem) {

        switch (consolidatedWeatherItem.getWeatherStateAbbr()) {

            case "sn":
                image.setImageResource(R.drawable.ic_sn);
                break;

            case "sl":
                image.setImageResource(R.drawable.ic_sl);
                break;

            case "h":
                image.setImageResource(R.drawable.ic_h);
                break;

            case "t":
                image.setImageResource(R.drawable.ic_t);
                break;

            case "hr":
                image.setImageResource(R.drawable.ic_hr);
                break;

            case "lr":
                image.setImageResource(R.drawable.ic_lr);
                break;

            case "s":
                image.setImageResource(R.drawable.ic_s);
                break;

            case "hc":
                image.setImageResource(R.drawable.ic_hc);
                break;

            case "lc":
                image.setImageResource(R.drawable.ic_lc);
                break;

            case "c":
                image.setImageResource(R.drawable.ic_c);
                break;
        }
        tv_weatherState.setText(tv_weatherState.getText() + " : " + consolidatedWeatherItem.getWeatherStateName());
        tv_windDirection.setText(tv_windDirection.getText() + " : " + consolidatedWeatherItem.getWindDirectionCompass());
        tv_date.setText(tv_date.getText() + " : " + consolidatedWeatherItem.getApplicableDate());
        tv_minTemp.setText(tv_minTemp.getText() + " : " + consolidatedWeatherItem.getMinTemp());
        tv_maxTemp.setText(tv_maxTemp.getText() + " : " + consolidatedWeatherItem.getMaxTemp());
        tv_windSpeed.setText(tv_windSpeed.getText() + " : " + consolidatedWeatherItem.getWindSpeed());
        tv_airPressure.setText(tv_airPressure.getText() + " : " + consolidatedWeatherItem.getAirPressure());
    }
}
