package com.example.rightschooldemoapp.adapter_for_recycler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Models_for_recycler.Model_for_tracehrs;
import com.example.rightschooldemoapp.R;

import java.util.ArrayList;
import java.util.Collection;

public class Adapter_for_teachers extends RecyclerView.Adapter<Adapter_for_teachers.viewHolder>  implements Filterable {

    ArrayList<Model_for_tracehrs > list;
    ArrayList<Model_for_tracehrs> backup;

    Context context;

    public Adapter_for_teachers(ArrayList<Model_for_tracehrs> list, Context context) {
        this.list = list;
        this.context = context;
        backup=new ArrayList<>(list);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.sample_teachers,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_for_tracehrs model= list.get(position);


        holder.name.setText(model.getTeacher_name());
        holder.data.setText(model.getTeacher_data());
        holder.number.setImageResource(model.getTeacher_number());
holder.teacher_pic.setImageResource(model.getTeacher_pic());
holder.drop_down.setImageResource(model.getDrop_down());
holder.drop_up.setImageResource(model.getDrop_up());

holder.number.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent =new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: "+model.getNum()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);




    }
});





holder.data.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        holder.data.setMaxHeight(500);
        holder.drop_down.setVisibility(View.GONE);
        holder.drop_up.setVisibility(View.VISIBLE);
        holder.drop_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.data.setMaxHeight(63);
                holder.drop_down.setVisibility(View.VISIBLE);
                holder.drop_up.setVisibility(View.GONE);
            }
        });
    }
});




holder.drop_down.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        holder.data.setMaxHeight(300);
holder.drop_down.setVisibility(View.GONE);
holder.drop_up.setVisibility(View.VISIBLE);
holder.drop_up.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        holder.data.setMaxHeight(63);
holder.drop_down.setVisibility(View.VISIBLE);
holder.drop_up.setVisibility(View.GONE);
    }
});


    }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            ArrayList<Model_for_tracehrs> new_data = new ArrayList<>();

            if (charSequence.toString().isEmpty()){

                new_data.addAll(backup);


            }
            else
            {

                for (Model_for_tracehrs  obj : backup) {


                    if (obj.getTeacher_name().toString().toLowerCase().trim().contains(charSequence.toString().toLowerCase().trim())) {


                        new_data.add(obj);

                    }
                }

                }









           FilterResults filterResults = new FilterResults();
            filterResults.values = new_data;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            list.clear();
         list.addAll((Collection<? extends Model_for_tracehrs>) filterResults.values);
            notifyDataSetChanged();
        }
    };







    public class viewHolder extends RecyclerView.ViewHolder {

        TextView name,data;
        ImageView number,teacher_pic,drop_down,drop_up;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.teacher_name);
            data=itemView.findViewById(R.id.teachers_data);
            number=itemView.findViewById(R.id.teachers_number);
teacher_pic = itemView.findViewById(R.id.teachers_pic);
drop_down = itemView.findViewById(R.id.drop_down_event);
drop_up= itemView.findViewById(R.id.drop_up);

        }
    }


}
