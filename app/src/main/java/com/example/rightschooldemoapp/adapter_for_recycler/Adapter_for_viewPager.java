package com.example.rightschooldemoapp.adapter_for_recycler;

import android.service.quicksettings.Tile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.rightschooldemoapp.fragments.HomeWorkFragment_1;
import com.example.rightschooldemoapp.fragments.HomeWorkFragment_2;

public class Adapter_for_viewPager extends FragmentPagerAdapter {


    public Adapter_for_viewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {


      switch (position){
          case 0: return new HomeWorkFragment_1();
          case 1: return new HomeWorkFragment_2();

          default:return new HomeWorkFragment_1();

      }





    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    String title;
    public CharSequence getPageTitle(int position) {
       if (position==0){
           title = "Today";

       }
       else {

           title="Recent";

       }


        return title;
    }
}
