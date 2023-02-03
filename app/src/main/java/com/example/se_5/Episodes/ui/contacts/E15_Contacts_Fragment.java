package com.example.se_5.Episodes.ui.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.example.se_5.R;

public class E15_Contacts_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.e15_contacts_fragment , container , false);
        AppCompatImageView img = root.findViewById(R.id.img_contacts);
        TextView text          = root.findViewById(R.id.text_contacts);

        img.setImageResource(R.drawable.ic_baseline_perm_contact_calendar_24);
        text.setText("This is Contacts fragment");


        return root;
    }
}
