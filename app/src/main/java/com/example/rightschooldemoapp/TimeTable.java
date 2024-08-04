package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_TimeTable;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_timeTable;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimeTable extends AppCompatActivity {
RecyclerView recyclerView;
ProgressBar timetable_progress_bar;
ArrayList<Model_for_TimeTable> list = new ArrayList<>();
protected static final String TimeTable_URL = "https://aqibproject.000webhostapp.com/timetable.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);


        getSupportActionBar().hide();
        timetable_progress_bar=findViewById(R.id.timetable_progress_bar);
   recyclerView=findViewById(R.id.recyclerView_timeTable);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);






        recyclerView.setLayoutManager(layoutManager);

        StringRequest request = new StringRequest(Request.Method.GET, TimeTable_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
if (response.equals("not found")){

    Toast.makeText(TimeTable.this, "data not found", Toast.LENGTH_SHORT).show();
}
              else { try {
                    JSONArray array = new JSONArray(response);
                    int i;
                    for (i=0;i<=array.length();i++) {

                        JSONObject object = array.getJSONObject(i);
                       String DAY =  object.getString("day");
                        String CLASS =  object.getString("class");
                        String TIME =  object.getString("time");
                        timetable_progress_bar.setVisibility(View.GONE);
                        Log.d("timeTable",DAY);

list.add(new Model_for_TimeTable(CLASS,DAY,TIME));

                        Adapter_for_timeTable adapter = new Adapter_for_timeTable(list,getApplicationContext());

                        recyclerView.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TimeTable.this, "can't connect to server", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        queue.add(request);






        Adapter_for_timeTable adapter = new Adapter_for_timeTable(list,getApplicationContext());

        recyclerView.setAdapter(adapter);



    }
}