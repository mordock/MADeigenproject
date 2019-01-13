package com.example.maxwe.questapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Quest.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract QuestDao questDao();

    private final static String NAME_DATABASE = "quest_db";

    private static AppDataBase instance;

    public static AppDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, AppDataBase.class, NAME_DATABASE).build();
        }
        return instance;
    }
}
