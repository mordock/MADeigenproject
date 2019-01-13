package com.example.maxwe.questapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.List;

public class MainViewModel extends ViewModel {
    private QuestRepository repository;
    private LiveData<List<Quest>> quests;
    public MainViewModel(Context context){
        repository = new QuestRepository(context);
        quests = repository.getAllQuests();
    }

    public LiveData<List<Quest>> getQuests(){return quests;}

    public void insert(Quest quest){repository.insert(quest);}

    public void update(Quest quest){repository.update(quest);}

    public void delete(Quest quest){repository.delete(quest);}
}
