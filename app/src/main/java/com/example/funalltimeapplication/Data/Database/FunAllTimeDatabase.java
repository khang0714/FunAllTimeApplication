package com.example.funalltimeapplication.Data.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.funalltimeapplication.Data.DAO.UserDAO;
import com.example.funalltimeapplication.Data.Entity.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class FunAllTimeDatabase extends RoomDatabase {
    public abstract UserDAO getUserDao();

    private static FunAllTimeDatabase INSTANCE;

    public static synchronized FunAllTimeDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    FunAllTimeDatabase.class,"word_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
