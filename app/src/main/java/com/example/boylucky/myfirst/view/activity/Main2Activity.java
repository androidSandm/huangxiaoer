package com.example.boylucky.myfirst.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.boylucky.myfirst.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;

public class Main2Activity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private ImageView mStartImg;
    private ImageView mXiaoer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        //隐层App标题栏
        getSupportActionBar().hide();
        //设置状态栏的颜色
        StatusBarUtil.setTransparent(this);
    }

    private void initView() {
        mStartImg = (ImageView) findViewById(R.id.start_img);
        mStartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, LoginActivity.class));
                finish();
            }
        });
        mXiaoer = findViewById(R.id.xiaoer);
        Glide.with(this).load(R.mipmap.splash).into(new GlideDrawableImageViewTarget(mXiaoer,1));
        //加载本地图片              "res://包名/"+R.mipmap.图片id
//        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
//                .setUri("res://com.xxx.xxx/" + R.mipmap.splash)
//                .setOldController(mXiaoer.getController())
//                .setAutoPlayAnimations(false)
//                .build();
//        mXiaoer.setController(draweeController);

    }
}
