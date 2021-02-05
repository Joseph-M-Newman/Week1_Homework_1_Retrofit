package com.example.week1_homework_1_newman.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<Users> getAll();

    @Insert
    void insertAll(Users...users);


    @Delete
    void deleteAll(Users...users);

    @Delete
    void delete(Users...user);


}
