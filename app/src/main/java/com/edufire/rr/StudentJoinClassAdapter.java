package com.edufire.rr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class StudentJoinClassAdapter extends RecyclerView.Adapter<StudentJoinClassAdapter.ViewHolder> {

    ArrayList<Course> courses;
    Student student = Student.getStudent(User.getActiveUser().getUsername());

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
        holder.joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinClass(holder.getClassname().getText().toString(),v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView classname;
        private final TextView profName;
        private final Button joinBtn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            classname = itemView.findViewById(R.id.student_join_class_class_name_txt);
            profName = itemView.findViewById(R.id.student_join_class_prof_name);
            joinBtn = itemView.findViewById(R.id.student_join_class_join_btn);
        }

        public TextView getClassname() {
            return classname;
        }

        public TextView getProfName() {
            return profName;
        }
    }

    private void joinClass(String classname,View view){
        Course course = Course.getCourseByName(classname);
        if (course!= null){
            student.joinClass(course);
            //todo db for join class
        }else {
            Snackbar snackbar = Snackbar
                    .make(view, "Course not found!", Snackbar.LENGTH_LONG);
            snackbar.show();

        }
    }
}
