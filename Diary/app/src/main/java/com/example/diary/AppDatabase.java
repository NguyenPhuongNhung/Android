package com.example.diary;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

@Database(entities = {Diary.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DiaryDao diaryDao();
}