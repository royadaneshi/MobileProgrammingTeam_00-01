package com.edufire.rr;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ProfessorMyClassesAdapter extends RecyclerView.Adapter<ProfessorMyClassesAdapter.ViewHolder> {

    ArrayList<Course> courseList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView className;
        private final Button button;

        public ViewHolder(View view) {
            super(view);
            className = view.findViewById(R.id.prof_class_list_class_name);
            button = view.findViewById(R.id.prof_goto_class_btn);
        }

        public TextView getClassName() {
            return className;
        }
    }

    public ProfessorMyClassesAdapter(ArrayList<Course> courses) {
        courseList = courses;
    }


    @NonNull
    @Override
    public ProfessorMyClassesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.class_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorMyClassesAdapter.ViewHolder holder, int position) {
        holder.className.setText(courseList.get(position).getName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment professorClassFragment = new ProfessorClassFragment();

                Bundle args = new Bundle();
                args.putString("classname",holder.className.getText().toString());

                professorClassFragment.setArguments(args);
                Log.d("args", professorClassFragment.getArguments().toString());
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_professor_my_class_list, professorClassFragment,null)
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}
