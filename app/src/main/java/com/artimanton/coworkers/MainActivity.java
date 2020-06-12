package com.artimanton.coworkers;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.artimanton.coworkers.db.Coworker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_NOTE_REQUEST = 1;

    private CoworkerViewModel coworkerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_coworker);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCoworkerActivity.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(AddCoworkerActivity.EXTRA_NAME);
            int age = data.getIntExtra(AddCoworkerActivity.EXTRA_AGE, 1);
            String phone = data.getStringExtra(AddCoworkerActivity.EXTRA_PHONE);
            String gender = data.getStringExtra(AddCoworkerActivity.EXTRA_GENDER);
            Coworker coworker = new Coworker(name, age, phone, gender);
            coworkerViewModel.insert(coworker);
            Toast.makeText(this, R.string.toast_saved, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.toast_not_saved, Toast.LENGTH_SHORT).show();
        }
    }
}