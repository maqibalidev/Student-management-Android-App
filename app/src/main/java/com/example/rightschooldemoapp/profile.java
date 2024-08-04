package com.example.rightschooldemoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {
Button logOut;

TextView stdName,stdClass,stdRoll;
    AlertDialog.Builder dialog1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();


        logOut=findViewById(R.id.logOut);
        stdName=findViewById(R.id.stdName);
        stdClass=findViewById(R.id.stdClass);
        stdRoll=findViewById(R.id.stdRoll);





logOut.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

dialog1 = new AlertDialog.Builder(profile.this);
dialog1.setTitle("Log Out");
dialog1.setMessage("Are you sure you want to LogOut?");
dialog1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();

        editor.putString("loggedOut","loggedOut");
        editor.commit();
        Intent intent = new Intent(profile.this,MainActivity.class);

        startActivity(intent);

        finish();



    }
});

dialog1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(profile.this, "canceled", Toast.LENGTH_SHORT).show();


    }
});

dialog1.show();




    }
});

        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        String name =  preferences.getString("student_name",null);
        String rollNo =   preferences.getString("rollNo",null);
        String CLASS= preferences.getString("classs",null);

        stdName.setText(name);
        stdClass.setText(CLASS);
        stdRoll.setText(rollNo);






    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.right_slidein,R.anim.left_slideout);
    }
}