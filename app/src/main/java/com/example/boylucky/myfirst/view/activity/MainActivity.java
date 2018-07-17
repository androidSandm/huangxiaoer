package com.example.boylucky.myfirst.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.adapter.GuidePageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private int[] imageIdArray;//图片资源的数组
    private List<View> viewList;//图片资源的集合
    private int width;
    private int currentPage;

    private boolean flag1;
    private SharedPreferences sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐层App标题栏
        getSupportActionBar().hide();
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
//        sp = getSharedPreferences("first",MODE_PRIVATE);
//        edit = sp.edit();
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);

        sp1 = getSharedPreferences("shou", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = sp1.edit();
        boolean flag = sp1.getBoolean("flag", false);
        if (!flag){


        //实例化图片资源
        imageIdArray = new int[]{R.drawable.q1, R.drawable.q2, R.drawable.q3};
        viewList = new ArrayList<>();
        //获取一个Layout参数，设置为全屏
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //循环创建View并加入到集合中
        for (int i = 0; i < imageIdArray.length; i++) {
            //new ImageView并设置全屏和图片资源
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(imageIdArray[i]);
            //将ImageView加入到集合中
            viewList.add(imageView);
        }
        //View集合初始化好后，设置Adapter
        final GuidePageAdapter adapter = new GuidePageAdapter(viewList);
        mVp.setAdapter(new GuidePageAdapter(viewList));
        //设置滑动监听
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        flag1 = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        flag1 = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (mVp.getCurrentItem() == adapter.getCount() - 1 && !flag1) {
                            startActivity(new Intent(MainActivity.this, Main2Activity.class));
                            finish();
                            overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
                        }
                        flag1 = true;
                        edit.putBoolean("flag", flag1);
                        edit.commit();
                        break;
                }
             }
            });
        }else{
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
            finish();
            overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
        }
    }
}
