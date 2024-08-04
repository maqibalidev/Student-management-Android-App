package com.example.rightschooldemoapp.adapter_for_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Model_Attendence;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_TimeTable;
import com.example.rightschooldemoapp.R;

import java.util.ArrayList;

public class Adapter_Attendence extends RecyclerView.Adapter<Adapter_Attendence.viewHolder> {

    ArrayList<Model_Attendence> list1 ;
    Context context;

    public Adapter_Attendence(ArrayList<Model_Attendence> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View view = LayoutInflater.from(context).inflate(R.layout.sample_attendence,parent,false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_Attendence model_attendence= list1.get(position);

        holder.day.setText(model_attendence.getDay());
        holder.attend.setText(model_attendence.getAttendence());



    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class  viewHolder extends RecyclerView.ViewHolder {
        TextView day,attend;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            day=itemView.findViewById(R.id.attendence_day);
            attend=itemView.findViewById(R.id.attendence_time);

        }
    }

}
