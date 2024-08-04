package com.example.rightschooldemoapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Result_Fragment_2 extends Fragment {



    public Result_Fragment_2() {
        // Required empty public constructor
    }
protected static final String ANUAL_RESULT_URL = "https://aqibproject.000webhostapp.com/anual_result.php";
TextView titleT;
    PhotoView img1;
   ProgressBar progressBar_result_2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_result__2, container, false);

       titleT=view.findViewById(R.id.anual_result_title);

       img1 =view.findViewById(R.id.anual_result_img);
        progressBar_result_2=view.findViewById(R.id.progressBar_result_2);

        StringRequest requests = new StringRequest(Request.Method.POST, ANUAL_RESULT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (!(response.equals("java.lang.NullPointerException"))|!(response.equals("not found"))) {
                    try {
                        JSONObject object = new JSONObject(response);
                        progressBar_result_2.setVisibility(View.GONE);

                        String title = object.getString("title");
                        String image = object.getString("img");

                        titleT.setText(title);

                        Picasso.get().load(image).resize(1080, 720).onlyScaleDown().rotate(90).into(img1);


                    } catch (Exception e) {
                        Toast.makeText(getContext(), "can't connect", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getContext(), "can't connect", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String , String> map =new HashMap<String, String>();
                SharedPreferences preferences = getContext().getSharedPreferences("user_data",  Context.MODE_PRIVATE);
                String CLASS =   preferences.getString("classs","null");
                String ROLL = preferences.getString("rollNo","null");


                map.put("class",CLASS);
                map.put("roll",ROLL);




                return map;
            }
        };



        RequestQueue queue = Volley.newRequestQueue(getContext());


        queue.add(requests);





    return view;
    }
}