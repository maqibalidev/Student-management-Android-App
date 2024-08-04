package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
                if (preferences.contains("student_name")) {
                    Intent intent = new Intent(Splash_Activity.this
                            , bottomNavigation.class);


                    startActivity(intent);
                    finish();

                }

                else{

                    Intent intent = new Intent(Splash_Activity.this
                            ,MainActivity.class);
                    startActivity(intent);
                    finish();

                }

            }


        },2000);


    }
}