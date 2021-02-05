package com.example.week1_homework_1_newman.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.net.PasswordAuthentication;

@Entity
public class Users {

    public Users(){

    };

    public Users(String username, String Pass){
        this.Username = username;
        this.Password = Pass;
    }

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="Username")
    public String Username;

    @ColumnInfo(name="Password")
    public String Password;


}
