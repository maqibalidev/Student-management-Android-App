package com.example.rightschooldemoapp.adapter_for_recycler;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.service.autofill.VisibilitySetterAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rightschooldemoapp.Image_on_FullScreen;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_homeWork;
import com.example.rightschooldemoapp.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class Adapter_for_homeWork extends RecyclerView.Adapter<Adapter_for_homeWork.viewHolder>{

    ArrayList<Model_for_homeWork> list ;
    Context context;

    public Adapter_for_homeWork(ArrayList<Model_for_homeWork> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_homework,parent,false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model_for_homeWork model = list.get(position);

        Picasso.get().load(model.getHomeWork_img()).resize(720, 200).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);
        holder.text.setText(model.getHomeWorkDate());



        holder.dropDown.setImageResource(model.getImage());
        holder.drop_d.setImageResource(model.getDrop_down());

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get().load(model.getHomeWork_img()).resize(720, 1080).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);
                holder.drop_d.setVisibility(View.GONE);
                holder.floatingActionButton.setVisibility(View.VISIBLE);

                holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String fileNam= String.valueOf(System.currentTimeMillis());


                        DownloadImage(fileNam, model.getHomeWork_img(),model.getHomeWorkDate());

                    }
                });



                holder.image.setVisibility(View.VISIBLE);
                holder.dropDown.setVisibility(View.VISIBLE);
                holder.dropDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.image.setVisibility(View.GONE);
                        Picasso.get().load(model.getHomeWork_img()).resize(720, 200).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);
                        holder.drop_d.setVisibility(View.VISIBLE);
                        holder.dropDown.setVisibility(View.GONE);
                        holder.floatingActionButton.setVisibility(View.GONE);

                    }
                });
            }
        });



        holder.drop_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.image.setVisibility(View.VISIBLE);
                holder.drop_d.setVisibility(View.GONE);
                holder.floatingActionButton.setVisibility(View.VISIBLE);

                holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String fileNam= String.valueOf(System.currentTimeMillis());


                        DownloadImage(fileNam, model.getHomeWork_img(),model.getHomeWorkDate());

                    }
                });


                Picasso.get().load(model.getHomeWork_img()).resize(720, 1080).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);

                holder.dropDown.setVisibility(View.VISIBLE);
                holder.dropDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Picasso.get().load(model.getHomeWork_img()).resize(720, 200).onlyScaleDown().placeholder(R.drawable.ic_attendance).into(holder.image);
                        holder.image.setVisibility(View.GONE);
                        holder.dropDown.setVisibility(View.GONE);
                        holder.drop_d.setVisibility(View.VISIBLE);
                        holder.floatingActionButton.setVisibility(View.GONE);
                    }
                });
            }
        });



    }







        @Override
        public int getItemCount () {
            return list.size();
        }

        public class viewHolder extends RecyclerView.ViewHolder {
           PhotoView image;
            TextView text;
            LinearLayout linearLyout_homeWork;
            ImageView dropDown, drop_d;
            FloatingActionButton floatingActionButton;
            public viewHolder(@NonNull View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.recentHomeWork_img);
                text = itemView.findViewById(R.id.recentHomeWork_Day);
                dropDown=itemView.findViewById(R.id.drop_up_home);
                drop_d=itemView.findViewById(R.id.drop_down_home);
floatingActionButton=itemView.findViewById(R.id.download_homeWork);
            }
        }


    public  void DownloadImage(String fileName,String imageUrl,String day){

        try {
            DownloadManager downloadManager =null;
            downloadManager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            Uri downloaduri=Uri.parse(imageUrl);
            DownloadManager.Request request = new DownloadManager.Request(downloaduri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(day+" HomeWork")
                    .setMimeType("image/*")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator+fileName+".jpg");

            downloadManager.enqueue(request);
            Toast.makeText(context, "image downloaded", Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(context, "image downloading failed", Toast.LENGTH_SHORT).show();
        }


    }




    }
