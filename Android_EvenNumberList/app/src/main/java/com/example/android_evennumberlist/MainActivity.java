package com.example.android_evennumberlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NumberAdapter numberAdapter;
    List<Integer> number = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setNumberArray();

        numberAdapter = new NumberAdapter(this, number);
        recyclerView.setAdapter(numberAdapter);
    }

    private void setNumberArray() {
        int i = 1, dem = 0;
        while (dem < 100) {
            if (i % 2 == 0) {
                dem++;
                number.add(i);
            }
            i++;

        }
    }
}
