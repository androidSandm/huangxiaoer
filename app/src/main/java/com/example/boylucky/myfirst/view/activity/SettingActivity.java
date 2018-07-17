package com.example.boylucky.myfirst.view.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.utils.CleanMessageUtil;
import com.jaeger.library.StatusBarUtil;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 设置页面
     * 0MB
     */
    private TextView del_num;
    private RelativeLayout del_tu;
    private Dialog dialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                dialog.dismiss();
                String totalCacheSize = CleanMessageUtil.getTotalCacheSize(SettingActivity.this);
                del_num.setText(totalCacheSize);
            }
        }
    };
    private RelativeLayout mRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        //隐层App标题栏
        getSupportActionBar().hide();
        //设置状态栏的颜色
        StatusBarUtil.setColor(this, Color.YELLOW);
    }

    private void initView() {
        del_num = (TextView) findViewById(R.id.del_num);
        del_tu = (RelativeLayout) findViewById(R.id.del_tu);
        String totalCacheSize = CleanMessageUtil.getTotalCacheSize(this);
        del_num.setText(totalCacheSize);
        del_tu.setOnClickListener(this);
        mRl = (RelativeLayout) findViewById(R.id.rl);
        mRl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.del_tu:
                Message message = new Message();
                dialog = createLoadingDialog(this);
                dialog.show();
                CleanMessageUtil.clearAllCache(this);
                message.what = 1;
                handler.sendMessageDelayed(message, 1000);
                break;
            case R.id.rl:
                startActivity(new Intent(this,NewBActivity.class));
                break;
        }
    }

    //自定义清理对话框
    public static Dialog createLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("清理中...");
//        progressDialog.setCancelable(true);// 不可以用“返回键”取消
        return progressDialog;
    }
}
