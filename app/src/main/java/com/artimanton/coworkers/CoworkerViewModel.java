package com.artimanton.coworkers;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.artimanton.coworkers.db.Coworker;

import java.util.List;

public class CoworkerViewModel extends AndroidViewModel {
    private CoworkerRepository repository;
    private LiveData<List<Coworker>> allCoworkers;

    public CoworkerViewModel(@NonNull Application application) {
        super(application);
        repository = new CoworkerRepository(application);
        allCoworkers = repository.getAllCoworkers();
    }

    public void insert(Coworker coworker) {
        repository.insert(coworker);
    }
    public void update(Coworker coworker) {
        repository.update(coworker);
    }
    public void delete(Coworker coworker) {
        repository.delete(coworker);
    }
    public void deleteAllCoworkers() {
        repository.deleteAllCoworkers();
    }
    public LiveData<List<Coworker>> getAllCoworkers() {
        return allCoworkers;
    }
}
