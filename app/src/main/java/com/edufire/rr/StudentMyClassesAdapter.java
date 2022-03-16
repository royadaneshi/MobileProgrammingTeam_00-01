package com.edufire.rr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;

import java.util.ArrayList;

public class StudentMyClassesAdapter extends RecyclerView.Adapter<StudentMyClassesAdapter.ViewHolder> {

    ArrayList<Course> courses;

    public StudentMyClassesAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView className;
        private final TextView profName;
        private final Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.student_my_class_name_txt);
            profName = itemView.findViewById(R.id.student_my_class_prof_name_txt);
            button = itemView.findViewById(R.id.student_my_class_open_class_btn);
        }

        public TextView getClassName() {
            return className;
        }

        public TextView getProfName(){
            return profName;
        }
    }


    @NonNull
    @Override
    public StudentMyClassesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_class_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentMyClassesAdapter.ViewHolder holder, int position) {
        holder.className.setText(courses.get(position).getName());
        holder.profName.setText(courses.get(position).getProfessor().getCompleteName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
