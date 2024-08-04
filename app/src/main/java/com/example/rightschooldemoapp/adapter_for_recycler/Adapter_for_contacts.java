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

import com.example.rightschooldemoapp.Models_for_recycler.Model_for_contacts;
import com.example.rightschooldemoapp.R;

import java.util.ArrayList;
import java.util.Collection;

public class Adapter_for_contacts extends RecyclerView.Adapter<Adapter_for_contacts.viewHolder> implements Filterable {
ArrayList<Model_for_contacts> list;
Context context;
ArrayList<Model_for_contacts> backup;

    public Adapter_for_contacts(ArrayList<Model_for_contacts> list, Context context) {
        this.list = list;
        this.context = context;
        backup=new ArrayList<>(list);

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.sample_contact,parent,false);



        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_for_contacts model =list.get(position);

        holder.admin_name.setText(model.getTeacher_name());
        holder.admin_data.setText(model.getTeacher_data());
        holder.admin_pic.setImageResource(model.getTeacher_pic());
        holder.contact.setImageResource(model.getTeacher_number());
        holder.drop_up.setImageResource(model.getDrop_up());
        holder.drop_down.setImageResource(model.getDrop_down());


        holder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+model.getNum()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);




            }
        });





        holder.admin_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.admin_data.setMaxHeight(500);
                holder.drop_down.setVisibility(View.GONE);
                holder.drop_up.setVisibility(View.VISIBLE);
                holder.drop_up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        holder.admin_data.setMaxHeight(63);
                        holder.drop_down.setVisibility(View.VISIBLE);
                        holder.drop_up.setVisibility(View.GONE);
                    }
                });
            }
        });




        holder.drop_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.admin_data.setMaxHeight(300);
                holder.drop_down.setVisibility(View.GONE);
                holder.drop_up.setVisibility(View.VISIBLE);
                holder.drop_up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        holder.admin_data.setMaxHeight(63);
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


            ArrayList<Model_for_contacts> newList = new ArrayList<>();


            if (charSequence.toString().isEmpty()){

                newList.addAll(backup);

            }
            else {

                for (Model_for_contacts ob:backup){


                    if (ob.getTeacher_name().toString().toLowerCase().trim().contains(charSequence.toString().toLowerCase().trim())){


                        newList.add(ob);



                    }


                }




            }


            FilterResults filterResults = new FilterResults();
            filterResults.values =newList;
            return filterResults;



        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

      list.clear();

      list.addAll((Collection<? extends Model_for_contacts>) filterResults.values);

      notifyDataSetChanged();




        }
    };









    public class viewHolder extends RecyclerView.ViewHolder {

        TextView admin_name,admin_data;
        ImageView admin_pic,contact,drop_down,drop_up;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            admin_name=itemView.findViewById(R.id.admin_name);
            admin_data=itemView.findViewById(R.id.admin_data);
            admin_pic=itemView.findViewById(R.id.admin_pic);
          contact=itemView.findViewById(R.id.admin_number);
          drop_down=itemView.findViewById(R.id.admin_down_event);
           drop_up=itemView.findViewById(R.id.admin_drop_up);

        }
    }
}
