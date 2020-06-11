package com.artimanton.coworkers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bws_coworkers")
public class Coworker {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int age;
    public String phone;
    public Boolean gender;
}
