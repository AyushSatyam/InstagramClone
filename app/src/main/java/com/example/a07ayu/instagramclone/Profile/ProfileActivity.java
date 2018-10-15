package com.example.a07ayu.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.a07ayu.instagramclone.Helper.BottmNavigationIconHelper;
import com.example.a07ayu.instagramclone.Helper.GridViewImageHelper;
import com.example.a07ayu.instagramclone.Helper.UniversalImageHelper;
import com.example.a07ayu.instagramclone.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    Context context = ProfileActivity.this;
    ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileImage =(ImageView) findViewById(R.id.pvProfileImage);

        setUpToolbar();
        setupNavigationIcon();
        gridImage();
        initiateImageLoader();
        setProfileImage();
    }
    private void initiateImageLoader(){
        UniversalImageHelper universalImageHelper = new UniversalImageHelper(context);
        ImageLoader.getInstance().init(universalImageHelper.getConfig());

    }
    private void setProfileImage(){
        String imgURL = "icons.iconarchive.com/icons/alecive/flatwoken/512/Apps-Android-icon.png";
        UniversalImageHelper.setImage(imgURL,profileImage,null,"http://");
    }
    private void gridImage(){
        ArrayList<String> imageUrl = new ArrayList<>();
        imageUrl.add("http://www.wallpapersfans.com/wp-content/uploads/2016/10/most-beautiful-maldives-beach-high-definition-wallpaper.jpeg");
        imageUrl.add("http://www.wallpapersfans.com/wp-content/uploads/2016/11/michael_jackson_sunglas...hat_hair_wallpaper.jpg");
        imageUrl.add("http://www.loveimagesdownload.com/wp-content/uploads/2016/08/4235084-images-of-love.jpg");
        imageUrl.add("http://www.wallpapersfans.com/wp-content/uploads/2017/03/husqvarna-vitpilen-701-concept-hd-wallpaper.jpg");
        imageUrl.add("http://www.wallpapersfans.com/wp-content/uploads/2017/03/hawaiian-resort-beach-hd-wallpaper.jpg");
        imageUrl.add("http://www.wallpapersfans.com/wp-content/uploads/2017/12/Assassins_Creed_Warriors_Men_Sabre_Games_warrior_fantasy-hd-wallpaper.jpg");
        imageUrl.add("https://wallpaper-house.com/data/out/9/wallpaper2you_332131.jpg");
        imageUrl.add("http://www.loveimagesdownload.com/wp-content/uploads/2016/08/Love-Quotes.jpg");
        imageUrl.add("http://www.wallpapersfans.com/wp-content/uploads/2017/12/nature_mountain_eagle_fog_landscape_ultra__wallpaper-hd-wallpaper.jpg");
        imageUrl.add("http://www.loveimagesdownload.com/wp-content/uploads/2016/08/171916.jpg");
        imageUrl.add("http://www.bhmpics.com/wallpapers/lovers_walking_on_railway-852x480.jpg");

        setupImageGridView(imageUrl);
    }

    private void setupImageGridView(ArrayList<String> imageUrl) {
        GridView gridView =(GridView) findViewById(R.id.gridView);
        GridViewImageHelper helper = new GridViewImageHelper(context,R.layout.layout_grid_image_view,"",imageUrl);
        gridView.setAdapter(helper);
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);
        ImageView profileMenu = (ImageView) findViewById(R.id.profileSetting);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,AccountSettingActivity.class));
            }
        });
    }

    private void setupNavigationIcon(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation_icon);
        BottmNavigationIconHelper.setupBottomNavigation(bottomNavigationViewEx);
        BottmNavigationIconHelper.enableNavigationClick(context,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }

}
