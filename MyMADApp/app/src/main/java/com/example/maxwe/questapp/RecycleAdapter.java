package com.example.maxwe.questapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<Quest> questList;

    public RecycleAdapter(List<Quest> questList){
        this.questList = questList;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder viewHolder, int i) {
        Quest quest = questList.get(i);
        viewHolder.titleView.setText(quest.getTitle());
        viewHolder.descriptionView.setText(quest.getDescription());
        viewHolder.typeView.setText(quest.getType());
    }

    @Override
    public int getItemCount() {
        return questList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titleView;
        public TextView descriptionView;
        public TextView typeView;

        public ViewHolder(View itemView){
            super(itemView);
            titleView = itemView.findViewById(R.id.title_textview);
            descriptionView = itemView.findViewById(R.id.description_textview);
            typeView = itemView.findViewById(R.id.type_textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickPos = getAdapterPosition();
        }
    }

    public void swapList (List<Quest> newList) {
        questList = newList;
        if (newList != null) {
            this.notifyDataSetChanged();
        }
    }

    public void setData(List<Quest> questList){this.questList = questList;}
}
