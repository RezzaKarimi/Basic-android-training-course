package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.se_5.Adaptor.E04Adapter;
import com.example.se_5.Objects.E04object;
import com.example.se_5.R;
import com.example.se_5.interfaces.E04clickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class E04_CustomRecyclerView extends AppCompatActivity implements View.OnClickListener, E04clickListener {


    RecyclerView recyclerView;
    List<E04object> list;
    E04Adapter adapter;
    FloatingActionButton fab;
    public static final int layout_Manager_Linear = 1;
    public static final int layout_Manager_Grid   = 2;
    int layout_Manager = layout_Manager_Linear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e04__custom_recycler_view);
        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        fab          = findViewById(R.id.fab);
        fab.setOnClickListener(this);



        list         = prepareData();
        adapter      = new E04Adapter(list , this, layout_Manager);
        recyclerView.setAdapter(adapter);
        setLayoutManager();

    }



    private void setLayoutManager(){
        if(layout_Manager ==layout_Manager_Linear){
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);

        }
        else if (layout_Manager ==layout_Manager_Grid){
            GridLayoutManager gridLayoutManager= new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(gridLayoutManager);

        }

        adapter      = new E04Adapter(list , this, layout_Manager);
        recyclerView.setAdapter(adapter);

        Animation animation= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        LayoutAnimationController layoutAnimationController= new LayoutAnimationController(animation);
        recyclerView.setLayoutAnimation(layoutAnimationController);
    }


    @Override
    public void clickListener(E04object object) {
        Intent intent = new Intent(this , E04_CustomRecyclerViewItem.class);
        intent.putExtra("object", object);
        startActivity(intent);
    }

    private List<E04object> prepareData(){

        List<E04object> list= new ArrayList<>();


        E04object object= new E04object();
        object.setArtist                  (getString(R.string.saman_jamal));
        object.setName                    (getString(R.string.saman_jamal_song));
        object.setView(Integer.parseInt   (getString(R.string.saman_jamal_view)));
        object.setLike(Integer.parseInt   (getString(R.string.saman_jamal_like)));
        object.setComment(Integer.parseInt(getString(R.string.saman_jamal_comment)));
        object.setDate                    (getString(R.string.saman_jamal_date));
        object.setImg_Id(R.drawable.negah);


        list.add(object);object= new E04object();

        object.setArtist(getString(R.string.farzad_kazemi));
        object.setName(getString(R.string.farzad_kazemi_song));
        object.setView(Integer.parseInt(getString(R.string.farzad_kazemi_view)));
        object.setLike(Integer.parseInt(getString(R.string.farzad_kazemi_like)));
        object.setComment(Integer.parseInt(getString(R.string.farzad_kazemi_comment)));
        object.setDate(getString(R.string.farzad_kazemi_date));
        object.setImg_Id(R.drawable.ghobar);

        list.add(object);

        object= new E04object();
        object.setArtist                  (getString(R.string.milad_jahani));
        object.setName                    (getString(R.string.milad_jahani_song));
        object.setView(Integer.parseInt   (getString(R.string.milad_jahani_view)));
        object.setLike(Integer.parseInt   (getString(R.string.milad_jahani_like)));
        object.setComment(Integer.parseInt(getString(R.string.milad_jahani_comment)));
        object.setDate                    (getString(R.string.milad_jahani_date));
        object.setImg_Id(R.drawable.ghol);


        list.add(object);

        object= new E04object();
        object.setArtist                  (getString(R.string.mehdi_jahani));
        object.setName                    (getString(R.string.mehdi_jahani_song));
        object.setView(Integer.parseInt   (getString(R.string.mehdi_jahani_view)));
        object.setLike(Integer.parseInt   (getString(R.string.mehdi_jahani_like)));
        object.setComment(Integer.parseInt(getString(R.string.mehdi_jahani_comment)));
        object.setDate                    (getString(R.string.mehdi_jahani_date));
        object.setImg_Id(R.drawable.diwone);


        list.add(object);object= new E04object();
        object.setArtist                  (getString(R.string.arad_shock));
        object.setName                    (getString(R.string.arad_shock_song));
        object.setView(Integer.parseInt   (getString(R.string.arad_shock_view)));
        object.setLike(Integer.parseInt   (getString(R.string.arad_shock_like)));
        object.setComment(Integer.parseInt(getString(R.string.arad_shock_comment)));
        object.setDate                    (getString(R.string.arad_shock_date));
        object.setImg_Id(R.drawable.baghie);


        list.add(object);object= new E04object();
        object.setArtist                  (getString(R.string.shadmehr_jamali));
        object.setName                    (getString(R.string.shadmehr_jamali_song));
        object.setView(Integer.parseInt   (getString(R.string.shadmehr_jamali_view)));
        object.setLike(Integer.parseInt   (getString(R.string.shadmehr_jamali_like)));
        object.setComment(Integer.parseInt(getString(R.string.shadmehr_jamali_comment)));
        object.setDate                    (getString(R.string.shadmehr_jamali_date));
        object.setImg_Id(R.drawable.sal);


        list.add(object);object= new E04object();
        object.setArtist                  (getString(R.string.amin_pouya));
        object.setName                    (getString(R.string.amin_pouya_song));
        object.setView(Integer.parseInt   (getString(R.string.amin_pouya_view)));
        object.setLike(Integer.parseInt   (getString(R.string.amin_pouya_like)));
        object.setComment(Integer.parseInt(getString(R.string.amin_pouya_comment)));
        object.setDate                    (getString(R.string.amin_pouya_date));
        object.setImg_Id(R.drawable.diwonegi);


        list.add(object);object= new E04object();
        object.setArtist                  (getString(R.string.milad_nourbakhsh));
        object.setName                    (getString(R.string.milad_nourbakhsh_song));
        object.setView(Integer.parseInt   (getString(R.string.milad_nourbakhsh_view)));
        object.setLike(Integer.parseInt   (getString(R.string.milad_nourbakhsh_like)));
        object.setComment(Integer.parseInt(getString(R.string.milad_nourbakhsh_comment)));
        object.setDate                    (getString(R.string.milad_nourbakhsh_date));
        object.setImg_Id(R.drawable.atr);


        list.add(object);object= new E04object();
        object.setArtist                  (getString(R.string.saman_jamal));
        object.setName                    (getString(R.string.saman_jamal_song));
        object.setView(Integer.parseInt   (getString(R.string.saman_jamal_view)));
        object.setLike(Integer.parseInt   (getString(R.string.saman_jamal_like)));
        object.setComment(Integer.parseInt(getString(R.string.saman_jamal_comment)));
        object.setDate                    (getString(R.string.saman_jamal_date));
        object.setImg_Id(R.drawable.negah);


        list.add(object);object= new E04object();
        object.setArtist                  (getString(R.string.mjavad));
        object.setName                    (getString(R.string.mjavad_song));
        object.setView(Integer.parseInt   (getString(R.string.mjavad_view)));
        object.setLike(Integer.parseInt   (getString(R.string.mjavad_like)));
        object.setComment(Integer.parseInt(getString(R.string.mjavad_comment)));
        object.setDate                    (getString(R.string.mjavad_date));
        object.setImg_Id(R.drawable.oham);


        list.add(object);object= new E04object();
        object.setArtist                  (getString(R.string.sajad_esmaili));
        object.setName                    (getString(R.string.sajad_esmaili_song));
        object.setView(Integer.parseInt   (getString(R.string.sajad_esmaili_view)));
        object.setLike(Integer.parseInt   (getString(R.string.sajad_esmaili_like)));
        object.setComment(Integer.parseInt(getString(R.string.sajad_esmaili_comment)));
        object.setDate                    (getString(R.string.sajad_esmaili_date));
        object.setImg_Id(R.drawable.karikon);


        list.add(object);

        return list;
    }

    @Override
    public void onClick(View v) {
        if (layout_Manager == layout_Manager_Linear){
            layout_Manager = layout_Manager_Grid;
            fab.setImageResource(R.drawable.ic_baseline_dehaze_24);
        }
        else if (layout_Manager ==layout_Manager_Grid){
            layout_Manager =layout_Manager_Linear;
            fab.setImageResource(R.drawable.ic_baseline_grid_on_24);
        }
        setLayoutManager();
    }


}