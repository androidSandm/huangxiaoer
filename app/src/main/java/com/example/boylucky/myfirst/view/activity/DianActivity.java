package com.example.boylucky.myfirst.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.view.frag.CaiPinFrag;
import com.example.boylucky.myfirst.view.frag.PingFrag;

import java.util.ArrayList;
import java.util.List;

public class DianActivity extends AppCompatActivity {

    private ImageView mLie;
    private TabLayout mTab;
    private String[] str = {"餐品", "评价"};
    private List<Fragment> frag = new ArrayList<>();
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian);
        //隐层App标题栏
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < str.length; i++) {
            mTab.addTab(mTab.newTab().setText(str[i]));
        }
        frag.add(new CaiPinFrag());
        frag.add(new PingFrag());

        mVp.setAdapter(new MyAdapter(getSupportFragmentManager(),frag));
        mTab.setupWithViewPager(mVp);
    }


    private void initView() {
        mLie = (ImageView) findViewById(R.id.lie);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
    public class MyAdapter extends FragmentPagerAdapter{
        List<Fragment> frag;

        public MyAdapter(FragmentManager fm, List<Fragment> frag) {
            super(fm);
            this.frag = frag;
        }

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position < frag.size()) {
                fragment = frag.get(position);
            } else {
                fragment = frag.get(0);
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return frag.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            if (str != null && str.length > 0){
                return str[position];
            }
            return null;
        }
    }
}
