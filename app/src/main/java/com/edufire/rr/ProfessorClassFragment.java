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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Exercise;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;

public class ProfessorClassFragment extends Fragment {

    Bundle args;
    TextView classname;
    Button createExercise;
    EditText exerciseName;
    private RecyclerView recyclerView;

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
                Course.getCourseByName(classname.toString()).addExerciseToClass(new Exercise(exerciseName.getText().toString(), Course.getCourseByName(classname.toString()), Professor.getProfessor(User.getActiveUser().getUsername())));
                //save to db
                DataBase.setPrefs("user", DataBase.convertUserHashMapToString(User.getUsers()), getActivity(), "ProfessorsData");
                DataBase.setPrefs("professor", DataBase.convertProfessorHashMapToString(Professor.getAllProfessors()), getActivity(), "ProfessorsData");
                DataBase.setPrefs("student", DataBase.convertStudentHashMapToString(Student.getAllStudents()), getActivity(), "ProfessorsData");
                DataBase.setPrefs("course", DataBase.convertCourseHashMapToString(Course.getClasses()), getActivity(), "ProfessorsData");
                //
            }
        });



        recyclerView = view.findViewById(R.id.exerciseRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProfessorMyClassesAdapter(courses));//////
        return view;
    }
}
