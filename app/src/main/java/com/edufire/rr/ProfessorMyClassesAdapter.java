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

public class ProfessorMyClassesAdapter extends RecyclerView.Adapter<ProfessorMyClassesAdapter.ViewHolder> {

    Context context;
    ArrayList<Class> classes;

    public ProfessorMyClassesAdapter(Context context, ArrayList<Class> classArrayList) {
        this.context = context;
        classes = classArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.class_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.classNameTextView.setText(classes.get(position).getClass().getName());
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView classNameTextView;
        Button gotoClassBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            classNameTextView = itemView.findViewById(R.id.prof_class_list_class_name);
            gotoClassBtn = itemView.findViewById(R.id.prof_goto_class_btn);
        }
    }
}
