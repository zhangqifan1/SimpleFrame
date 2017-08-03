package com.example.administrator.xiangmu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 张祺钒
 * on2017/8/3.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void  setFragmentList(List<Fragment> list){
        fragmentList=list;
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
