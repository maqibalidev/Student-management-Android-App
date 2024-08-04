package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_notificatio;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_notification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
RecyclerView recyclerView;
    protected static final String EVENTS_URL="https://aqibproject.000webhostapp.com/events_notification.php";
ArrayList<Model_for_notificatio> list = new ArrayList<>();
Adapter_for_notification adapter;
ProgressBar layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recycler_for_notifications);
layout=findViewById(R.id.ptogressBar_std_noti7);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        StringRequest request = new StringRequest(Request.Method.POST, EVENTS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

if (!(response.equals("not found"))) {
    try {
        JSONArray array = new JSONArray(response);
        layout.setVisibility(View.GONE);
        int i;

        for (i = 0; i < array.length(); i++) {


            JSONObject object = array.getJSONObject(i);

            String title = object.getString("title");
            String details = object.getString("details");
            String date = object.getString("date_time");
            list.add(new Model_for_notificatio(title, details, date, R.drawable.drop_up, R.drawable.expand));
            adapter = new Adapter_for_notification(list, getApplicationContext());

            recyclerView.setAdapter(adapter);


        }


    } catch (Exception e) {
        Toast.makeText(Notification.this, "Can't connect", Toast.LENGTH_SHORT).show();
    }
}else {
    Toast.makeText(Notification.this, "not found", Toast.LENGTH_SHORT).show();
}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Notification.this, "Can't connect", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);







    }
}