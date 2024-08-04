package com.example.rightschooldemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_midterm_result;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_results;
import com.example.rightschooldemoapp.adapter_for_recycler.Adapter_for_viewPager;
import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends AppCompatActivity {
TabLayout tabLayout;
ViewPager viewPager;
Adapter_for_midterm_result adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tabLayout=findViewById(R.id.tabLayout_for_result);
        viewPager=findViewById(R.id.viewPager_for_result);
getSupportActionBar().hide();

        viewPager.setAdapter(new Adapter_for_results(getSupportFragmentManager(),0));


        tabLayout.setupWithViewPager(viewPager);




    }





}