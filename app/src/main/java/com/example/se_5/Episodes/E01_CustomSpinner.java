package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.se_5.Adaptor.E01Adapter;
import com.example.se_5.Objects.E01object;
import com.example.se_5.R;
import com.example.se_5.app.app;

import java.util.ArrayList;
import java.util.List;

public class E01_CustomSpinner extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, View.OnClickListener {




    List<E01object> list= new ArrayList<>();
    E01Adapter adaptor;
    Spinner spinner;
    ImageView img;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e01__custom_spinner);
        setTitle(this.getClass().getSimpleName());


        init();
    }

    private void init() {
        list.add(new E01object(R.drawable.android, getString(R.string.android)));
        list.add(new E01object(R.drawable.mac    , getString(R.string.mac)));
        list.add(new E01object(R.drawable.ios    , getString(R.string.ios)));
        list.add(new E01object(R.drawable.windows, getString(R.string.windows)));

        E01object object= new E01object();
        object.setName(getString(R.string.ubuntu));
        object.setDrawable(R.drawable.ubuntu);
        list.add(object);


        adaptor= new E01Adapter(this, android.R.layout.simple_list_item_1 , list);
        spinner= findViewById(R.id.spinner);
        img= findViewById(R.id.img_2);
        tv= findViewById(R.id.tv_2);

        spinner.setAdapter(adaptor);
        spinner.setOnItemSelectedListener(this);
        img.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        tv.setText(list.get(position).getName());
        img.setImageResource(list.get(position).getDrawable());


        Animation anim= AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        tv.startAnimation(anim);
        img.startAnimation(anim);

    }







    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        app.t(list.get(spinner.getSelectedItemPosition()).getName());

    }
}