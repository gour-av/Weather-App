package com.example.weathermonitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResponseWeatherAdapter extends RecyclerView.Adapter<ResponseWeatherViewHolder> {

    private final List<ConsolidatedWeatherItem> consolidatedWeatherItemList;

    public ResponseWeatherAdapter(List<ConsolidatedWeatherItem> consolidatedWeatherItemList) {
        this.consolidatedWeatherItemList = consolidatedWeatherItemList;
    }

    @NonNull
    @Override
    public ResponseWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_weather_design, parent, false);
        return new ResponseWeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseWeatherViewHolder holder, int position) {

        ConsolidatedWeatherItem consolidatedWeatherItem = consolidatedWeatherItemList.get(position);
        holder.setData(consolidatedWeatherItem);
    }

    @Override
    public int getItemCount() {
        return consolidatedWeatherItemList.size();
    }
}
