package com.example.a07ayu.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.a07ayu.instagramclone.Helper.BottmNavigationIconHelper;
import com.example.a07ayu.instagramclone.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class AccountSettingActivity extends AppCompatActivity{
   Context context = AccountSettingActivity.this;
   ViewPager viewPager;
   RelativeLayout relativeLayout;
   SectionStatePagerAdapter sectionStatePagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        viewPager = (ViewPager) findViewById(R.id.container);
        relativeLayout=(RelativeLayout) findViewById(R.id.relLayout1);

        //setUpToolbar();
        setupNavigationIcon();
        setupSettingList();
        ImageView imageView = (ImageView) findViewById(R.id.backArrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setupFragment();
    }
    private void setupNavigationIcon(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation_icon);
        BottmNavigationIconHelper.setupBottomNavigation(bottomNavigationViewEx);
        BottmNavigationIconHelper.enableNavigationClick(context,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }
    private void setupSettingList(){
        ListView listView =(ListView) findViewById(R.id.lvAccountSettings);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Edit Profile");
        arrayList.add("Sign Out");
        ArrayAdapter arrayAdapter = new ArrayAdapter(context,android.R.layout.simple_list_item_activated_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setViewPager(position);
            }
        });
    }

    private void setupFragment(){
       sectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
       sectionStatePagerAdapter.addFragment(new EditProfileFragment(),"Edit Profile");
       sectionStatePagerAdapter.addFragment(new SignoutFragment(),"Sign Out");

    }

    private void setViewPager(Integer fragmentNumber){
        relativeLayout.setVisibility(View.GONE);
        viewPager.setAdapter(sectionStatePagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }
}
