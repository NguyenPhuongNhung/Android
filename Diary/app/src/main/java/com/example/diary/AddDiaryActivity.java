package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddDiaryActivity extends AppCompatActivity {

    AppDatabase db;
    EditText txtTitle;
    EditText txtContent;
    Button buttonAdd;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        txtTitle = findViewById(R.id.title);
        txtContent = findViewById(R.id.content);
        buttonAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewDiaryDatabase();
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void addNewDiaryDatabase() {
        final String stTitle = txtTitle.getText().toString();
        final String stContent = txtContent.getText().toString();
        if (stTitle.isEmpty() || stContent.isEmpty()) {
            Toast.makeText(this, "Edit text must not null", Toast.LENGTH_SHORT).show();
            return;
        }
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Diary newDiary = new Diary("2019-06-05", stTitle, stContent);
                db.diaryDao().insertAll(newDiary);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(AddDiaryActivity.this, "Add successfully", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
}

