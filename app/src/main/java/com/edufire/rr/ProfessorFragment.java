package com.edufire.rr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edufire.rr.databinding.FragmentFirstBinding;

public class ProfessorFragment extends Fragment {


    private Button registerProfessor;
    private EditText username;
    private EditText completeName;
    private EditText universityName;
    private EditText password;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_professor, container, false);

        registerProfessor = view.findViewById(R.id.registerBtnProfesssor);
        username = view.findViewById(R.id.usernameProfessor);
        completeName = view.findViewById(R.id.completeNameProfessor);
        universityName = view.findViewById(R.id.universityNameProfessor);
        password = view.findViewById(R.id.passwordProfessor);
        textView = view.findViewById(R.id.textViewProfessor);

        registerProfessor.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                new Professor(username.getText().toString(), password.getText().toString(), completeName.getText().toString(), universityName.getText().toString());
                if (!User.isUserExist) {
                    Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(myIntent);
                } else {
                    textView.setText("User with this username already exists");
                }
            }
        });
        return view;

    }


}