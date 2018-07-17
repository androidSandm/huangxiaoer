package com.example.boylucky.myfirst.view.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.view.activity.DianActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BoyLucky on 2018/7/5.
 */

public class ScanFrag extends Fragment implements View.OnClickListener {
    private View view;
    private TabLayout mTab;
    private String[] title = {"热销", "招牌", "小吃", "主食", "饮品", "零食", "其他"};
    private ViewPager mVp;
    private ImageView mLie;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scan_frag, null);
        initView(view);
        return view;
    }


    private void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mVp = (ViewPager) view.findViewById(R.id.vp);
        List<Fragment> frag = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            mTab.addTab(mTab.newTab().setText(title[i]));
            frag.add(new NewFrag());
        }
        MVpAdapter mVpAdapter = new MVpAdapter(getFragmentManager(), frag);
        mVp.setAdapter(mVpAdapter);
        mTab.setupWithViewPager(mVp);
        mLie = (ImageView) view.findViewById(R.id.lie);
        mLie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.lie:
                startActivity(new Intent(getContext(), DianActivity.class));
                break;
        }
    }

    public class MVpAdapter extends FragmentPagerAdapter {
        List<Fragment> frag;

        public MVpAdapter(FragmentManager fm, List<Fragment> frag) {
            super(fm);
            this.frag = frag;
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
            if (title != null && title.length > 0){
                return title[position];
            }
            return null;
        }
    }
}