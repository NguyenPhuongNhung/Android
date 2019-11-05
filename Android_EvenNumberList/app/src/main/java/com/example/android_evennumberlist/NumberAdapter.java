package com.example.android_evennumberlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {
    List<Integer> arrayNumber = new ArrayList<Integer>();


    public NumberAdapter(MainActivity mainActivity, List<Integer> arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.textView.setText(arrayNumber.get(position) + "");
    }

    @Override
    public int getItemCount() {
        return arrayNumber.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);

        }
    }
}
