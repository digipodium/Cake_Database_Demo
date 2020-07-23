package com.example.cakedatabasedemo;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CakeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Cake cake);

    @Query("SELECT * FROM cake_table ORDER BY name ASC")
    LiveData<List<Cake>> getAllCakes();

    @Query("DELETE FROM cake_table")
    void deleteAll();

    @Query("DELETE FROM cake_table WHERE name like :name")
    void deleteCake(String name);
}
