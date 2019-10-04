package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewStudent;
    StudentAdapter studentAdapter;
    public List<Student> Students = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Students.add(new Student("Tham", 23,"Quang Tri"));
        Students.add( new Student("Lan", 34,"Da Nang"));
        Students.add( new Student("Thao", 23,"Quang Nam"));
        Students.add( new Student("Nhung", 22,"Binh Dinh"));
        Students.add( new Student("Phuong", 25,"Binh Thuan"));


        recyclerViewStudent = findViewById(R.id.Recyckerview_task);
        recyclerViewStudent.setLayoutManager(new LinearLayoutManager(this));

        studentAdapter = new StudentAdapter( this, Students);
        recyclerViewStudent.setAdapter(studentAdapter);

    }
    public void clickAdd (View view){
        Student newTask = new Student("Anonymous", 20,"Galaxy");
        Students.add(newTask);
        studentAdapter.notifyDataSetChanged();
    }
    public void clickDelete (View view){
        Students.remove(4);
        studentAdapter.notifyDataSetChanged();
    }
    }

