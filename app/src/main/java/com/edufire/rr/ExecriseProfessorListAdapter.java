package com.edufire.rr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class ExecriseProfessorListAdapter extends RecyclerView.Adapter<ExecriseProfessorListAdapter.ViewHolder> {
    HashMap<String, Exercise> exercises = new HashMap<>();
    ArrayList<String> students = new ArrayList<>(exercises.keySet());
    ArrayList<Exercise> exercisesList = new ArrayList<>(exercises.values());

    public ExecriseProfessorListAdapter(HashMap<String, Exercise> exercises) {
        this.exercises = exercises;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_professor_exercise_answer_row, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studentName.setText(students.get(position));
        holder.answer.setText(exercisesList.get(position).getAnswer());
        if (exercisesList.get(position).getGrade() == null) {
            exercisesList.get(position).setGrade(0);
        }
        holder.score.setText(exercisesList.get(position).getGrade());
        holder.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText studentName;
        EditText answer;
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
