package com.edufire.rr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.edufire.rr.databinding.FragmentFirstBinding;
import com.edufire.rr.models.Course;
import com.edufire.rr.models.Exercise;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;

import java.util.ArrayList;
import java.util.HashMap;

///login page
public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        //load data from dataBase to users, professors, students, classes
        loadUsers();
        loadStudents();
        loadProfessors();
        loadCourses();
        loadExercise();
        loadStudentsAnswers();
        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //for don't have account
        binding.register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_mainActivity2);
            }
        });

        binding.buttonLogin1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (User.doesTheUserExist(binding.loginUsername.getText().toString())) {
                    if (User.getUser(binding.loginUsername.getText().toString()).getPassword().equals(binding.loginPassword.getText().toString())) {
                        if (User.getUser(binding.loginUsername.getText().toString()).isStudent()) {
                            //login to student panel
                            NavHostFragment.findNavController(FirstFragment.this)
                                    .navigate(R.id.action_FirstFragment_to_studentPanelFragment);
                        } else {
                            //login to professor panel
                            NavHostFragment.findNavController(FirstFragment.this)
                                    .navigate(R.id.action_FirstFragment_to_professorPanelFragment);
                        }
                        User.setThisUsernameActive(binding.loginUsername.getText().toString());
                    } else {
                        binding.textViewFirstFragment.setText("Password is wrong");

                    }
                } else {
                    binding.textViewFirstFragment.setText("User with this username doesn't exist");
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadUsers() {
        if (DataBase.getPrefs("user", getActivity(), "ProfessorsData") == null || DataBase.getPrefs("user", getActivity(), "ProfessorsData").equals("notfound")) {
            DataBase.setPrefs("user", DataBase.convertUserHashMapToString(User.getUsers()), getActivity(), "ProfessorsData");
        } else {
            User.setUsers(DataBase.convertStringToUserHashMap(DataBase.getPrefs("user", getActivity(), "ProfessorsData")));

        }
    }

    private void loadStudents() {
        if (DataBase.getPrefs("student", getActivity(), "ProfessorsData") == null || DataBase.getPrefs("student", getActivity(), "ProfessorsData").equals("notfound")) {
            DataBase.setPrefs("student", DataBase.convertStudentHashMapToString(Student.getAllStudents()), getActivity(), "ProfessorsData");
        } else {
            Student.setStudents(DataBase.convertStringToStudentHashMap(DataBase.getPrefs("student", getActivity(), "ProfessorsData")));

        }
    }

    private void loadProfessors() {
        if (DataBase.getPrefs("professor", getActivity(), "ProfessorsData") == null || DataBase.getPrefs("professor", getActivity(), "ProfessorsData").equals("notfound")) {
            DataBase.setPrefs("professor", DataBase.convertProfessorHashMapToString(Professor.getAllProfessors()), getActivity(), "ProfessorsData");
        } else {
            Professor.setProfessors(DataBase.convertStringToProfessorHashMap(DataBase.getPrefs("professor", getActivity(), "ProfessorsData")));
        }
    }

    private void loadCourses() {
        if (DataBase.getPrefs("course", getActivity(), "ProfessorsData") == null || DataBase.getPrefs("course", getActivity(), "ProfessorsData").equals("notfound")) {
            DataBase.setPrefs("course", DataBase.convertCourseHashMapToString(Course.getClasses()), getActivity(), "ProfessorsData");
        } else {
            Course.setClasses(DataBase.convertStringToCourseHashMap(DataBase.getPrefs("course", getActivity(), "ProfessorsData")));
        }
    }

    private void loadExercise() {
        if (DataBase.getPrefs("exercise", getActivity(), "ProfessorsData") == null || DataBase.getPrefs("exercise", getActivity(), "ProfessorsData").equals("notfound")) {
            DataBase.setPrefs("exercise", DataBase.convertExerciseHashMapToString(Exercise.getExercises()), getActivity(), "ProfessorsData");
        } else {
            Exercise.setExercises(DataBase.convertStringToExerciseHashMap(DataBase.getPrefs("exercise", getActivity(), "ProfessorsData")));
        }
    }

    private void loadStudentsAnswers() {
        if (DataBase.getPrefs("StudentsAnswers", getActivity(), "ProfessorsData") == null || DataBase.getPrefs("StudentsAnswers", getActivity(), "ProfessorsData").equals("notfound")) {
            ArrayList<Exercise> exercisesList1 = new ArrayList<>(Exercise.getExercises().values());
            for (int j = 0; j < exercisesList1.size(); j++) {
                DataBase.setPrefs("StudentsAnswers", DataBase.convertStudentAnswersArrayListToString(exercisesList1.get(j).getStudentsAnswers()), getActivity(), "ProfessorsData");
            }
        } else {
            ArrayList<Exercise> exercisesList = new ArrayList<>(Exercise.getExercises().values());
            for (int i = 0; i < exercisesList.size(); i++) {
                exercisesList.get(i).setStudentsAnswers(DataBase.convertStringToStudentAnswersArrayList(DataBase.getPrefs("StudentsAnswers", getActivity(), "ProfessorsData")));

            }
        }
    }

}