package com.edufire.rr;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class StudentJoinClassActivity extends Fragment {

    private RecyclerView recyclerView;
    private EditText classname;
    private Button joinClassByNameBtn;
    private ArrayList<Course> courses = new ArrayList<>();

    Student student = Student.getStudent(User.getActiveUser().getUsername());


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        courses.addAll(student.getAvailableCourses());
        View view = inflater.inflate(R.layout.fragment_student_join_class,container,false);
        recyclerView = view.findViewById(R.id.student_join_class_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new StudentJoinClassAdapter(courses));

        classname = view.findViewById(R.id.student_join_class_name_edit_txt);
        joinClassByNameBtn = view.findViewById(R.id.join_by_name_btn);
        joinClassByNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = Course.getCourseByName(classname.getText().toString());
                if (course != null){
                    student.joinClass(course);
                    //todo db for join class(done!)
                    //save to db
                    DataBase.setPrefs("user", DataBase.convertUserHashMapToString(User.getUsers()), getActivity(), "ProfessorsData");
                    DataBase.setPrefs("professor", DataBase.convertProfessorHashMapToString(Professor.getAllProfessors()), getActivity(), "ProfessorsData");
                    DataBase.setPrefs("student", DataBase.convertStudentHashMapToString(Student.getAllStudents()), getActivity(), "ProfessorsData");
                    DataBase.setPrefs("course",DataBase.convertCourseHashMapToString(Course.getClasses()), getActivity(),"ProfessorsData");
                    //
                }else{
                    Snackbar snackbar = Snackbar
                            .make(view, "Course not found!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        return view;
    }
}
