package com.edufire.rr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class StudentFragment extends Fragment {
    private Button registerStudent;
    private EditText username;
    private EditText completeName;
    private EditText studentId;
    private EditText password;
    private TextView textView;
    private Button back;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student, container, false);

        registerStudent = view.findViewById(R.id.registerstudent);
        username = view.findViewById(R.id.usernameStudent);
        completeName = view.findViewById(R.id.completeNameStudent);
        studentId = view.findViewById(R.id.studentIdStudent);
        password = view.findViewById(R.id.passwordStudent);
        textView = view.findViewById(R.id.textViewStudent);
        back = view.findViewById(R.id.backBtnStudent);

        registerStudent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().equals("") && !password.getText().toString().equals("")  && !completeName.getText().toString().equals("") && !studentId.getText().toString().equals("")) {
                    int numberOfStudentId = Integer.parseInt(studentId.getText().toString());
                    if (!User.doesTheUserExist(username.getText().toString())) {
                        new Student(username.getText().toString(), password.getText().toString(), completeName.getText().toString(), numberOfStudentId);
                        Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                        startActivity(myIntent);
                    } else {
                        textView.setText("User with this username already exists");
                    }
                } else {
                    textView.setText("Fill all the fields");
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });
        return view;
    }
}