package com.example.boylucky.myfirst.utils;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;
import com.tencent.bugly.crashreport.CrashReport;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by BoyLucky on 2018/7/6.
 */

public class App extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        MobSDK.init(this);
        Fresco.initialize(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
        CrashReport.initCrashReport(getApplicationContext(),"4f9cdf8c0e",false);
    }
}
