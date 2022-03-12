package com.edufire.rr;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.edufire.rr.models.Class;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.User;
import com.google.android.material.snackbar.Snackbar;

public class ProfessorCreateClassActivity extends AppCompatActivity {

    private EditText className;
    private Button createBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_professor_create_class);

        className = findViewById(R.id.class_name);
        createBtn = findViewById(R.id.create_class_btn);

        className.setText(User.getActiveUser().getUsername());

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 new Class(className.getText().toString(),Professor.getProfessor(User.getActiveUser().getUsername()));
                //todo back to last page
            }
        });
    }
}
