package com.example.boylucky.myfirst.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.view.frag.IndentFrag;
import com.example.boylucky.myfirst.view.frag.MeFrag;
import com.example.boylucky.myfirst.view.frag.ScanFrag;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> list = new ArrayList<>();
    private IndentFrag indentFrag;
    private MeFrag meFrag;
    private ScanFrag scandFrag;
    private FrameLayout mFl;
    private View mNihao;
    private RadioGroup mRgOper;
    private ImageView mImgProtruding;
    private FragmentManager fragmentManager;
    private RadioButton mRdIndent;
    private RadioButton mRdScanp;
    private RadioButton mRdMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //设置状态栏的颜色
        StatusBarUtil.setColor(this, Color.YELLOW);
        //隐层App标题栏
        getSupportActionBar().hide();
        initView();
        fragmentManager = getSupportFragmentManager();
        mRdIndent.performClick();

    }

    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.fl);
        mNihao = (View) findViewById(R.id.nihao);
        mRgOper = (RadioGroup) findViewById(R.id.rg_oper);
        mImgProtruding = (ImageView) findViewById(R.id.img_protruding);
        mRdIndent = (RadioButton) findViewById(R.id.rd_indent);
        mRdIndent.setOnClickListener(this);
        mRdScanp = (RadioButton) findViewById(R.id.rd_scanp);
        mRdScanp.setOnClickListener(this);
        mRdMe = (RadioButton) findViewById(R.id.rd_me);
        mRdMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rd_indent:
                fragmentManager.beginTransaction().replace(R.id.fl, new IndentFrag()).commit();
                break;
            case R.id.rd_scanp:
                fragmentManager.beginTransaction().replace(R.id.fl, new ScanFrag()).commit();
                break;
            case R.id.rd_me:
                fragmentManager.beginTransaction().replace(R.id.fl, new MeFrag()).commit();
                break;
        }
    }
}
