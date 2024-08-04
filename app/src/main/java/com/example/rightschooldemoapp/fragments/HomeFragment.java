package com.example.rightschooldemoapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rightschooldemoapp.Attendence;
import com.example.rightschooldemoapp.Holidays;
import com.example.rightschooldemoapp.HomeWork;
import com.example.rightschooldemoapp.Notification;
import com.example.rightschooldemoapp.R;
import com.example.rightschooldemoapp.ResultActivity;
import com.example.rightschooldemoapp.Teachers_info;
import com.example.rightschooldemoapp.TimeTable;


public class HomeFragment extends Fragment {


    private static final int MODE_PRIVATE = 0;

    public HomeFragment() {
        // Required empty public constructor
    }
CardView cardView_home;

    ImageView timeTable,attendence,homeWork_stdd,result_img,holidays_img,events_img,teachers_i;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);

timeTable=view.findViewById(R.id.timeTabletimeTble);
        attendence=view.findViewById(R.id.attendence);
        homeWork_stdd=view.findViewById(R.id.homeWork_stdd);
        result_img=view.findViewById(R.id.result_img);
        holidays_img=view.findViewById(R.id.holidays_img);
        events_img=view.findViewById(R.id.events_img);
        teachers_i=view.findViewById(R.id.teachers_img);


        SharedPreferences preferences =getContext().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String name =  preferences.getString("student_name",null);
        if (preferences.contains("welcome")){

            Toast.makeText(getContext(), "welcome "+name, Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor=preferences.edit();

            editor.remove("welcome");
            editor.commit();

        }




timeTable.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getContext(),TimeTable.class);
        startActivity(intent);


    }
});

        attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), Attendence.class);
                startActivity(intent);


            }
        });

    homeWork_stdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), HomeWork.class);
                startActivity(intent);


            }
        });
        result_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ResultActivity.class);
                startActivity(intent);


            }
        });
        holidays_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), Holidays.class);
                startActivity(intent);


            }
        });
        events_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), Notification.class);
                startActivity(intent);


            }
        });
        teachers_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), Teachers_info.class);
                startActivity(intent);


            }
        });
   return view;
    }

}