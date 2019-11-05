package com.example.android_itemmanagement.Database;

import com.example.android_itemmanagement.Item;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item")
    List<Item> getAll();


    @Insert
    void insertAll(Item... items);

    @Delete
    void delete(Item item);
}