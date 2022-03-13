package com.edufire.rr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StudentPanelFragment extends Fragment {

    Button showMyClassesBtn, joinNewClassBtn ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_student_panel, container, false);

        showMyClassesBtn = view.findViewById(R.id.student_panel_my_classes_btn);
        joinNewClassBtn = view.findViewById(R.id.student_panel_join_class_btn);

        showMyClassesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentPanelFragment.this)
                        .navigate(R.id.action_studentPanelFragment_to_studentMyClassesActivity);
            }
        });

        return view;
    }
}