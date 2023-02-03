package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.se_5.Adaptor.E11Adapter;
import com.example.se_5.Objects.E11object;
import com.example.se_5.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;
import java.util.List;

public class E11_ViewPager extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    Button back , next;
    TextView title;
    List<E11object> list = new ArrayList<>();
    E11Adapter adapter ;
    RelativeLayout footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e11__view_pager);
        setTitle(this.getClass().getSimpleName());

        init();
    }

    private void init() {

        viewPager = findViewById(R.id.viewpager);
        back      = findViewById(R.id.back);
        next      = findViewById(R.id.next);
        title     = findViewById(R.id.name);
        footer    = findViewById(R.id.footer);
        list      = prepareDate();

        next.setOnClickListener(this);
        back.setOnClickListener(this);

        adapter   = new E11Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT , list);
        viewPager.setAdapter(adapter);

        title.setText(getString(R.string.arad_shock));
        footer.setBackgroundColor(Color.rgb(23,21,24));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

                title.setText(list.get(position).getTitle());
                footer.setBackgroundColor(list.get(position).getColor());
                if (position==0)
                    back.setVisibility(View.INVISIBLE);
                else back.setVisibility(View.VISIBLE);

                if (position==list.size()-1)
                    next.setText(getString(R.string.letsgo));
                else next.setText(getString(R.string.next_song));


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private List<E11object> prepareDate(){

        List<E11object> list = new ArrayList<>();

        E11object object = new E11object();
        object.setTitle(getString(R.string.arad_shock));
        object.setImg_res(R.drawable.baghie);
        object.setColor(23,21,24);
        list.add(object);

        object = new E11object();
        object.setTitle(getString(R.string.milad_nourbakhsh));
        object.setImg_res(R.drawable.atr);
        object.setColor(124,134,110);
        list.add(object);

        object = new E11object();
        object.setTitle(getString(R.string.milad_jahani));
        object.setImg_res(R.drawable.ghol);
        object.setColor(6,27,30);
        list.add(object);

        object = new E11object();
        object.setTitle(getString(R.string.saman_jamal));
        object.setImg_res(R.drawable.negah);
        object.setColor(10,10,10);
        list.add(object);

        object = new E11object();
        object.setTitle(getString(R.string.mjavad));
        object.setImg_res(R.drawable.oham);
        object.setColor(66,146,147);
        list.add(object);

        object = new E11object();
        object.setTitle(getString(R.string.shadmehr_jamali));
        object.setImg_res(R.drawable.sal);
        object.setColor(16,13,6);
        list.add(object);

        object = new E11object();
        object.setTitle(getString(R.string.farzad_kazemi));
        object.setImg_res(R.drawable.ghobar);
        object.setColor(20,32,46);
        list.add(object);

        return list;
    }

    @Override
    public void onClick(View v) {

        int len = list.size();
        int position = viewPager.getCurrentItem();

        if (v == next){
            if (position<len-1)
                viewPager.setCurrentItem(position+1);
            else startActivity(new Intent(E11_ViewPager.this , E01_CustomSpinner.class));
        }
        else if (v == back){
            if (position>0)
                viewPager.setCurrentItem(position - 1);

        }

    }
}