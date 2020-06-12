package com.artimanton.coworkers.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bws_coworkers")
public class Coworker {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int age;
    private String phone;
    private String gender;

    public Coworker(String name, int age, String phone, String gender) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }
}
