package com.artimanton.coworkers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoworkerAdapter extends RecyclerView.Adapter<CoworkerAdapter.NoteHolder> {
        private List<Coworker> coworkers = new ArrayList<>();
        @NonNull
        @Override
        public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.coworker_item, parent, false);
            return new NoteHolder(itemView);
        }
        @Override
        public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
            Coworker currentCoworker = coworkers.get(position);
            holder.textViewPhone.setText(currentCoworker.name);
            holder.textViewAge.setText(currentCoworker.age);
            holder.textViewPhone.setText(String.valueOf(currentCoworker.phone));
            holder.textViewGender.setText(String.valueOf(currentCoworker.gender));

        }
        @Override
        public int getItemCount() {
            return coworkers.size();
        }
        public void setNotes(List<Coworker> coworkers) {
            this.coworkers = coworkers;
            notifyDataSetChanged();
        }
        class NoteHolder extends RecyclerView.ViewHolder {
            private TextView textViewName;
            private TextView textViewAge;
            private TextView textViewPhone;
            private TextView textViewGender;
            public NoteHolder(View itemView) {
                super(itemView);
                textViewName = itemView.findViewById(R.id.text_view_name);
                textViewAge = itemView.findViewById(R.id.text_view_age);
                textViewPhone = itemView.findViewById(R.id.text_view_phone);
                textViewGender = itemView.findViewById(R.id.text_view_gender);
            }
        }
    }
