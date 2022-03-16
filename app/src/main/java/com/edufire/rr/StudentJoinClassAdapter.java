package com.edufire.rr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;

import java.util.ArrayList;

public class StudentJoinClassAdapter extends RecyclerView.Adapter<StudentJoinClassAdapter.ViewHolder> {

    ArrayList<Course> courses;

    public StudentJoinClassAdapter(ArrayList<Course> courses){
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_join_class_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.classname.setText(courses.get(position).getName());
        holder.profName.setText(courses.get(position).getProfessor().getCompleteName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView classname;
        private final TextView profName;
        private final TextView button;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            classname = itemView.findViewById(R.id.student_join_class_class_name_txt);
            profName = itemView.findViewById(R.id.student_join_class_prof_name);
            button = itemView.findViewById(R.id.student_panel_join_class_btn);
        }

        public TextView getClassname() {
            return classname;
        }

        public TextView getProfName() {
            return profName;
        }
    }
}
