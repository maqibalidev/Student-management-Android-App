package com.example.rightschooldemoapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_midterm_result;
import com.example.rightschooldemoapp.R;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_midterm_result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Result_Fragment_1 extends Fragment {



    public Result_Fragment_1() {
        // Required empty public constructor
    }

RecyclerView recyclerView;
Adapter_for_midterm_result adapter;
ProgressBar progressBar;
SearchView searchView;
ArrayList<Model_for_midterm_result> list = new ArrayList<>();

protected static final String MIDTERM_RESULT_URL = "https://aqibproject.000webhostapp.com/midterm_result.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result__1, container, false);

        searchView=view.findViewById(R.id.searchView);
        progressBar=view.findViewById(R.id.progressBar_for_result);
recyclerView = view.findViewById(R.id.midterm_result_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);


        StringRequest request = new StringRequest(Request.Method.POST, MIDTERM_RESULT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!(response.equals("java.lang.NullPointerException"))|!(response.equals("not found"))) {

                    try {
                        JSONArray array = new JSONArray(response);

                        progressBar.setVisibility(View.GONE);
                        int i;
                        for (i = 0; i <= array.length(); i++) {

                            JSONObject object = array.getJSONObject(i);

                            String month = object.getString("month");
                            String image = object.getString("img");

                            list.add(new Model_for_midterm_result(month, image, R.drawable.drop_up, R.drawable.expand));

                            adapter = new Adapter_for_midterm_result(list, getContext());


                            recyclerView.setAdapter(adapter);


                        }
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "can't connect", Toast.LENGTH_SHORT).show();
                    }

                }
                else{

                    Toast.makeText(getContext(), "can't connect", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "can't connect to server", Toast.LENGTH_SHORT).show();
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


queue.add(request);


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



  return view;

}
}