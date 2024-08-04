package com.example.rightschooldemoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_Attendence;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Attendence extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Model_Attendence> list = new ArrayList<>();
ProgressBar progressBar6;

protected static final String ATTENDENCE_URL = "https://aqibproject.000webhostapp.com/attendence.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
getSupportActionBar().hide();

        progressBar6=findViewById(R.id.progressBar6);
        recyclerView=findViewById(R.id.recyc);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        String name =  preferences.getString("student_name",null);
      String rollNo =   preferences.getString("rollNo",null);
        String CLASS= preferences.getString("classs",null);





        StringRequest request = new StringRequest(Request.Method.POST, ATTENDENCE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
if(response.equals("not found")){
    Toast.makeText(Attendence.this, "not found", Toast.LENGTH_SHORT).show();

}
else {
    try {

        JSONArray array = new JSONArray(response);
        progressBar6.setVisibility(View.GONE);
        int i;
        for (i = 0; i <= array.length(); i++) {
            JSONObject object = array.getJSONObject(i);

            String day = object.getString("date_time");
            String attendence = object.getString("atendence");

            Log.d("apiTest", day);

            list.add(new Model_Attendence(day, attendence));
            Adapter_Attendence adapter = new Adapter_Attendence(list, Attendence.this);

            recyclerView.setAdapter(adapter);
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Attendence.this, "can't connect to server", Toast.LENGTH_SHORT).show();
            }
        }){

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String, String>();
                map.put("class",CLASS);
                map.put("roll",rollNo);

                return map;
            }

        };
        RequestQueue queue =Volley.newRequestQueue(getApplicationContext());
        queue.add(request);




    }
}