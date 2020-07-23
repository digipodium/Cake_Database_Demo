package com.example.cakedatabasedemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "cake_table")
public class Cake {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name="name")
    private String name;

    public Cake(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
