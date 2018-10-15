package com.example.a07ayu.instagramclone.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a07ayu.instagramclone.Helper.BottmNavigationIconHelper;
import com.example.a07ayu.instagramclone.R;
import com.example.a07ayu.instagramclone.Register.LogInActivity;
import com.example.a07ayu.instagramclone.SectionPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private  FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "HomeActivity";
    Context context = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupfirebaseAuth();
        setupNavigationIcon();
        setUpViewPager();

        mAuth.signOut();
    }

    private void checkUser(FirebaseUser user){
        if(user == null)
        {
            startActivity(new Intent(context, LogInActivity.class));
        }
    }

    private void setupfirebaseAuth() {
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                checkUser(user);
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged: SignIn" + user.getUid());

                } else {
                    Log.d(TAG, "onAuthStateChanged: SignOut");
                }
            }
        };
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener!=null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }



    private void setupNavigationIcon(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation_icon);
        BottmNavigationIconHelper.setupBottomNavigation(bottomNavigationViewEx);
        BottmNavigationIconHelper.enableNavigationClick(HomeActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }
    public void setUpViewPager(){
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragment(new CameraFragment());
        sectionPagerAdapter.addFragment(new HomeFragment());
        sectionPagerAdapter.addFragment(new MessageFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(sectionPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_logo);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_messages);

    }
}
