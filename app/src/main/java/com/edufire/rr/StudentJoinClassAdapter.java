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

public class StudentJoinClassAdapter extends RecyclerView.Adapter<StudentJoinClassAdapter.ViewHolder> {

    Context context;
    ArrayList<Class> classes;

    public StudentJoinClassAdapter(Context context, ArrayList<Class> classArrayList) {
        this.context = context;
        classes = classArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.student_join_class_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.className.setText(classes.get(position).getClass().getName());
        holder.profName.setText(classes.get(position).getProfessor().getUsername());
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView className,profName;
        Button joinClassBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.student_join_class_class_name_txt);
            profName = itemView.findViewById(R.id.student_join_class_prof_name);
            joinClassBtn = itemView.findViewById(R.id.student_join_class_join_btn);
        }
    }
}
