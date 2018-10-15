package com.example.a07ayu.instagramclone.Profile;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a07ayu.instagramclone.Helper.UniversalImageHelper;
import com.example.a07ayu.instagramclone.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment{
    ImageView imageProfile;
    ImageView imageBack;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acitivity_editprofile,container,false);

        imageProfile = (ImageView) view.findViewById(R.id.profile_Photo);
        imageBack = (ImageView) view.findViewById(R.id.profile_Photo);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        initiateImageLoader();
        setProfileImage();
        return view;
    }

    private void initiateImageLoader(){
        UniversalImageHelper  universalImageHelper = new UniversalImageHelper(getActivity());
        ImageLoader.getInstance().init(universalImageHelper.getConfig());

    }

    private void setProfileImage(){
        String imgURL = "icons.iconarchive.com/icons/alecive/flatwoken/512/Apps-Android-icon.png";
        UniversalImageHelper.setImage(imgURL,imageProfile,null,"http://");
    }

}
