package com.edufire.rr;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;

import java.util.ArrayList;

public class StudentJoinClassActivity extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Course> courses = new ArrayList<>();

    private void createFakeData(){
        for (int i = 0; i <5 ; i++) {
            courses.add(new Course(String.valueOf(i), Professor.getProfessor("prof")));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createFakeData();
        View view = inflater.inflate(R.layout.fragment_student_join_class,container,false);
        recyclerView = view.findViewById(R.id.student_join_class_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new StudentJoinClassAdapter(courses));

        return view;
    }
}
