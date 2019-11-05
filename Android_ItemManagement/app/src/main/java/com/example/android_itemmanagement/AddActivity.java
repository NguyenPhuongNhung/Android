package com.example.android_itemmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_itemmanagement.Database.AppDatabase;

public class AddActivity extends AppCompatActivity {
    EditText tvName, tvQuantity;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "databaseName").build();

        tvName = findViewById(R.id.name);
        tvQuantity = findViewById(R.id.quantity);

        final Button add_item = findViewById(R.id.btn_add_item);
        add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add_item();
            }
        });


    }

    private void Add_item() {
        final String name = tvName.getText().toString();
        final int quantity = Integer.parseInt(tvQuantity.getText().toString());

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                Item newCart = new Item(name, quantity);
                db.ItemDao().insertAll(newCart);
                return null;
            }
        }.execute();
        Toast.makeText(getBaseContext(), "Add to cart successfully",
                Toast.LENGTH_SHORT).show();

    }
}
