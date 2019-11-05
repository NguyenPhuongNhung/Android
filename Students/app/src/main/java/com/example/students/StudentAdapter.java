package com.example.students;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import java.util.List;

    public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
        public List<Student> Students;


        public StudentAdapter(MainActivity mainActivity, List<Student> students) {
            Students = students;
        }

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
            return new StudentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            String profile = "";
            profile += Students.get(position).name +" " + Students.get(position).age +" " + Students.get(position).hometown;
            holder.tvView.setText(profile );

        }

        @Override
        public int getItemCount() {
            return Students.size();

        }

        class StudentViewHolder extends RecyclerView.ViewHolder {
            TextView tvView;
            public StudentViewHolder(@NonNull View itemView) {
                super(itemView);
                tvView = itemView.findViewById(R.id.tv_student);
            }
        }
        ;
    }


