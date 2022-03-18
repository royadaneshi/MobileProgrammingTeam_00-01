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

import java.util.ArrayList;


public class ProfessorExerciseList extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_professor_exercise_list, container, false);

        exercises= Course.getActiveCourse().getExercisesOfClass();
//
//        recyclerView = view.findViewById(R.id.exerciseRecycleView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        recyclerView.setAdapter(new ProfessorClassAdapter(exercises));
        return view;
    }
}