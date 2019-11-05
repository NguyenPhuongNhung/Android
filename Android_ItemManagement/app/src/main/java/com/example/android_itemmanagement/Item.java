package com.example.android_itemmanagement;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String product_name;

    @ColumnInfo(name = "quantity")
    public int quantity;

    public Item(String product_name, int quantity) {
        this.product_name = product_name;
        this.quantity = quantity;
    }
}
