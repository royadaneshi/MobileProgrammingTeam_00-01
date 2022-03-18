package com.edufire.rr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Exercise;

import java.util.HashMap;

public class ExerciseProfessorList extends Fragment {

    HashMap<String, Exercise> answers = new HashMap<>();
    private RecyclerView recyclerView;
    Bundle bundle = new Bundle();
    String exerciseName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_exercise_professor_list, container, false);
        exerciseName = bundle.getString("exerciseName");
        answers.putAll(Course.getActiveCourse().getExerciseByName(exerciseName).getStudentsAnswer());


        recyclerView = view.findViewById(R.id.exerciseProfessorListRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ExecriseProfessorListAdapter(answers));
        return view;
    }
}