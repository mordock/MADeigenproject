package com.example.maxwe.questapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface QuestDao {
    @Query("SELECT * FROM quest")
    public LiveData<List<Quest>> getAllquests();

    @Insert
    public void insertQuests(Quest quest);

    @Delete
    public void deleteQuests(Quest quest);

    @Update
    public void updateQuests(Quest quest);
}
