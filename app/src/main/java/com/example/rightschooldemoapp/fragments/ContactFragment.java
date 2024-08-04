package com.example.rightschooldemoapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rightschooldemoapp.Models_for_recycler.Model_for_contacts;
import com.example.rightschooldemoapp.R;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_contacts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;


public class ContactFragment extends Fragment {

ArrayList<Model_for_contacts > list = new ArrayList<>();
Adapter_for_contacts adapter;
RecyclerView recyclerView;
LinearLayout admin_contact_shimmer;
protected static final String ADMIIN_URL="https://aqibproject.000webhostapp.com/admin.php";

SearchView searchView;
    public ContactFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_contact, container, false);

        admin_contact_shimmer=view.findViewById(R.id.admin_contact_shimmer);
recyclerView=view.findViewById(R.id.contact_recyclerView);
searchView=view.findViewById(R.id.search_for_admin);


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



        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);


        StringRequest request = new StringRequest(Request.Method.POST, ADMIIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONArray array = new JSONArray(response);
                    int i;

                    for (i=0;i<array.length();i++){


                        JSONObject object = array.getJSONObject(i);
                        admin_contact_shimmer.setVisibility(View.GONE);
                        String name = object.getString("name");
                        String number = object.getString("number");
                        String discription = object.getString("discription");
                        list.add(new Model_for_contacts(name,discription
                                ,R.drawable.call_img, R.drawable.teacher,R.drawable.expand, R.drawable.drop_up,number));
                        adapter=new Adapter_for_contacts(list,getContext());

                        recyclerView.setAdapter(adapter);


                    }




                } catch (Exception e) {
                    Toast.makeText(getContext(), "Cant Connect to server", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);





















   return view;
    }



}