package com.example.diary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateDiary extends AppCompatActivity {
    AppDatabase db;
    EditText edtTitle;
    EditText edtContent;
    Button btnUpdate;
    int id_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_diary);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        edtTitle = findViewById(R.id.title_updating);
        edtContent = findViewById(R.id.content_updating);
        btnUpdate = findViewById(R.id.btnSaveChange);

        int id = getIntent().getIntExtra("id", 0);
        id_item = id;
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");

        edtTitle.setText(title);
        edtContent.setText(content);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTodoToDatabase();
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private void updateTodoToDatabase() {
        final String title = edtTitle.getText().toString();
        final String content = edtContent.getText().toString();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Diary diaryUpdated = new Diary("2019-08-23", title, content);
                diaryUpdated.setUid(id_item);
                db.diaryDao().updateDiary(diaryUpdated);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                showSuccessDialog();
            }
        }.execute();
    }

    private void showSuccessDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Message")
                .setMessage("Successfully")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();
    }
}