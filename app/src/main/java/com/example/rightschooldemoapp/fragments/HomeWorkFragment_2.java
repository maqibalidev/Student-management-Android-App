package com.example.rightschooldemoapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_homeWork;
import com.example.rightschooldemoapp.R;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_homeWork;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HomeWorkFragment_2 extends Fragment {

ProgressBar progressBar2;
    public HomeWorkFragment_2() {
        // Required empty public constructor
    }

LinearLayout shimmer_for_hw_1;
RecyclerView recyclerView;
ArrayList<Model_for_homeWork> list = new ArrayList<>();
    protected static final String RECENT_HOMEWORK_URL="https://aqibproject.000webhostapp.com/homework.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home_work_2, container, false);
        progressBar2=view.findViewById(R.id.progressBar2);
       recyclerView=view.findViewById(R.id.recyclerView_homeWork);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        shimmer_for_hw_1=view.findViewById(R.id.shimmer_for_hw_1);

        StringRequest request = new StringRequest(Request.Method.POST, RECENT_HOMEWORK_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);
                    progressBar2.setVisibility(View.GONE);
                    int i;
                    for (i = 0; i <=array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String days = object.getString("day");
                        String img = object.getString("img");
                        Log.d("sss", img);

                        shimmer_for_hw_1.setVisibility(View.GONE);
list.add(new Model_for_homeWork(img,days,R.drawable.drop_up, R.drawable.expand));
                        Adapter_for_homeWork adapter = new Adapter_for_homeWork(list,getContext());
                        recyclerView.setAdapter(adapter );

                    }
                    } catch(JSONException e){
                        e.printStackTrace();
                    }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "can't connect to server", Toast.LENGTH_SHORT).show();
            }
        }) {


            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();


                SharedPreferences preferences = getContext().getSharedPreferences("user_data",  Context.MODE_PRIVATE);
                String CLASS =   preferences.getString("classs","null");
                map.put("class",CLASS);
                map.put("day","day");


                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);







    return  view;
    }



}