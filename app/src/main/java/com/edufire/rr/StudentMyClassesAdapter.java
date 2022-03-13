package com.edufire.rr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edufire.rr.models.Class;

import java.util.ArrayList;

public class StudentMyClassesAdapter extends RecyclerView.Adapter<StudentMyClassesAdapter.ViewHolder> {

    Context context;
    ArrayList<Class> classes;

    public StudentMyClassesAdapter(Context context, ArrayList<Class> classArrayList) {
        this.context = context;
        classes = classes;
    }

    @NonNull
    @Override
    public StudentMyClassesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.student_class_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentMyClassesAdapter.ViewHolder holder, int position) {
        holder.className.setText(classes.get(position).getClass().getName());
        holder.profName.setText(classes.get(position).getProfessor().getUsername());
    }

    @Override
    public int getItemCount() { return classes.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView className,profName;
        Button goToClassBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.student_my_class_name_txt);
            profName = itemView.findViewById(R.id.student_my_class_prof_name_txt);
            goToClassBtn = itemView.findViewById(R.id.student_my_class_open_class_btn);
        }
    }
}
