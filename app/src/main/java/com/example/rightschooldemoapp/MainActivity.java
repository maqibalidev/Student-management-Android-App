package com.example.rightschooldemoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText email, pass;
    Button login;
    TextView textView;
ProgressDialog dialog;
    protected static final String url = "https://aqibproject.000webhostapp.com/std.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);

        getSupportActionBar().hide();


dialog=new ProgressDialog(this);
        dialog.setTitle("Siginig In Account");
        dialog.setMessage("please wait ");





        SharedPreferences preferences1 = getSharedPreferences("user_data", MODE_PRIVATE);
        if (preferences1.contains("loggedOut")) {

            Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = preferences1.edit();
            editor.remove("loggedOut");
            editor.commit();


        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (email.getText().toString().isEmpty()) {
                    email.setError("please enter email");
                } else if (pass.getText().toString().isEmpty()) {
                    pass.setError("please enter password");
                } else {
                    dialog.show();
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equals("java.lang.NullPointerException")|response.equals("not found")) {
dialog.dismiss();
                                Toast.makeText(MainActivity.this, "Enter correct email and password", Toast.LENGTH_SHORT).show();

                            } else {
                                try {
dialog.dismiss();
                                    JSONObject object = new JSONObject(response);
                                    String name = object.getString("student name");
                                    String rollNo = object.getString("rollNo");
                                    String classs = object.getString("class");


                                    SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = preferences.edit();

                                    editor.putString("student_name", name);
                                    editor.putString("rollNo",rollNo);
                                    editor.putString("classs",classs);
                                    editor.putString("welcome","null");


                                    editor.commit();


                                    Intent intent = new Intent(MainActivity.this
                                            , bottomNavigation.class);


                                    startActivity(intent);
                                    finish();

                                } catch (Exception e) {
                                    Toast.makeText(MainActivity.this,"Cant connect to server", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> map = new HashMap<String, String>();
                            map.put("email", email.getText().toString().trim());
                            return map;

                        }
                    };


                    queue.add(request);
                }
            }
        });


    }


}