package com.edufire.rr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfessorPanelFragment extends Fragment {

    private Button createClassBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_professor_panel,container,false);

        createClassBtn = view.findViewById(R.id.professor_create_class);

        createClassBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfessorPanelFragment.this)
                        .navigate(R.id.action_professorPanelFragment_to_professorCreateClassActivity);
            }
        });

        return view;
    }
}