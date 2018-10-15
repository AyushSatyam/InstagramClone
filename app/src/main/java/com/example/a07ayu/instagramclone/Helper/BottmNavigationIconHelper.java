package com.example.a07ayu.instagramclone.Helper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.a07ayu.instagramclone.Add.AddActivity;
import com.example.a07ayu.instagramclone.Home.HomeActivity;
import com.example.a07ayu.instagramclone.Profile.ProfileActivity;
import com.example.a07ayu.instagramclone.R;
import com.example.a07ayu.instagramclone.Search.SearchActivity;
import com.example.a07ayu.instagramclone.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class  BottmNavigationIconHelper {
    public static void setupBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigationClick(final Context context, BottomNavigationViewEx viewEx){
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Home:
                        context.startActivity(new Intent(context, HomeActivity.class));
                        break;
                        case R.id.Search:
                        context.startActivity(new Intent(context, SearchActivity.class));
                        break;
                        case R.id.Add:
                        context.startActivity(new Intent(context, AddActivity.class));
                        break;
                        case R.id.Share:
                        context.startActivity(new Intent(context, ShareActivity.class));
                        break;
                        case R.id.Profile:
                        context.startActivity(new Intent(context, ProfileActivity.class));
                        break;
                }


                return false;
            }
        });
    }
}
