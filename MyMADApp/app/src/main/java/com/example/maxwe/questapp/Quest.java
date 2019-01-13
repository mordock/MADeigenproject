package com.example.maxwe.questapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

@Entity(tableName = "quest")
public class Quest {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "titleText")
    private String title;

    @ColumnInfo(name = "descriptionText")
    private String description;

    @ColumnInfo(name = "type")
    private String type;

    public Quest(String title, String description, String type){
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public String getType(){return type;}
    public void setType(String type){this.type = type;}
}
