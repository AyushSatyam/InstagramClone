package com.example.a07ayu.instagramclone.Profile;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter{

    private final List<Fragment> list = new ArrayList<>();
    private final HashMap<Fragment,Integer> mFragment = new HashMap<>();
    private final HashMap<String,Integer> mFragmentNumber = new HashMap<>();
    private final HashMap<Integer,String> mFragmentName = new HashMap<>();
    public SectionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    public void addFragment(Fragment fragment,String fragmentName){
        list.add(fragment);
        mFragment.put(fragment,list.size()-1);
        mFragmentNumber.put(fragmentName,list.size()-1);
        mFragmentName.put(list.size()-1,fragmentName);
    }
    public Integer getFragmentNumber(String fragmentName){
        if(mFragmentNumber.containsKey(fragmentName)){
            return mFragmentNumber.get(fragmentName);
        }else
            return null;
    }

    public Integer getFragmentName(Integer fragmentNumber){
        if(mFragmentNumber.containsKey(fragmentNumber)){
            return mFragmentNumber.get(fragmentNumber);
        }else
            return null;
    }
}
