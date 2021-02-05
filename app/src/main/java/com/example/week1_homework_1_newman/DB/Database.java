package com.example.week1_homework_1_newman.DB;

import androidx.room.Dao;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Users.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract UserDao userDao();
}
