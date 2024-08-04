package com.example.rightschooldemoapp.adapter_for_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Models_for_recycler.Model_for_holidays;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_notificatio;
import com.example.rightschooldemoapp.R;

import java.util.ArrayList;

public class Adapter_for_notification extends RecyclerView.Adapter<Adapter_for_notification.viewHolder>{


    ArrayList<Model_for_notificatio> list;
    Context context;

    public Adapter_for_notification(ArrayList<Model_for_notificatio> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.sample_for_notification,parent,false);



        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_for_notificatio models = list.get(position);
        holder.title.setText(models.getNoti_titile());
        holder.details.setText(models.getNoti_details());

        holder.date.setText(models.getNoti_date());

holder.dropDown.setImageResource(models.getImage());
holder.drop_d.setImageResource(models.getDrop_down());


        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.details.setMaxHeight(1500);
                holder.drop_d.setVisibility(View.GONE);
                holder.dropDown.setVisibility(View.VISIBLE);
                holder.dropDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        holder.details.setMaxHeight(80);
                        holder.drop_d.setVisibility(View.VISIBLE);
                        holder.dropDown.setVisibility(View.GONE);
                    }
                });
            }
        });



holder.drop_d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

holder.drop_d.setVisibility(View.GONE);
        holder.details.setMaxHeight(1500);

        holder.dropDown.setVisibility(View.VISIBLE);
        holder.dropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.details.setMaxHeight(80);

                holder.dropDown.setVisibility(View.GONE);
                holder.drop_d.setVisibility(View.VISIBLE);
            }
        });
    }
});




    }












    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView title,details,date;
ImageView dropDown,drop_d;
        public viewHolder (@NonNull View itemView) {
            super(itemView);


            title=itemView.findViewById(R.id.notification_title);
            details=itemView.findViewById(R.id.notification_details);
          date=itemView.findViewById(R.id.notification_date);
dropDown=itemView.findViewById(R.id.drop_up_event);
drop_d=itemView.findViewById(R.id.drop_down_event);
        }
    }
}



