package com.edufire.rr;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.User;

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
                 new Course(className.getText().toString(),Professor.getProfessor(User.getActiveUser().getUsername()));

                 // back to last page
                Intent myIntent = new Intent(view.getContext(), ProfessorPanelFragment.class);
                startActivity(myIntent);
            }
        });
    }
}
