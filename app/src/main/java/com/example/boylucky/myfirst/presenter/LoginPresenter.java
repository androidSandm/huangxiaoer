package com.example.boylucky.myfirst.presenter;

import android.util.Log;

import com.example.boylucky.myfirst.bean.LoginBean;
import com.example.boylucky.myfirst.model.LoginModel;
import com.example.boylucky.myfirst.view.interfaces.ILoginView;

/**
 * Created by BoyLucky on 2018/7/7.
 */

public class LoginPresenter {
    private ILoginView iLoginView;
    private LoginModel loginModel;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        loginModel = new LoginModel();
    }



    public void getData(String tel, String pwd) {
        Log.e("Tag","-----"+tel+"----"+pwd);
        loginModel.getData(tel,pwd,new LoginModel.GetModel() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iLoginView.onSuccess(loginBean);
            }
        });
    }
    public void deach(){
        if (iLoginView != null){
            iLoginView = null;
        }
    }
}
