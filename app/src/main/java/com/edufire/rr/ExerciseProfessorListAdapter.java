package com.edufire.rr;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExerciseProfessorListAdapter extends RecyclerView.Adapter<ExerciseProfessorListAdapter.ViewHolder> {
    HashMap<String, Exercise> exercises = new HashMap<>();
    ArrayList<String> students = new ArrayList<>();
    ArrayList<Exercise> exercisesList = new ArrayList<>();

    public ExerciseProfessorListAdapter(HashMap<String, Exercise> exercises) {
        this.exercises = exercises;
        if (students == null){
            students = new ArrayList<String>();
            exercisesList = new ArrayList<>();
        }
        students.addAll(exercises.keySet());
        exercisesList.addAll(exercises.values());
        System.out.println(exercises.size());
    }


    @NonNull
    @Override
    public ExerciseProfessorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("/hhhhhhhhhhhhhereeeeeeeee");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_professor_exercise_answer_row, parent, false);
        for (String student : students) {
            System.out.println(student);
        }
        return new ViewHolder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studentName.setText(students.get(position));
        holder.answer.setText(exercisesList.get(position).getAnswer());

        if (exercisesList.get(position).getGrade() == null) {
            exercisesList.get(position).setGrade("0");
        }
        holder.score.setText(exercisesList.get(position).getGrade());
        String temp_student = students.get(position);
        holder.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////
                    Objects.requireNonNull(exercises.get(temp_student)).setGrade(holder.score.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView answer;
        EditText score;
        Button submit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.studentNameAnswerProfessor);
            answer = itemView.findViewById(R.id.answerExerciseProfessor);
            score = itemView.findViewById(R.id.Grade);
            submit = itemView.findViewById(R.id.submmitBtn);

        }
    }

}
