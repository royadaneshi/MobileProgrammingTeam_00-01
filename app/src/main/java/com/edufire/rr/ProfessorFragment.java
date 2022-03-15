package com.edufire.rr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edufire.rr.models.Professor;
import com.edufire.rr.models.User;

public class ProfessorFragment extends Fragment {


    private Button registerProfessor;
    private EditText username;
    private EditText completeName;
    private EditText universityName;
    private EditText password;
    private TextView textView;
    private Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_professor, container, false);

        registerProfessor = view.findViewById(R.id.registerBtnProfesssor);
        username = view.findViewById(R.id.usernameProfessor);
        completeName = view.findViewById(R.id.completeNameProfessor);
        universityName = view.findViewById(R.id.universityNameProfessor);
        password = view.findViewById(R.id.passwordProfessor);
        textView = view.findViewById(R.id.textViewProfessor);
        back = view.findViewById(R.id.backBtnProfessor);

        registerProfessor.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().equals("") && !password.getText().toString().equals("") && !completeName.getText().toString().equals("") && !universityName.getText().toString().equals("")) {
                    if (!User.doesTheUserExist(username.getText().toString())) {
                        new Professor(username.getText().toString(), password.getText().toString(), completeName.getText().toString(), universityName.getText().toString());
                        //save to sharedPreference users and professors
                        DataBase.setPrefs("user", DataBase.convertUserHashMapToString(User.getUsers()), getActivity(), "ProfessorsData");
                        DataBase.setPrefs("professor", DataBase.convertProfessorHashMapToString(Professor.getAllProfessors()), getActivity(), "ProfessorsData");
                        //
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
