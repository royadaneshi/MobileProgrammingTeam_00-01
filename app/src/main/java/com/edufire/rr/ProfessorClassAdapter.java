package com.edufire.rr;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
        Log.d(exercises.get(position).getNameOfExercise(), "onBindViewHolder: ");
        holder.exerciseName.setText(exercises.get(position).getNameOfExercise());
        Exercise tempExercise=exercises.get(position);
        holder.gotoExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity =(AppCompatActivity) v.getContext();
                Fragment professorExerciseList=new ExerciseProfessorList();
                Bundle args =new Bundle();
                args.putString("exerciseName",holder.exerciseName.getText().toString());
                professorExerciseList.setArguments(args);
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_professor_class,professorExerciseList,null)
                        .addToBackStack(null)
                        .commit();
            }
        });
        holder.applyNewExerciseName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change exercise name

                tempExercise.setNameExercise(holder.newExerciseName.getText().toString());

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
        private EditText newExerciseName;
        private Button applyNewExerciseName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseName = itemView.findViewById(R.id.prof_class_exercises_row_txt);
            gotoExercise = itemView.findViewById(R.id.prof_class_exercises_row_btn);
            newExerciseName = itemView.findViewById(R.id.newExerciseNameProfessor);
            applyNewExerciseName = itemView.findViewById(R.id.EditExerciseNameProfessorBtn);
        }

        public TextView getExerciseName() {
            return exerciseName;
        }
    }
}
