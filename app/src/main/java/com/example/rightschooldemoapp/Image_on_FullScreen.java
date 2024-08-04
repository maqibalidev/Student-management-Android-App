package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Image_on_FullScreen extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_on_full_screen);

   imageView=findViewById(R.id.zoom_img);


        Bundle bundle = new Bundle();

     String img =    bundle.getString("homeWorl_1");


        Picasso.get().load(img).into(imageView);





    }
}