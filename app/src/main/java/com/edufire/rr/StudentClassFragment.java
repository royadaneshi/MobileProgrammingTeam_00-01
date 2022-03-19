package com.edufire.rr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Exercise;
import com.edufire.rr.models.Professor;

import java.util.ArrayList;

public class StudentClassFragment extends Fragment {

    private TextView classname, profName;
    private RecyclerView recyclerView;
    private Bundle args;
    private Course course;
    private ArrayList<Exercise> exercises = new ArrayList<>();
    //todo fill exercises

    private ArrayList<Exercise> createFakeData(){
        ArrayList<Exercise> fake = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            fake.add(new Exercise(String.valueOf(i),course, Professor.getProfessor(course.getProfessor().getUsername())));
        }
        return fake;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = getArguments();
        assert args != null;
        course = Course.getCourseByName(args.getString("classname"));
        exercises.addAll(course.getExercisesArrayList());
        View view = inflater.inflate(R.layout.fragment_student_class,container,false);
        classname = view.findViewById(R.id.student_class_fragment_class_name);
        profName = view.findViewById(R.id.student_class_fragment_prof_name);
        recyclerView = view.findViewById(R.id.fragment_student_class_recyclerview);

        classname.setText(course.getName());
        profName.setText(course.getProfessor().getCompleteName());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new StudentClassAdapter(exercises));

        return view;
    }
}
