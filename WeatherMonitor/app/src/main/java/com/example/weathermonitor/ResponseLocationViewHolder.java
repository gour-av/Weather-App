package com.example.weathermonitor;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathermonitor.api.ResponseRequestType;

/*
ViewHolder class of the RecyclerView
*/
public class ResponseViewHolder extends RecyclerView.ViewHolder {
    private TextView WoeId , Title,Location_Type,Latt_Long;
    public ResponseViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
            WoeId = itemView.findViewById(R.id.mtvWoeId);
            Title = itemView.findViewById(R.id.mtvTitle);
            Location_Type = itemView.findViewById(R.id.mtvLocation_type);
            Latt_Long = itemView.findViewById(R.id.mtvLatt_long);
    }

    public void setData(ResponseRequestType model) {
      WoeId.setText(String.valueOf(model.getWoeid()));
      Title.setText(model.getTitle());
      Location_Type.setText(model.getLocationType());
      Latt_Long.setText(model.getLattLong());

    }
}