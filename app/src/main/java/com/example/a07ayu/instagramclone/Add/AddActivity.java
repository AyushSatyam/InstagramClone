package com.example.a07ayu.instagramclone.Add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a07ayu.instagramclone.Helper.BottmNavigationIconHelper;
import com.example.a07ayu.instagramclone.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //setupNavigationIcon();
    }
    private void setupNavigationIcon(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation_icon);
        BottmNavigationIconHelper.setupBottomNavigation(bottomNavigationViewEx);
        BottmNavigationIconHelper.enableNavigationClick(AddActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
    }
}
