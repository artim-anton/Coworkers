package com.artimanton.coworkers;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.artimanton.coworkers.db.AppDatabase;
import com.artimanton.coworkers.db.Coworker;
import com.artimanton.coworkers.db.CoworkerDao;

import java.util.List;

public class CoworkerRepository {
    private CoworkerDao coworkerDao;
    private LiveData<List<Coworker>> allCoworker;
    public CoworkerRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        coworkerDao = database.coworkerDao();
        allCoworker = coworkerDao.getAllLiveData();
    }
    public void insert(Coworker coworker) {
        new InsertCoworkerAsyncTask(coworkerDao).execute(coworker);
    }
    public void update(Coworker Coworker) {
        new UpdateCoworkerAsyncTask(coworkerDao).execute(Coworker);
    }
    public void delete(Coworker Coworker) {
        new DeleteCoworkerAsyncTask(coworkerDao).execute(Coworker);
    }
    public void deleteAllCoworkers() {
        new DeleteAllCoworkersAsyncTask(coworkerDao).execute();
    }
    public LiveData<List<Coworker>> getAllCoworkers() {
        return allCoworker;
    }
    private static class InsertCoworkerAsyncTask extends AsyncTask<Coworker, Void, Void> {
        private CoworkerDao coworkerDao;
        private InsertCoworkerAsyncTask(CoworkerDao coworkerDao) {
            this.coworkerDao = coworkerDao;
        }
        @Override
        protected Void doInBackground(Coworker... coworkers) {
            coworkerDao.insert(coworkers[0]);
            return null;
        }
    }
    private static class UpdateCoworkerAsyncTask extends AsyncTask<Coworker, Void, Void> {
        private CoworkerDao coworkerDao;
        private UpdateCoworkerAsyncTask(CoworkerDao CoworkerDao) {
            this.coworkerDao = CoworkerDao;
        }
        @Override
        protected Void doInBackground(Coworker... coworkers) {
            coworkerDao.update(coworkers[0]);
            return null;
        }
    }
    private static class DeleteCoworkerAsyncTask extends AsyncTask<Coworker, Void, Void> {
        private CoworkerDao coworkerDao;
        private DeleteCoworkerAsyncTask(CoworkerDao coworkerDao) {
            this.coworkerDao = coworkerDao;
        }
        @Override
        protected Void doInBackground(Coworker... coworkers) {
            coworkerDao.delete(coworkers[0]);
            return null;
        }
    }
    private static class DeleteAllCoworkersAsyncTask extends AsyncTask<Void, Void, Void> {
        private CoworkerDao coworkerDao;
        private DeleteAllCoworkersAsyncTask(CoworkerDao coworkerDao) {
            this.coworkerDao = coworkerDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            coworkerDao.deleteAllCoworker();
            return null;
        }
    }
}