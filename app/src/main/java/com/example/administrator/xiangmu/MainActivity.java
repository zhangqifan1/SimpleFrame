package com.example.administrator.xiangmu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initActionBar();
        initViewPager();
    }

    private void initViewPager() {
        List<Fragment> list=new ArrayList<>();
        list.add(new PictureFragment());
        list.add(new VideoFragment());
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setFragmentList(list);
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mViewPager.setAdapter(adapter);
        mTab.getTabAt(0).setText("图片");
        mTab.getTabAt(1).setText("视频");
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //考虑 ActionBar和DrawerLayout的联动
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open,R.string.close);
        mToggle.syncState();  //同步状态
        mDrawerLayout.addDrawerListener(mToggle);//添加监听
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mTab.setupWithViewPager(mViewPager);
    }


}
