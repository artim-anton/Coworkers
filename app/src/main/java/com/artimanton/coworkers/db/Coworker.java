package com.artimanton.coworkers.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bws_coworkers")
public class Coworker {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int age;
    public String phone;
    public String gender;

    public Coworker(String name, int age, String phone, String gender) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }
}
