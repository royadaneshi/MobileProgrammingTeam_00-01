package com.edufire.rr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.User;

import java.util.ArrayList;

public class ProfessorMyClassListActivity  extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Course> courses;

    Professor professor = Professor.getProfessor(User.getActiveUser().getUsername());

    public void createFakeData(){
        for (int i = 0; i <5 ; i++) {
            courses.add(new Course(Integer.toString(i),professor));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        createFakeData();

        View view = inflater.inflate(R.layout.fragment_professor_my_classes,container,false);


        recyclerView = view.findViewById(R.id.prof_class_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProfessorMyClassesAdapter(courses));

        return view;
    }
}
