package com.example.rightschooldemoapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_help;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_notificatio;
import com.example.rightschooldemoapp.Notification;
import com.example.rightschooldemoapp.R;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_help;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_notification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HelpFragment extends Fragment {


    protected static final String EVENTS_URL="https://aqibproject.000webhostapp.com/help.php";
    public HelpFragment() {
        // Required empty public constructor
    }
ArrayList<Model_for_help> list = new ArrayList<>();
    Adapter_for_help adapter;
    RecyclerView recyclerView;
    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_help, container, false);
  recyclerView=view.findViewById(R.id.help_recycler_view);
layout=view.findViewById(R.id.sample_shimmer_layout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        StringRequest request = new StringRequest(Request.Method.POST, EVENTS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                layout.setVisibility(View.GONE);
                try {
                    JSONArray array = new JSONArray(response);
                    int i;

                    for (i=0;i<array.length();i++){


                        JSONObject object = array.getJSONObject(i);

                        String title = object.getString("title");
                        String details = object.getString("details");

                        list.add(new Model_for_help(title,details));
                        adapter=new Adapter_for_help(list,getContext());

                        recyclerView.setAdapter(adapter);


                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Can't connect", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);









  return  view;
    }
}