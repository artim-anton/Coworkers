package com.artimanton.coworkers;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CoworkerViewModel coworkerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final CoworkerAdapter adapter = new CoworkerAdapter();
        recyclerView.setAdapter(adapter);
        coworkerViewModel = ViewModelProviders.of(this).get(CoworkerViewModel.class);
        coworkerViewModel.getAllCoworkers().observe(this, new Observer<List<Coworker>>() {
            @Override
            public void onChanged(@Nullable List<Coworker> coworkers) {
                adapter.setNotes(coworkers);
            }
        });
    }
}