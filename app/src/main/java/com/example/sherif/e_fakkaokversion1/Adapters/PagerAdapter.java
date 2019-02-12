package com.example.sherif.e_fakkaokversion1.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sherif.e_fakkaokversion1.Activities.User_SignUP;
import com.example.sherif.e_fakkaokversion1.Activities.Vendor_SignUp;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;


    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new User_SignUP();
            case 1:
                return new Vendor_SignUp();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return numOfTabs;
    }
}
