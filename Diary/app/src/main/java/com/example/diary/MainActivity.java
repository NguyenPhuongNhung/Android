package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    RecyclerView diaries_recycler_view;
    DiaryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSwithScreen = findViewById(R.id.switch_screen);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        diaries_recycler_view = findViewById(R.id.diaries_recycler);
        diaries_recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        diaries_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DiaryAdapter();
        adapter.listener = new DiaryAdapter.OnItemClickListener() {
            @Override
            public void onUpdateClick(int position) {
                openUpdateDiaryScreen(adapter.diaries.get(position));
            }

            @Override
            public void onDeleteClick(int position) {
                deleteItemDiary(adapter.diaries.get(position));
            }
        };
        diaries_recycler_view.setAdapter(adapter);
        btnSwithScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddDiaryScreen();
            }
        });
    }

    private void openAddDiaryScreen() {
        Intent intent = new Intent(MainActivity.this, AddDiaryActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDiaryFromDatabase();
    }

    private void openUpdateDiaryScreen(Diary diary) {
        Intent intent = new Intent(MainActivity.this, UpdateDiary.class);
        intent.putExtra("id", diary.getUid());
        intent.putExtra("title", diary.getTitle());
        intent.putExtra("content", diary.getContent());
        startActivity(intent);
    }


    private void deleteItemDiary( Diary diary) {
        new AsyncTask<Void, Void, List<Diary>>() {
            @Override
            protected List<Diary> doInBackground(Void... voids) {
                Diary diaryDeleted = new Diary();
                 db.diaryDao().deleteDiary(diaryDeleted);
                 return  null;
            }

            @Override
            protected void onPostExecute(List<Diary> diaryList) {
                super.onPostExecute(diaryList);
                adapter.diaries = diaryList;
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }

    private void getDiaryFromDatabase() {

        new AsyncTask<Void, Void, List<Diary>>() {
            @Override
            protected List<Diary> doInBackground(Void... voids) {
                return db.diaryDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Diary> diaryList) {
                super.onPostExecute(diaryList);
                adapter.diaries = diaryList;
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
