package com.example.rightschooldemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView naem,rollNo,classs;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    naem=findViewById(R.id.name);
    rollNo=findViewById(R.id.rollNo);
    classs=findViewById(R.id.classs);
button=findViewById(R.id.button2);

        SharedPreferences preferences = getSharedPreferences("user_data",MODE_PRIVATE);

      String name_user=  preferences.getString("email",null);
        String rollNo_user=  preferences.getString("rollNo",null);
        String class_user=  preferences.getString("classs",null);



        naem.setText(name_user);
        rollNo.setText(rollNo_user);
        classs.setText(class_user);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences preferences = getSharedPreferences("user_data",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("email");
                editor.putString("loggedOut","logged Out Sucessfully");
                editor.apply();

                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);


                }
            });






    }


}