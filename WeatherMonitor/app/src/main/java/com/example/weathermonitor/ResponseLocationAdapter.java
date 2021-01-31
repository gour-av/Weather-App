package com.example.weathermonitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResponseLocationAdapter extends RecyclerView.Adapter<ResponseLocationViewHolder> {

    private final List<ResponseLocation> responseLocations;
    private final ItemClickListener itemClickListener;

    public ResponseLocationAdapter(List<ResponseLocation> responseLocations, ItemClickListener itemClickListener) {
        this.responseLocations = responseLocations;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ResponseLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_locations, parent, false);
        return new ResponseLocationViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseLocationViewHolder holder, int position) {

        ResponseLocation responseLocation = responseLocations.get(position);
        holder.setData(responseLocation);
    }

    @Override
    public int getItemCount() {

        return responseLocations.size();
    }
}
