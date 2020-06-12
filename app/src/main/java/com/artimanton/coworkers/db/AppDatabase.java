package com.artimanton.coworkers.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Coworker.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static  AppDatabase instance;

    public abstract CoworkerDao coworkerDao();

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "coworker_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
