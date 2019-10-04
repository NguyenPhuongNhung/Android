package com.example.homeworkandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {
        public int [] listNumbers ;

        public NumberAdapter(MainActivity mainActivity, int[] listNumbers) {
            this.listNumbers = listNumbers;
        }


        @NonNull
        @Override
        public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_number, parent, false);
            return new NumberViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
            holder.tvView.setText(" "+ position );
        }

        @Override
        public int getItemCount() {
                return listNumbers.length;

        }

        class NumberViewHolder extends RecyclerView.ViewHolder {
            TextView tvView;
            public NumberViewHolder(@NonNull View itemView) {
                super(itemView);
                tvView = itemView.findViewById(R.id.itemNumber);
            }
        }
        ;
    }

