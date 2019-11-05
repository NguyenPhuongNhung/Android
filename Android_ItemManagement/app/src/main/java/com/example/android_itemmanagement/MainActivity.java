package com.example.android_itemmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_itemmanagement.Database.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ItemAdapter itemAdapter;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "databaseName").build();
        itemAdapter = new ItemAdapter();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //itemAdapter.setOnClick(CartActivity.this);
        recyclerView.setAdapter(itemAdapter);
        Button btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScreenAdd();
            }
        });

    }

    public void onResume() {
        super.onResume();
        getAndShowItems();
    }

    private void openScreenAdd() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    private void getAndShowItems() {
        new AsyncTask<Void, Void, List<Item>>() {
            @Override
            protected List<Item> doInBackground(Void... voids) {
                return db.ItemDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Item> Items) {
                super.onPostExecute(Items);
                itemAdapter.Items = Items;
                itemAdapter.notifyDataSetChanged();
            }
        }.execute();
    }


}
