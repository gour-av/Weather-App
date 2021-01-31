package com.example.weathermonitor;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResponseLocationViewHolder extends RecyclerView.ViewHolder {

    private TextView mtvTitle, mtvLocation_type, mtvLatt_long;
    private RelativeLayout rlLocation;
    private ItemClickListener itemClickListener;

    public ResponseLocationViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        init(itemView, itemClickListener);
    }

    private void init(View view, ItemClickListener itemClickListener) {

        mtvTitle = view.findViewById(R.id.mtvTitle);
        mtvLocation_type = view.findViewById(R.id.mtvLocation_type);
        mtvLatt_long = view.findViewById(R.id.mtvLatt_long);

        rlLocation = view.findViewById(R.id.rlLocation);
        this.itemClickListener = itemClickListener;

//        tv_weatherState = view.findViewById(R.id.tv_weatherState);
//        tv_windDirection = view.findViewById(R.id.tv_windDirection);
//        tv_date = view.findViewById(R.id.tv_date);
//        tv_minTemp = view.findViewById(R.id.tv_minTemp);
//        tv_maxTemp = view.findViewById(R.id.tv_maxTemp);
//        tv_windSpeed = view.findViewById(R.id.tv_windSpeed);
//        tv_airPressure = view.findViewById(R.id.tv_airPressure);


    }

    public void setData(final ResponseLocation responseLocation) {

        mtvTitle.setText(responseLocation.getTitle());
        mtvLocation_type.setText(responseLocation.getLocationType());
        mtvLatt_long.setText(responseLocation.getLattLong());

        rlLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemCLick(getAdapterPosition(), responseLocation);
            }
        });
    }
}
