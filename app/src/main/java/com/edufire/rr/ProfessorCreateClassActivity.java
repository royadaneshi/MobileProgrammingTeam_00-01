package com.edufire.rr;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.User;

import java.util.HashMap;
import java.util.Objects;

public class ProfessorCreateClassActivity extends Fragment {

    private EditText className;
    private Button createBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_professor_create_class,container,false);

        className = view.findViewById(R.id.class_name);
        createBtn = view.findViewById(R.id.create_class_btn);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Course(className.getText().toString(),Professor.getProfessor(User.getActiveUser().getUsername()));

                //save to db
                DataBase.setPrefs("course",DataBase.convertCourseHashMapToString(Course.getClasses()), getActivity(),"ProfessorsData");
                DataBase.setPrefs("user", DataBase.convertUserHashMapToString(User.getUsers()), getActivity(), "ProfessorsData");
                DataBase.setPrefs("professor", DataBase.convertProfessorHashMapToString(Professor.getAllProfessors()), getActivity(), "ProfessorsData");
                //

                NavHostFragment.findNavController(ProfessorCreateClassActivity.this)
                        .navigate(R.id.action_professorCreateClassActivity_to_professorPanelFragment);
            }
        });

        return view;
    }
}
