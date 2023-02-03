package com.example.se_5.Episodes;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.se_5.Episodes.E10_Contacts;
import com.example.se_5.R;
import com.example.se_5.app.app;
import com.example.se_5.fragment.E08Fragment;
import com.example.se_5.fragment.E10Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.se_5.ui.main.SectionsPagerAdapter;

import io.github.rockerhieu.emojicon.EmojiconGridFragment;
import io.github.rockerhieu.emojicon.EmojiconsFragment;
import io.github.rockerhieu.emojicon.emoji.Emojicon;

public class E12_TabbedActivity extends AppCompatActivity implements
        EmojiconsFragment.OnEmojiconBackspaceClickedListener ,
        EmojiconGridFragment.OnEmojiconClickedListener {

    TabLayout tabs;
    ViewPager viewPager;
    final static int REQUEST_CODE = 101;
    public static boolean Permission_Granted = false;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e12__tabbed);
        init();
        data();
        seticon();
    }



    private void data(){
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0){
                    fab.hide();
                }
                else fab.show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fab.hide();
        viewPager.setOffscreenPageLimit(4);
    }

    @Override
    public void onEmojiconClicked(Emojicon emojicon) {

        if (E08Fragment.e08EmojiChangeListener!=null){
            E08Fragment.e08EmojiChangeListener.onEmoji(emojicon);
        }
    }

    @Override
    public void onEmojiconBackspaceClicked(View v) {

        E08Fragment.e08EmojiChangeListener.onEmojiRemove(v);
    }

    @Override
    public void onBackPressed() {

        if(E08Fragment.emoji_Linear.getVisibility() == View.VISIBLE)
            E08Fragment.e08EmojiChangeListener.close();
        else  super.onBackPressed();
    }


    public void init() {


        if (checkPermission()){
            if(E10Fragment.permissionListener !=null)E10Fragment.permissionListener.onPermissionCheck(true);
            Permission_Granted = true;
        }
    }


    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1){

            if (ContextCompat.checkSelfPermission(this , Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED ){
                if(E10Fragment.permissionListener !=null)E10Fragment.permissionListener.onPermissionCheck(true);
                Permission_Granted = true;
                return true;
            }
            else {

                ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.READ_CONTACTS} , REQUEST_CODE );
            }

        }
        else {

            if(E10Fragment.permissionListener !=null)E10Fragment.permissionListener.onPermissionCheck(true);
            Permission_Granted = true;
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){

            case REQUEST_CODE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(E10Fragment.permissionListener !=null)E10Fragment.permissionListener.onPermissionCheck(true);
                    Permission_Granted = true;
                }

                else{
                    init();
                    app.t(getString(R.string.Declined));
                }
                break;
            }

            default: super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    private void seticon(){
        tabs.getTabAt(2).setIcon(R.drawable.ic_baseline_account_circle_24).setText("");
    }
}