package com.edufire.rr;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Class;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.User;

import java.util.ArrayList;

public class ProfessorMyClassListActivity  extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Class> classes;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_professor_my_classes);

        recyclerView.findViewById(R.id.prof_class_list_recycler_view);
        classes = Professor.getProfessor(User.getActiveUser().getUsername()).getClasses();

        ProfessorMyClassesAdapter professorMyClassesAdapter = new ProfessorMyClassesAdapter(this,classes);
        recyclerView.setAdapter(professorMyClassesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
