package com.example.rightschooldemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.rightschooldemoapp.fragments.ContactFragment;
import com.example.rightschooldemoapp.fragments.Events_Fragment;
import com.example.rightschooldemoapp.fragments.HelpFragment;
import com.example.rightschooldemoapp.fragments.HomeFragment;
import com.example.rightschooldemoapp.fragments.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomNavigation extends AppCompatActivity {
BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
navigationView=findViewById(R.id.bottonNaav);

getSupportActionBar().setTitle("   Right School");
        ActionBar actionBar =getSupportActionBar();
        ColorDrawable colorDrawable=  new ColorDrawable(Color.parseColor("#FF9800"));


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 int id= item.getItemId();

if (id == R.id.homes){
   showFragments(new HomeFragment(),0);

}
else if(id==R.id.notifications){

    showFragments(new NotificationFragment(),1);

}
else if(id==R.id.contact){

    showFragments(new ContactFragment(),1);

}

else if(id==R.id.events){

    showFragments(new Events_Fragment(),1);

}
else if(id==R.id.help){

    showFragments(new HelpFragment(),1);

}

                return true;
            }
        });


        showFragments(new HomeFragment(),0);
    }

    public void showFragments(Fragment fragment,int flag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

if (flag==0) {
    transaction.add(R.id.frameLayout, fragment);

}

else{
    transaction.replace(R.id.frameLayout, fragment);


}
        transaction.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.toolbar_i,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


      Intent intent = new Intent(bottomNavigation.this,profile.class);
      startActivity(intent);

        overridePendingTransition(R.anim.anim_left_slide_in,R.anim.rightslideout);

        return super.onOptionsItemSelected(item);
    }
}