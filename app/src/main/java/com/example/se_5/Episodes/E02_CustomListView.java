package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.se_5.Adaptor.E02Adapter;
import com.example.se_5.Objects.E02object;
import com.example.se_5.R;
import com.example.se_5.app.app;

import java.util.ArrayList;
import java.util.List;

public class E02_CustomListView extends AppCompatActivity implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener,
        View.OnClickListener{



    ListView listView;
    List<E02object> list;
    E02Adapter adapter;
    Button undo;
    E02object temp;
    int temp_position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e02__custom_list_view);
        setTitle(getClass().getSimpleName());

        init();
    }

    private void init() {
        listView = findViewById(R.id.ListView);
        undo     = findViewById(R.id.undo);
        list     = preparedata();
        adapter  = new E02Adapter(this,0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        undo.setOnClickListener(this);
    }


    private List<E02object> preparedata() {

        List<E02object> list = new ArrayList<>();

        E02object object     = new E02object();
        object.setName(getString(R.string.renegades));
        object.setImg(R.drawable.renegades);
        object.setDescription(getString(R.string.renegades_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.jeepers));
        object.setImg(R.drawable.jeepers);
        object.setDescription(getString(R.string.jeepers_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.hampstead));
        object.setImg(R.drawable.hampstead);
        object.setDescription(getString(R.string.hampstead_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.england));
        object.setImg(R.drawable.england);
        object.setDescription(getString(R.string.england_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.snowman));
        object.setImg(R.drawable.snowman);
        object.setDescription(getString(R.string.snowman_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.vincent));
        object.setImg(R.drawable.vincent);
        object.setDescription(getString(R.string.vincent_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.brawl));
        object.setImg(R.drawable.brawl);
        object.setDescription(getString(R.string.brawl_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.bright));
        object.setImg(R.drawable.bright);
        object.setDescription(getString(R.string.bright_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.eden));
        object.setImg(R.drawable.eden);
        object.setDescription(getString(R.string.eden_description));
        list.add(object);

        return list;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        app.t(list.get(position).getName());
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
        app.t(list.get(position).getName()+ " removed !");
        Animation anim= AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        view.startAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                temp          = list.get(position);
                temp_position = position;
                list.remove(position);
                adapter.notifyDataSetChanged();
                undo.setVisibility(View.VISIBLE);
                undo.startAnimation(AnimationUtils.loadAnimation(E02_CustomListView.this , android.R.anim.slide_in_left));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return true;
    }

    @Override
    public void onClick(View view) {

        list.add(temp_position, temp);
        adapter.notifyDataSetChanged();
        undo.setVisibility(View.GONE);
        undo.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
    }
}