package com.example.rightschooldemoapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_Noti_Frag;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_notificatio;
import com.example.rightschooldemoapp.Notification;
import com.example.rightschooldemoapp.R;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_FragNoti;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_notification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class NotificationFragment extends Fragment {


    public NotificationFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    protected static final String EVENTS_URL="https://aqibproject.000webhostapp.com/student_notification.php";
    ArrayList<Model_for_Noti_Frag> list = new ArrayList<>();
    Adapter_for_FragNoti adapter;
    LinearLayout layout;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_notification, container, false);


        layout=view.findViewById(R.id.std_noti_shimmer);
        recyclerView =view.findViewById(R.id.recycler_for_notifications_frag);
progressBar=view.findViewById(R.id.progressBar4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);





        StringRequest request = new StringRequest(Request.Method.POST, EVENTS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!(response.equals("NullPointerException"))|!(response.equals(null))) {

                try {
                    JSONArray array = new JSONArray(response);
                    progressBar.setVisibility(View.GONE);
                    int i;

                    for (i=0;i<array.length();i++){


                        JSONObject object = array.getJSONObject(i);

                        String title = object.getString("title");
                        String details = object.getString("details");
                        String date = object.getString("date_time");
                        list.add(new Model_for_Noti_Frag(title,details,date,R.drawable.drop_up, R.drawable.expand));
                        adapter=new Adapter_for_FragNoti(list,getContext());

                        recyclerView.setAdapter(adapter);


                    }




                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }else{
                    Toast.makeText(getActivity(), "Can't connect", Toast.LENGTH_SHORT).show();

                }}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getActivity(), "Can't connect", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();


                SharedPreferences preferences = getContext().getSharedPreferences("user_data", Context.MODE_PRIVATE);
                String CLASS = preferences.getString("classs", "null");


                map.put("class", CLASS);

                return map;
            }





        };


        RequestQueue queue =Volley.newRequestQueue(getContext());

        queue.add(request);

        return view;
    }
}