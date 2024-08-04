package com.example.rightschooldemoapp.adapter_for_recycler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.rightschooldemoapp.fragments.HomeWorkFragment_1;
import com.example.rightschooldemoapp.fragments.Result_Fragment_1;
import com.example.rightschooldemoapp.fragments.Result_Fragment_2;

public class Adapter_for_results extends FragmentPagerAdapter {


    public Adapter_for_results(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
switch (position){
    case 0: return new Result_Fragment_1();
    case 1: return  new Result_Fragment_2();



    default:return new Result_Fragment_1();
}



    }

    @Override
    public int getCount() {
        return 2;
    }
String titile;
    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        if (position==0){

            titile = "Result";


        }
        else {

            titile= "Anual";

        }
        return titile;
    }
}
