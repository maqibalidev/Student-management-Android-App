package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_viewPager;
import com.google.android.material.tabs.TabLayout;

public class HomeWork extends AppCompatActivity {
TabLayout tabLayout;
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);
getSupportActionBar().hide();
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);





        viewPager.setAdapter(new Adapter_for_viewPager(getSupportFragmentManager(),0));

        tabLayout.setupWithViewPager(viewPager);
    }
}