package com.example.se_5.Adaptor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.se_5.Objects.E11object;
import com.example.se_5.fragment.E10Fragment;
import com.example.se_5.fragment.E11Fragment;

import java.util.List;

public class E11Adapter extends FragmentPagerAdapter {

    List<E11object> list;

    public E11Adapter(@NonNull FragmentManager fm, int behavior , List<E11object> list) {
        super(fm, behavior);

        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        E11Fragment fragment = new E11Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position );
        bundle.putSerializable("object" , list.get(position));
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return list.size()  ;
    }
}
