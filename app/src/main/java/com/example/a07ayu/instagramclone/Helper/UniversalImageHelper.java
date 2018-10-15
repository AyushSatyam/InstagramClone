package com.example.a07ayu.instagramclone.Helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.a07ayu.instagramclone.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class UniversalImageHelper {
    private static final int Image = R.mipmap.ic_launcher;
    Context context;
    public UniversalImageHelper(Context context){
    this.context = context;
    }
    public ImageLoaderConfiguration getConfig(){
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(Image)
                .showImageForEmptyUri(Image)
                .showImageOnFail(Image)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(displayImageOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100*1024*1024).build();
        return configuration;
    }

    public static void setImage(String imageUrl, ImageView imageView, final ProgressBar progressBar,String append){
       ImageLoader imageLoader = ImageLoader.getInstance();
       imageLoader.displayImage(append + imageUrl, imageView, new ImageLoadingListener() {
           @Override
           public void onLoadingStarted(String imageUri, View view) {
               if(progressBar!= null)
               {
                   progressBar.setVisibility(View.VISIBLE);
               }
           }

           @Override
           public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
               if(progressBar!= null)
               {
                   progressBar.setVisibility(View.VISIBLE);
               }
           }

           @Override
           public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
               if(progressBar!= null)
               {
                   progressBar.setVisibility(View.VISIBLE);
               }
           }

           @Override
           public void onLoadingCancelled(String imageUri, View view) {
               if(progressBar!= null)
               {
                   progressBar.setVisibility(View.VISIBLE);
               }
           }
       });
    }
}