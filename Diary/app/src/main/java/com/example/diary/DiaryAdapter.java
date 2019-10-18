package com.example.diary;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>{

    List<Diary> diaries;
    OnItemClickListener listener;

    @NonNull
    @Override
    public DiaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_diaries, parent, false);
        return new DiaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryViewHolder holder, int position) {
        holder.textTitle.setText(diaries.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (diaries == null) {
            return 0;
        }
        return diaries.size();
    }

    class DiaryViewHolder extends RecyclerView.ViewHolder {

        EditText textTitle;
        Button btnUpdate;
        Button btnDelete;

        public DiaryViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            btnUpdate = itemView.findViewById(R.id.button_update);
            btnDelete = itemView.findViewById(R.id.button_delete);

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onUpdateClick(getAdapterPosition());
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDeleteClick(getAdapterPosition());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onUpdateClick(int position);
        void onDeleteClick(int position);
    }
}

