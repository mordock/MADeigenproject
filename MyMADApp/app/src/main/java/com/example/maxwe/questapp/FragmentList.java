package com.example.maxwe.questapp;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;

    List<Quest> quests;

    MainViewModel mainViewModel;

    static AppDataBase dataBase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentlist_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        quests = new ArrayList<>();

        mainViewModel = new MainViewModel(getActivity().getApplicationContext());

        mainViewModel.getQuests().observe(this, new Observer<List<Quest>>() {
            @Override
            public void onChanged(@Nullable List<Quest> quest) {
                quests = quest;
                updateUI();
            }
        });

        recyclerView = getActivity().findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        updateUI();

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int pos = (viewHolder.getAdapterPosition());

                mainViewModel.delete(quests.get(pos));

                adapter.setData(quests);
                adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void updateUI() {
        if (adapter == null) {
            adapter = new RecycleAdapter(quests);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.swapList(quests);
        }
    }
}
