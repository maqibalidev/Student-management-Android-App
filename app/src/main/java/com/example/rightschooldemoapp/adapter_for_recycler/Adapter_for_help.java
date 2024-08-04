package com.example.rightschooldemoapp.adapter_for_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Models_for_recycler.Model_for_help;
import com.example.rightschooldemoapp.R;

import java.util.ArrayList;


public class Adapter_for_help extends RecyclerView.Adapter<Adapter_for_help.viewHolder> {
ArrayList<Model_for_help> list;
Context context;

    public Adapter_for_help(ArrayList<Model_for_help> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(context).inflate(R.layout.sample_help,parent,false);
     return new viewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
Model_for_help model = list.get(position);

        holder.title.setText(model.getTitle());
        holder.details.setText(model.getDetail());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {


        TextView title,details;
        public viewHolder(@NonNull View itemView) {


            super(itemView);
            title =itemView.findViewById(R.id.help_title);
            details=itemView.findViewById(R.id.help_details);

        }
    }


}


