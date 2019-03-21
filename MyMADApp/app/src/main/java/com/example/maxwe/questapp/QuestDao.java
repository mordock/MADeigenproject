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
    LiveData<List<Quest>> getAllquests();

    @Insert
    void insertQuests(Quest quest);

    @Delete
    void deleteQuests(Quest quest);

    @Update
    void updateQuests(Quest quest);
}
