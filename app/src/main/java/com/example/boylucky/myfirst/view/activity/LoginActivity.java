package com.example.boylucky.myfirst.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.bean.LoginBean;
import com.example.boylucky.myfirst.presenter.LoginPresenter;
import com.example.boylucky.myfirst.view.interfaces.ILoginView;
import com.jaeger.library.StatusBarUtil;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import cn.smssdk.SMSSDK;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    /**
     * 使用常规登录方式
     */
    private TextView c_tv;
    /**
     * 短信验证码登录方式
     */
    private TextView y_tv;
    private ImageView c_login;
    private LinearLayout c_ll;
    private ImageView y_login;
    private LinearLayout y_ll;
    private LoginPresenter loginPresenter;
    /**
     * 请输入手机号码
     */
    private EditText tel_edit3;
    /**
     * 请输入验证码
     */
    private EditText pwd_edit4;
    private TextView duanxin;
    private TimeCount time;
    /**
     * 请输入手机号码
     */
    private EditText mTelEdit;
    /**
     * 请输入验证码
     */
    private EditText mPwdEdit;
    private String tel1;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private String tel;
    private String pwd;

    private Tencent mTencent;
    private String APP_ID = "1106962563";
    private IUiListener loginListener;
    private String SCOPE = "all";
    private ImageView mQq;
    private ImageView mWeixin;
    private IUiListener userInfoListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        //隐层App标题栏
        getSupportActionBar().hide();
        //设置状态栏的颜色
        StatusBarUtil.setColor(this, Color.YELLOW);
        sp = getSharedPreferences("User", MODE_PRIVATE);
        edit = sp.edit();

        String uid = sp.getString("uid", null);
        String token = sp.getString("token", null);
        String ret = sp.getString("ret", "1");
        Log.e("uid", "-------" + uid + "===========" + token);
        if (uid == null && token == null&&!ret.equals("0")) {
            time = new TimeCount(60000, 1000);
            initView();
        } else {
            startActivity(new Intent(this, FirstActivity.class));
            finish();
        }


    }

    private void initData() {
        loginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        c_tv = (TextView) findViewById(R.id.c_tv);
        c_tv.setOnClickListener(this);
        y_tv = (TextView) findViewById(R.id.y_tv);
        y_tv.setOnClickListener(this);
        c_login = (ImageView) findViewById(R.id.c_login);
        c_login.setOnClickListener(this);
        c_ll = (LinearLayout) findViewById(R.id.c_ll);
        y_login = (ImageView) findViewById(R.id.y_login);
        y_login.setOnClickListener(this);
        y_ll = (LinearLayout) findViewById(R.id.y_ll);
        tel_edit3 = (EditText) findViewById(R.id.tel_edit3);
        pwd_edit4 = (EditText) findViewById(R.id.pwd_edit4);
        duanxin = (TextView) findViewById(R.id.duanxin);
        duanxin.setOnClickListener(this);
        mTelEdit = (EditText) findViewById(R.id.tel_edit);
        mPwdEdit = (EditText) findViewById(R.id.pwd_edit);

        mPwdEdit.setOnClickListener(this);
        mQq = (ImageView) findViewById(R.id.qq);
        mQq.setOnClickListener(this);
        mWeixin = (ImageView) findViewById(R.id.weixin);
        mWeixin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.c_tv:
                c_ll.setVisibility(View.GONE);
                y_ll.setVisibility(View.VISIBLE);
                break;
            case R.id.y_tv:
                y_ll.setVisibility(View.GONE);
                c_ll.setVisibility(View.VISIBLE);
                break;
            case R.id.c_login:
                String pwd_d = mPwdEdit.getText().toString();
                if (pwd_d != null && !pwd_d.equals("")) {
                    SMSSDK.submitVerificationCode("+86", tel1, pwd_d);
                    startActivity(new Intent(this, FirstActivity.class));
                    finish();
                }
                break;
            case R.id.y_login:
                tel = tel_edit3.getText().toString();
                pwd = pwd_edit4.getText().toString();
                loginPresenter.getData(tel, pwd);
                break;
            case R.id.duanxin:
                tel1 = mTelEdit.getText().toString();
                if (tel1 != null && !tel1.equals("")) {
                    SMSSDK.getVerificationCode("+86", tel1);
                    time.start();
                } else {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pwd_edit:
                break;
            case R.id.qq:
                initQqLogin();
                mTencent.login(this, SCOPE, loginListener);
                break;
            case R.id.weixin:
                break;
        }
    }

    //初始化QQ登录分享的需要的资源
    private void initQqLogin() {
        mTencent = Tencent.createInstance(APP_ID, this);
        //创建QQ登录回调接口
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                //登录成功后调用的方法
                JSONObject jo = (JSONObject) o;
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                Log.e("COMPLETE:-------->", jo.toString());
                String openID;
                try {
                    openID = jo.getString("openid");
                    String accessToken = jo.getString("access_token");
                    String expires = jo.getString("expires_in");
                    mTencent.setOpenId(openID);
                    mTencent.setAccessToken(accessToken, expires);
                } catch (JSONException e) {
                    e.printStackTrace();
                } }

            @Override
            public void onError(UiError uiError) {
                //登录失败后回调该方法
                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                Log.e("LoginError:", uiError.toString());
            }

            @Override
            public void onCancel() {
                //取消登录后回调该方法
                Toast.makeText(LoginActivity.this, "取消登录", Toast.LENGTH_SHORT).show();
            }
        };

        userInfoListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                if(o == null){
                    return;
                }
                try {
                    JSONObject jo = (JSONObject) o;
                    Log.e("JO:",jo.toString());
                    int ret = jo.getInt("ret");
                    String nickName = jo.getString("nickname");
                    String gender = jo.getString("gender");
                    String qq_2 = jo.getString("figureurl_qq_2");
                    edit.putString("ret",ret+"");
                    edit.putString("nickName",nickName);
                    edit.putString("qq_2",qq_2);
                    edit.commit();
                    Log.e("ret","-------->"+ret);
                    Toast.makeText(LoginActivity.this, "你好，" + nickName,Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                }
            }
            @Override
            public void onError(UiError uiError) {
            }
            @Override
            public void onCancel() {
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_LOGIN) {
            if (resultCode == -1) {
                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
                Tencent.handleResultData(data, loginListener);
                UserInfo info = new UserInfo(this, mTencent.getQQToken());
                info.getUserInfo(userInfoListener);
                startActivity(new Intent(this, FirstActivity.class));
                finish();
            }
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginBean.getCode().equals("0")) {
            edit.putString("username", loginBean.getData().getUsername() + "");
            edit.putString("nick", loginBean.getData().getNickname() + "");
            edit.putString("uid", loginBean.getData().getUid() + "");
            edit.putString("token", loginBean.getData().getToken() + "");
            edit.commit();
            startActivity(new Intent(this, FirstActivity.class));
            finish();
        } else {
            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.deach();
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            duanxin.setClickable(false);
            Resources resources = getBaseContext().getResources();
            Drawable drawable = resources.getDrawable(R.mipmap.time);
            duanxin.setBackgroundDrawable(drawable);
            duanxin.setText(millisUntilFinished / 1000 + " (S)");
        }

        @Override
        public void onFinish() {
            Resources resources = getBaseContext().getResources();
            Drawable drawable = resources.getDrawable(R.mipmap.two_verification);
            duanxin.setBackgroundDrawable(drawable);
            duanxin.setText("");
            duanxin.setClickable(true);
        }
    }
}
