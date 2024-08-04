package com.example.rightschooldemoapp.fragments;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.bumptech.glide.Glide;
import com.example.rightschooldemoapp.Image_on_FullScreen;
import com.example.rightschooldemoapp.R;
import com.example.rightschooldemoapp.TimeTable;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class HomeWorkFragment_1 extends Fragment {
ProgressBar progressBar;
TextView today_day;
PhotoView todayHomework;
LinearLayout shimmer_for_hw_1;
FloatingActionButton floatingActionButton;
BitmapDrawable bitmapDrawable;
Bitmap bitmap;
    public HomeWorkFragment_1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

public static final String RECENT_HOMEWORK_URL="https://aqibproject.000webhostapp.com/homework.php";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_work_1, container, false);

progressBar=view.findViewById(R.id.progressBar);
floatingActionButton=view.findViewById(R.id.floatingActionButton);
        today_day  = view.findViewById(R.id.today_day);

        todayHomework=view.findViewById(R.id.todayHomework);
        shimmer_for_hw_1=view.findViewById(R.id.shimmer_for_hw_1);


        String day = LocalDate.now().getDayOfWeek().name().trim().toLowerCase();

        StringRequest request = new StringRequest(Request.Method.POST, RECENT_HOMEWORK_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

if(!(response.equals("NullPointerException"))|!(response.equals("not found"))) {


    try {

        JSONArray array = new JSONArray(response);

        int i;
        for(i=0;i<=array.length();i++) {

            JSONObject object=array.getJSONObject(i);

            String days = object.getString("day").trim().toLowerCase();
            String img = object.getString("img");
            Log.d("sss", img);
if(days.equals(day)){
            today_day.setText(days.toUpperCase());
            Picasso.get().load(img).resize(1080, 720).onlyScaleDown().placeholder(R.drawable.ic_holidays).into(todayHomework);
    progressBar.setVisibility(View.GONE);
    shimmer_for_hw_1.setVisibility(View.GONE);

    floatingActionButton.setVisibility(View.VISIBLE);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

String fileNam= String.valueOf(System.currentTimeMillis());


DownloadImage(fileNam,img,days);




        }
    });





        }


        }

    } catch (JSONException e) {
        e.printStackTrace();
    }

}
else {

    Toast.makeText(getContext(), "not found", Toast.LENGTH_SHORT).show();
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

              map.put("day",day);
                map.put("class",CLASS);

return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);











        return view;
    }
    public  void DownloadImage(String fileName,String imageUrl ,String day){

        try {
            DownloadManager downloadManager =null;
            downloadManager= (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
            Uri downloaduri=Uri.parse(imageUrl);
            DownloadManager.Request request = new DownloadManager.Request(downloaduri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(day+" HomeWork")
                    .setMimeType("image/*")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator+fileName+".jpg");

            downloadManager.enqueue(request);
            Toast.makeText(getContext(), "image downloaded", Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(getContext(), "image downloading failed", Toast.LENGTH_SHORT).show();
        }


    }
}