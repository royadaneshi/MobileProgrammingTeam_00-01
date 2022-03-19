package com.edufire.rr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Exercise;

import java.util.ArrayList;

public class StudentClassAdapter extends RecyclerView.Adapter<StudentClassAdapter.ViewHolder> {

    ArrayList<Exercise> exercises = new ArrayList<>();

    public StudentClassAdapter(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_student_exercise_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (exercises.get(position)!=null){
        holder.exerciseName.setText(exercises.get(position).getNameOfExercise());
        }
        holder.gotoExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment studentExerciseFragment = new StudentExerciseFragment();
                Bundle args = new Bundle();
                args.putString("exercisename",holder.exerciseName.getText().toString());
                studentExerciseFragment.setArguments(args);
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_student_exercise_layout,studentExerciseFragment,null)
                        .addToBackStack(null)
                        .commit();
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
            exerciseName = itemView.findViewById(R.id.student_exercise_row_exercise_name);
            gotoExercise = itemView.findViewById(R.id.student_exercise_row_exercise_goto_exercise);
        }

        public TextView getExerciseName() {
            return exerciseName;
        }
    }
}
