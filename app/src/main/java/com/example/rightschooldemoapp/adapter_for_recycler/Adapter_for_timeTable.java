package com.example.rightschooldemoapp.adapter_for_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Models_for_recycler.Model_for_TimeTable;
import com.example.rightschooldemoapp.R;

import java.util.ArrayList;

public class Adapter_for_timeTable  extends RecyclerView.Adapter<Adapter_for_timeTable.viewHolder>{


    ArrayList<Model_for_TimeTable> list;
    Context context;

    public Adapter_for_timeTable(ArrayList<Model_for_TimeTable> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tima_tablesample_recycler_view,parent,false);


        return new viewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_for_TimeTable model= list.get(position);

        holder.class_time.setText(model.getClass_time());
        holder.day_time_table.setText(model.getDay_timeTable());
        holder.time_time.setText(model.getTime_timeTable());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView class_time,day_time_table,time_time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            class_time=itemView.findViewById(R.id.classTimeTale);
            day_time_table=itemView.findViewById(R.id.dayTimeTable);
            time_time=itemView.findViewById(R.id.TimeTimeTable);

        }
    }

}
