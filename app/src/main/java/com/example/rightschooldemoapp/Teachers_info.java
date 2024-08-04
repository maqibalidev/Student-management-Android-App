package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_tracehrs;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_teachers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Teachers_info extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Model_for_tracehrs> list = new ArrayList<>();
ProgressBar progressBar3;
Adapter_for_teachers adapter;
SearchView searchView;
LinearLayout layout;
protected static final String teachers_url = "https://aqibproject.000webhostapp.com/teachers.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_info);



getSupportActionBar().hide();
layout=findViewById(R.id.contavt_shimmer);
searchView = findViewById(R.id.search_for_teachers);
searchView.clearFocus();


searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {




        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


     adapter.getFilter().filter(newText);


        return false;
    }
});

getSupportActionBar().setTitle("Teachers");
        http://192.168.107.215//rightSchoolApi/teachers.php
    recyclerView=findViewById(R.id.teacher_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        StringRequest request = new StringRequest(Request.Method.GET, teachers_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!(response.equals("NullPointerException"))|!(response.equals("not found"))) {


                    try {
                        JSONArray array = new JSONArray(response);
                        layout.setVisibility(View.GONE);
                        int i;
                        for (i = 0; i <= array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);
                            String name = object.getString("name");
                            String data = object.getString("data");
                            String number = object.getString("number");

                            list.add(new Model_for_tracehrs(name, data, R.drawable.call_img, R.drawable.teachersfemale, R.drawable.expand, R.drawable.drop_up, number));
                            adapter = new Adapter_for_teachers(list, getApplicationContext());

                            recyclerView.setAdapter(adapter);


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{

                    Toast.makeText(Teachers_info.this, "cant connect to server", Toast.LENGTH_SHORT).show();
                } }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Teachers_info.this, "can't connect".toString(), Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);









    }


}