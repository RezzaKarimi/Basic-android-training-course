package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.se_5.Adaptor.E21FinalAdapter;
import com.example.se_5.R;
import com.example.se_5.app.app;
import com.example.se_5.interfaces.E21FinalOnclick;

public class E21_FinalActivity extends AppCompatActivity implements E21FinalOnclick{

    Boolean clicked = false;
    RecyclerView recyclerView;
    E21FinalAdapter adapter ;
    String[] items;
    int [] colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e21__final_avtivity);
        setTitle("Final Activity");
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        items        = getResources().getStringArray(R.array.items);
        colors       = new int[]{
                R.color.No1,
                R.color.No2,
                R.color.No3,
                R.color.No4,
                R.color.colorAccent,
                R.color.No5,
                R.color.No6,
                R.color.No7,
                R.color.No8,
                R.color.No9,
                R.color.No10,
                R.color.No11,
                R.color.No12,
                R.color.No13,
                R.color.No14,
                R.color.No15,
                R.color.colorPrimary,
                R.color.No2,
                R.color.No8,
                R.color.No14,
                R.color.No13,
                R.color.No7
        };

        adapter      = new E21FinalAdapter(items , colors , this);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this , android.R.anim.slide_in_left)));

        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onclick(String title) {
        try {
            Class<?> className = Class.forName("com.example.se_5.Episodes."+title);
            Intent intent = new Intent(this , className);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (!clicked){
            clicked = true;
            app.t("Press again for Exit");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    clicked = false;
                }
            },1500);
        }else {
            super.onBackPressed();
        }


    }
}