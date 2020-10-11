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
public class ResponseLocationAdapter extends RecyclerView.Adapter<ResponseLocationViewHolder> {
    private ArrayList<ResponseRequestType> requestTypes;
    public onClickListener onClickListener;


    public ResponseLocationAdapter(ArrayList<ResponseRequestType> model,onClickListener onClickListener) {
        requestTypes = new ArrayList<>();
        requestTypes.addAll(model);
        this.onClickListener = onClickListener;
    }
    public void updateDataSet(ArrayList<ResponseRequestType> model) {
        requestTypes.clear();
        requestTypes.addAll(model);
    }


    @NonNull
    @Override
    public ResponseLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_locations, parent, false);
        return new ResponseLocationViewHolder(view/*,onClickListener*/);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseLocationViewHolder holder, int position) {
        final ResponseRequestType model = requestTypes.get(position);
        holder.setData(model);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(model);
            }
        });


    }

    @Override
    public int getItemCount() {
        return requestTypes.size();
    }
    public interface onClickListener{
        void onClick(ResponseRequestType responseRequestType);
    }
}
