package com.example.rightschooldemoapp.adapter_for_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Models_for_recycler.Model_for_Noti_Frag;
import com.example.rightschooldemoapp.R;

import java.util.ArrayList;

public class Adapter_for_FragNoti  extends  RecyclerView.Adapter<Adapter_for_FragNoti.viewHolder>{

ArrayList<Model_for_Noti_Frag> list;
Context context;

    public Adapter_for_FragNoti(ArrayList<Model_for_Noti_Frag> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.sample_for_noti_frag,parent,false);
       return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_for_Noti_Frag model =list.get(position);

        holder.title.setText(model.getNoti_titile());
        holder.details.setText(model.getNoti_details());

        holder.date.setText(model.getNoti_date());

        holder.dropDown.setImageResource(model.getImage());
        holder.drop_d.setImageResource(model.getDrop_down());

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

        TextView  title,details, date;
        ImageView dropDown, drop_d;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.noti_frag_title);
            details=itemView.findViewById(R.id.noti_frag_details);
            date=itemView.findViewById(R.id.noti_frag_date);
            dropDown=itemView.findViewById(R.id.drop_up_noti_fragt);
            drop_d=itemView.findViewById(R.id.drop_down_noti_frag);
        }
    }

}
