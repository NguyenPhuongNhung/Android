package com.example.homeworkandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
   public int[] arrayNumbers = new int [100];
    RecyclerView recyclerViewNumber;
    NumberAdapter numberAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNumber = findViewById(R.id.RecyclerView_number);
        recyclerViewNumber.setLayoutManager(new LinearLayoutManager(this));

        numberAdapter = new NumberAdapter( this,arrayNumbers );
        recyclerViewNumber.setAdapter(numberAdapter);
    }
}
