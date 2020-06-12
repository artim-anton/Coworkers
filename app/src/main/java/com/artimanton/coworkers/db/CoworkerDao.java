package com.artimanton.coworkers.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.artimanton.coworkers.db.Coworker;

import java.util.List;

@Dao
public interface CoworkerDao {

    @Query("SELECT * FROM bws_coworkers")
    List<Coworker> getAll();

    @Query("SELECT * FROM bws_coworkers")
    LiveData<List<Coworker>> getAllLiveData();

    @Query("SELECT * FROM bws_coworkers WHERE id = :id")
    Coworker getById(long id);

    @Insert
    void insert(Coworker coworker);

    @Update
    void update(Coworker coworker);

    @Delete
    void delete(Coworker coworker);

    @Query("DELETE FROM bws_coworkers")
    void deleteAllCoworker();
}
