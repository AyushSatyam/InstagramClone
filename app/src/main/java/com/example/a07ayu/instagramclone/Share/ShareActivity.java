package com.example.a07ayu.instagramclone.Share;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a07ayu.instagramclone.Helper.BottmNavigationIconHelper;
import com.example.a07ayu.instagramclone.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupNavigationIcon();
    }
    private void setupNavigationIcon(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation_icon);
        BottmNavigationIconHelper.setupBottomNavigation(bottomNavigationViewEx);
        BottmNavigationIconHelper.enableNavigationClick(ShareActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
    }
}
