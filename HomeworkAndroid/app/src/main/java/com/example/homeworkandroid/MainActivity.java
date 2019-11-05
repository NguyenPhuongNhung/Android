package com.example.homeworkandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList arrayNumbers = new ArrayList();

    RecyclerView recyclerViewNumber;
    NumberAdapter numberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNumber = findViewById(R.id.RecyclerView_number);
        recyclerViewNumber.setLayoutManager(new LinearLayoutManager(this));
        int number = 0;
       for(int j = 0 ; j <100; j++){
            if (number % 2 == 0) {
                arrayNumbers.add(number);
            }
            number++;

        }
        numberAdapter = new NumberAdapter(this, arrayNumbers);
        recyclerViewNumber.setAdapter(numberAdapter);
    }
}

