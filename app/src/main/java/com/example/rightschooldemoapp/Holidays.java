package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_holidays;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_holidays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Holidays extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Model_for_holidays> list = new ArrayList<>();
    LinearLayout layout;
public static final String HOLIDAYS_URL ="https://aqibproject.000webhostapp.com/holidaysNoti.php";
protected static final  String CHANEL_ID =  "Holidays Notifications";
    protected static final  int noti_chanel=  1122;
    protected static final  int pending_Intent=  112234;
    Notification nt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);
getSupportActionBar().hide();
        layout=findViewById(R.id.sample_shimmer_layout);
        recyclerView = findViewById(R.id.recycler_for_holidays);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        StringRequest request = new StringRequest(Request.Method.GET, HOLIDAYS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                layout.setVisibility(View.GONE);
                try {
                    JSONArray array = new JSONArray(response);

                    JSONObject jsonObject = array.getJSONObject(array.length()-1);




                    int i;
                    for (i=0;i<array.length();i++) {

                        JSONObject object = array.getJSONObject(i);

                        String titles = object.getString("title");
                        String detailss = object.getString("details");
                       String date_times = object.getString("date_time");



                       list.add(new Model_for_holidays(titles,detailss,date_times,R.drawable.drop_up, R.drawable.expand));
                        Adapter_for_holidays adapter = new Adapter_for_holidays(list, getApplicationContext());

                        recyclerView.setAdapter(adapter);











                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Holidays.this, "can't connect", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);











    }
}