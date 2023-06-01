package com.example.apphoctap.Data;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.apphoctap.model.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDao getUserDao();

}

