package com.edufire.rr;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;

import java.util.ArrayList;

public class StudentJoinClassActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Course> cours;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_student_join_class);

        recyclerView.findViewById(R.id.student_join_class_recycler_view);
        //todo get classes that student is not registered in
        cours = Student.getStudent(User.getActiveUser().getUsername()).getClasses() ;

        StudentJoinClassAdapter studentJoinClassAdapter = new StudentJoinClassAdapter(this, cours);
        recyclerView.setAdapter(studentJoinClassAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
