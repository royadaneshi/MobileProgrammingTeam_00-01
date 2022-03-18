package com.edufire.rr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.edufire.rr.models.Exercise;
import com.edufire.rr.models.User;

public class ProfessorClassFragment extends Fragment {

    Bundle args;
    TextView classname;
    Button createExercise;
    EditText exerciseName;
    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = getArguments();
        View view = inflater.inflate(R.layout.fragment_professor_class, container, false);
        classname = view.findViewById(R.id.prof_my_class_txt);
        createExercise = view.findViewById(R.id.createExercise);
        exerciseName = view.findViewById(R.id.exerciseName);

        if (args == null) {
            classname.setText("this is null");
        } else classname.setText(args.getString("classname"));


        createExercise.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
              //  new Exercise(exerciseName.getText().toString(),, User.getActiveUser());

            }
        });

        return view;
    }
}
