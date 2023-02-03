package com.example.se_5.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se_5.Adaptor.E10Adapter;
import com.example.se_5.Episodes.E12_TabbedActivity;
import com.example.se_5.Objects.E10object;
import com.example.se_5.R;
import com.example.se_5.interfaces.E10PermissionListener;

import java.util.ArrayList;
import java.util.List;

public class E10Fragment extends Fragment {

    RecyclerView recyclerView;
    List<E10object> list;
    E10Adapter adapter;
    public static  E10PermissionListener permissionListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.e10_fragment , container , false);

        list         = new ArrayList<>();
        adapter      = new E10Adapter(list);
        recyclerView = v.findViewById(R.id.recyclerView);
        permissionListener = new E10PermissionListener() {
            @Override
            public void onPermissionCheck(Boolean granted) {
                if (granted){
                    prepareDate();

                }
            }
        };

        if (E12_TabbedActivity.Permission_Granted = true)
            prepareDate();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation( getActivity() , android.R.anim.fade_in)));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    private void prepareDate(){
        list.clear();

        Cursor contacts = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null , null, null, null);

        while (contacts.moveToNext()) {

            String name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String tel  = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            list.add(new E10object(name, tel));

        }
        adapter.notifyDataSetChanged();

    }
}


