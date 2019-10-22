package com.example.diary;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DiaryDao {
    @Query("SELECT * FROM Diary")
    List<Diary> getAll();

    @Insert
    void insertAll(Diary... diary);

    @Update
    void updateDiary(Diary diary);

    @Delete
    void deleteDiary(Diary... diary);

}
