package com.example.maxwe.questapp;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class QuestRepository {
    private AppDataBase dataBase;
    private QuestDao questDao;
    private LiveData<List<Quest>> quests;
    private Executor executor = Executors.newSingleThreadExecutor();

    public QuestRepository(Context context){
        dataBase = AppDataBase.getInstance(context);
        questDao = dataBase.questDao();
        quests = questDao.getAllquests();
    }

    public LiveData<List<Quest>> getAllQuests(){return quests;}

    public void insert(final Quest quest){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                questDao.insertQuests(quest);
            }
        });
    }

    public void update(final Quest quest){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                questDao.updateQuests(quest);
            }
        });
    }

    public void delete(final Quest quest){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                questDao.deleteQuests(quest);
            }
        });
    }
}
