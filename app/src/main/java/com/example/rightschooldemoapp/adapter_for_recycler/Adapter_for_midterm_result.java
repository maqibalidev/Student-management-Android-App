package com.example.rightschooldemoapp.adapter_for_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Models_for_recycler.Model_for_midterm_result;
import com.example.rightschooldemoapp.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;

public class Adapter_for_midterm_result extends  RecyclerView.Adapter<Adapter_for_midterm_result.viewHolder> implements Filterable {

    ArrayList<Model_for_midterm_result> list;
    Context context;
    ArrayList<Model_for_midterm_result> backup;

    public Adapter_for_midterm_result(ArrayList<Model_for_midterm_result> list, Context context) {
        this.list = list;
        this.context = context;
        backup = new ArrayList<>(list);

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_mdterm_result,parent,false);




        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_for_midterm_result model = list.get(position);


        holder.text.setText(model.getResult_month());


        holder.dropDown.setImageResource(model.getImage());
        holder.drop_d.setImageResource(model.getDrop_down());



        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get().load(model.getResult_image()).resize(720, 1080).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);
                holder.drop_d.setVisibility(View.GONE);
                holder.image.setVisibility(View.VISIBLE);
                holder.dropDown.setVisibility(View.VISIBLE);
                holder.dropDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.image.setVisibility(View.GONE);
                        Picasso.get().load(model.getResult_image()).resize(720, 200).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);
                        holder.drop_d.setVisibility(View.VISIBLE);
                        holder.dropDown.setVisibility(View.GONE);
                    }
                });
            }
        });



        holder.drop_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.image.setVisibility(View.VISIBLE);
                holder.drop_d.setVisibility(View.GONE);
                Picasso.get().load(model.getResult_image()).resize(720, 1080).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);

                holder.dropDown.setVisibility(View.VISIBLE);
                holder.dropDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Picasso.get().load(model.getResult_image()).resize(720, 200).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);
                        holder.image.setVisibility(View.GONE);
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

    @Override
    public Filter getFilter() {
        return filter;






    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            ArrayList<Model_for_midterm_result> newData = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {


                newData.addAll(backup);


            } else {

                for (Model_for_midterm_result ob : backup) {

                    if (ob.getResult_month().toString().toLowerCase().trim().contains(charSequence.toString().toLowerCase().trim())) {


                        newData.add(ob);


                    }


                }


            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = newData;
            return filterResults;

        }



        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults){

                list.clear();
                list.addAll((Collection<? extends Model_for_midterm_result>) filterResults.values);

                notifyDataSetChanged();


            }

    };


    public  class viewHolder extends RecyclerView.ViewHolder  {



        TextView text;
        PhotoView image;
        ImageView dropDown, drop_d;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.midter_result_month);
            image=itemView.findViewById(R.id.midterm_result_image);
            dropDown=itemView.findViewById(R.id.drop_up_resilt);
            drop_d=itemView.findViewById(R.id.drop_down_resilt);


        }
    }


}
