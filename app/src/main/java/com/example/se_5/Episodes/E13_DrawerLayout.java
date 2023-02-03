package com.example.se_5.Episodes;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.se_5.Adaptor.E13Adapter;
import com.example.se_5.R;
import com.example.se_5.app.Application;
import com.example.se_5.interfaces.E13ClickListener;

import java.util.ArrayList;
import java.util.List;


public class E13_DrawerLayout extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    RecyclerView recyclerView;
    TextView textView;
    AppCompatImageView img;
    E13Adapter adapter;
    List<int[]> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e13__drawer_layout);
        setTitle(this.getClass().getSimpleName());
        init();
    }


    private void init(){
        /*
      panel
         */


        // Header
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar      = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar , R.string.test , R.string.test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //Header

        //list
        recyclerView = findViewById(R.id.recyclerView);
        items        = prepareData();
        adapter      = new E13Adapter(items);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);




        //list

         /*
      panel
         */

        img      = findViewById(R.id.img);
        textView = findViewById(R.id.textView);


         E13Adapter.listener = new E13ClickListener() {
             @Override
             public void onclick(int[] item) {

                 img.setImageResource(item[0]);
                 textView.setText(getString(item[1]));
                 img.startAnimation(AnimationUtils.loadAnimation(Application.getContext() , android.R.anim.slide_in_left));
                 textView.startAnimation(AnimationUtils.loadAnimation(Application.getContext() , android.R.anim.slide_in_left));


                 drawerLayout.closeDrawers();
             }
         };

    }


    private List<int[]> prepareData(){

        List<int[]> item = new ArrayList<>();

        int a[] ={R.drawable.ic_baseline_favorite_border_24 , R.string.welcome};
        item.add(a);

        int b[] ={R.drawable.ic_baseline_settings_24 , R.string.setting};
        item.add(b);

        int c[] ={R.drawable.ic_baseline_perm_contact_calendar_24 , R.string.contacts};
        item.add(c);

        int d[] ={R.drawable.ic_baseline_account_circle_24 , R.string.status};
        item.add(d);

        int e[] ={R.drawable.ic_baseline_directions_run_24 , R.string.logout};
        item.add(e);

        return item;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(Gravity.LEFT))
            drawerLayout.closeDrawers();
        else  super.onBackPressed();
    }
}