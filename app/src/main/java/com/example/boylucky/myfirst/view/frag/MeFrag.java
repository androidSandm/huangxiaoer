package com.example.boylucky.myfirst.view.frag;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.MeBean;
import com.example.boylucky.myfirst.presenter.MePresenter;
import com.example.boylucky.myfirst.utils.App;
import com.example.boylucky.myfirst.utils.ScreenSizeUtils;
import com.example.boylucky.myfirst.view.activity.SettingActivity;
import com.example.boylucky.myfirst.view.activity.UserActivity;
import com.example.boylucky.myfirst.view.interfaces.IMeView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by BoyLucky on 2018/7/5.
 */

public class MeFrag extends Fragment implements View.OnClickListener, IMeView {
    private View view;
    private RelativeLayout mShezhi;
    private RelativeLayout user;
    private RelativeLayout like;
    private RelativeLayout cou;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private MePresenter mePresenter;
    private SimpleDraweeView mTou;
    /**
     * 用户名
     */
    private TextView mName;
    private String uid;
    private String token;
    private MeBean.DataBean data;
    private String ret;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_frag, null);
        sp = App.context.getSharedPreferences("User", MODE_PRIVATE);

        edit = sp.edit();
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        uid = sp.getString("uid", null);
        ret = sp.getString("ret", "1");
        Log.e("img-----------", "000000+" + uid + "-----" + token);
        if (!ret.equals("0")&&!uid.equals(null)){
            mePresenter = new MePresenter(this);
            mePresenter.getData(uid);
        }else{
            String nickName = sp.getString("nickName", "");
            String qq_2 = sp.getString("qq_2", "");
            if (!nickName.equals("")&&!qq_2.equals("")){
                mName.setText(nickName);
                mTou.setImageURI(Uri.parse(qq_2));
            }
        }
    }


    private void initView(View view) {
        mShezhi = (RelativeLayout) view.findViewById(R.id.shezhi);
        mShezhi.setOnClickListener(this);
        user = (RelativeLayout) view.findViewById(R.id.user);
        user.setOnClickListener(this);
        like = (RelativeLayout) view.findViewById(R.id.like);
        like.setOnClickListener(this);
        cou = (RelativeLayout) view.findViewById(R.id.cou);
        cou.setOnClickListener(this);
        mTou = (SimpleDraweeView) view.findViewById(R.id.tou1);
        mName = (TextView) view.findViewById(R.id.name);
        mTou.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.shezhi:
                startActivity(new Intent(App.context, SettingActivity.class));
                break;
            case R.id.user:
                Intent intent = new Intent(App.context, UserActivity.class);
                if (!ret.equals("0")&&!uid.equals(null)){
                    intent.putExtra("icon",data.getIcon());
                    intent.putExtra("nikname",data.getNickname()+"");
                    intent.putExtra("uid",data.getUid()+"");
                    intent.putExtra("token",data.getToken());
                    Log.e("uid--====","*-*-*-*-*-*-"+data.getUid()+"-*-*-*-"+data.getToken());

                }else{
                    String nickName = sp.getString("nickName", "");
                    String qq_2 = sp.getString("qq_2", "");
                    intent.putExtra("qq_2",qq_2);
                    intent.putExtra("nickName",nickName);
                    Log.e("uid--====","*-*-*-*-*-*-"+nickName);
                }

                startActivity(intent);
                break;
            case R.id.like:
                break;
            case R.id.cou:
                break;
        }
    }
    @Override
    public void onSuccess(MeBean meBean) {
        data = meBean.getData();
        mTou.setImageURI(data.getIcon());
        mName.setText(data.getNickname()+"");

    }

}
