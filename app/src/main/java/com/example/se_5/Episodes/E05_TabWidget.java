package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.se_5.R;
import com.example.se_5.app.app;
import com.google.android.material.tabs.TabLayout;

public class E05_TabWidget extends TabActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e05__tab_widget);
        setTitle(this.getClass().getSimpleName());

        init();
    }



    private void init() {

        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab4");

        tab1.setIndicator("Spinner");
        tab1.setContent(new Intent(this , E01_CustomSpinner.class));

        tab2.setIndicator("ListView");
        tab2.setContent(new Intent(this , E02_CustomListView.class));

        tab3.setIndicator("GridView");
        tab3.setContent(new Intent(this , E03_CustomGridView.class));

        tab4.setIndicator("RecyclerView");
        tab4.setContent(new Intent(this , E04_CustomRecyclerView.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                app.t(tabId);
            }
        });
        tabHost.setCurrentTab(3);

    }

}