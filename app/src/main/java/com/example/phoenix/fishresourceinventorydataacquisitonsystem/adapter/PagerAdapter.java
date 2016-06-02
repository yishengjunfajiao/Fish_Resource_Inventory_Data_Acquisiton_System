package com.example.phoenix.fishresourceinventorydataacquisitonsystem.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;

import java.util.List;

/**
 * @author CJX
 *         Created on 2016/6/2.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = null;

    public PagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ConstantData.TITLE[position];
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
