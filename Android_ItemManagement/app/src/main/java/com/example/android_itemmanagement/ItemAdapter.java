package com.example.android_itemmanagement;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    List<Item> Items;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.textViewName.setText(Items.get(position).product_name);
        holder.textViewQuantity.setText(Items.get(position).quantity + "");

    }

    @Override
    public int getItemCount() {
        if (Items == null) {
            return 0;
        } else {
            return Items.size();
        }

    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewQuantity;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name);
            textViewQuantity = itemView.findViewById(R.id.quantity);

        }
    }
}
