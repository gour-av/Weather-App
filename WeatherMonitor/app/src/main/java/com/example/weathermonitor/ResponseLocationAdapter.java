package com.example.weathermonitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermonitor.api.ResponseRequestType;

import java.util.ArrayList;

/*
Adapter Class of the RecyclerView
 */
public class ResponseAdapter extends RecyclerView.Adapter<ResponseViewHolder> {
    private ArrayList<ResponseRequestType> requestTypes;

    public ResponseAdapter(ArrayList<ResponseRequestType> model) {
        requestTypes = new ArrayList<>();
        requestTypes.addAll(model);
    }
    public void updateDataSet(ArrayList<ResponseRequestType> model) {
        requestTypes.clear();
        requestTypes.addAll(model);
    }


    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_weather_1_layout, parent, false);
        return new ResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseViewHolder holder, int position) {
        ResponseRequestType model = requestTypes.get(position);
        holder.setData(model);


    }

    @Override
    public int getItemCount() {
        return requestTypes.size();
    }
}
