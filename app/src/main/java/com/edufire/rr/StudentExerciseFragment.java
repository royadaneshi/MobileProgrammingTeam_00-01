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

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Exercise;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class StudentExerciseFragment  extends Fragment {

    private Exercise exercise;
    private Bundle args;
    private EditText answer;
    private Button submit;
    private TextView status;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_exercise_page,container,false);

        args = getArguments();
        assert args != null;
        exercise = Exercise.getExerciseByName(args.getString("exercisename"));
        answer = view.findViewById(R.id.student_exercise_page_answer);
        submit = view.findViewById(R.id.student_exercise_page_submit);
        status = view.findViewById(R.id.student_exercise_page_status);
        if (exercise!=null){ fillFields(exercise);}
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answer.getText().toString().equals("")){
                    exercise.setAnswer(answer.getText().toString(), Student.getActiveUser().getUsername());
                    //save to db
                    DataBase.setPrefs("user", DataBase.convertUserHashMapToString(User.getUsers()), getActivity(), "ProfessorsData");
                    DataBase.setPrefs("professor", DataBase.convertProfessorHashMapToString(Professor.getAllProfessors()), getActivity(), "ProfessorsData");
                    DataBase.setPrefs("student", DataBase.convertStudentHashMapToString(Student.getAllStudents()), getActivity(), "ProfessorsData");
                    DataBase.setPrefs("course", DataBase.convertCourseHashMapToString(Course.getClasses()), getActivity(), "ProfessorsData");
                    DataBase.setPrefs("exercise", DataBase.convertExerciseHashMapToString(Exercise.getExercises()), getActivity(), "ProfessorsData");
                    ArrayList<Exercise> exercisesList1 = new ArrayList<>(Exercise.getExercises().values());
                    for (int j = 0; j < exercisesList1.size(); j++) {
                        DataBase.setPrefs("StudentsAnswers", DataBase.convertStudentAnswersArrayListToString(exercisesList1.get(j).getStudentsAnswers()), getActivity(), "ProfessorsData");
                    }
                    //
                }else{
                    Snackbar snackbar = Snackbar
                            .make(v, "please enter your answer", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
        return view;
    }

    @SuppressLint("SetTextI18n")
    public void fillFields(Exercise exercise){
        if (exercise.getAnswer()==null){
            status.setText("Enter Your Answer");
        }else{
            status.setText("Exercise to be graded!");
            answer.setText(exercise.getAnswer());
        }
        System.out.println("before condition "+exercise.getAnswer());
        if (exercise.getGrade()!=null){
            System.out.println("After Condition"+exercise.getGrade());
            status.setText("Your Exercise grade is" + exercise.getGrade());
            submit.setEnabled(false);
            answer.setEnabled(false);
        }
    }
}
