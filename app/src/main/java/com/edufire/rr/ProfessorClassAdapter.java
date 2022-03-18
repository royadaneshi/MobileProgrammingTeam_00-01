package com.edufire.rr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Exercise;

import java.util.ArrayList;

public class ProfessorClassAdapter extends RecyclerView.Adapter<ProfessorClassAdapter.ViewHolder> {

    ArrayList<Exercise> exercises = new ArrayList<>();

    public ProfessorClassAdapter(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_prof_excersize_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.exerciseName.setText(exercises.get(position).getNameOfExercise());
        holder.gotoExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView exerciseName;
        private final Button gotoExercise;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseName = itemView.findViewById(R.id.prof_class_exercises_row_txt);
            gotoExercise = itemView.findViewById(R.id.prof_class_exercises_row_btn);
        }

        public TextView getExerciseName() {
            return exerciseName;
        }
    }
}
