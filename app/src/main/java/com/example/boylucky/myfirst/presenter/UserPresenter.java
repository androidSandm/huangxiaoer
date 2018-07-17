package com.example.boylucky.myfirst.presenter;

import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.NickBean;
import com.example.boylucky.myfirst.model.UserModel;
import com.example.boylucky.myfirst.view.interfaces.IUserView;

import okhttp3.MultipartBody;

/**
 * Created by BoyLucky on 2018/7/10.
 */

public class UserPresenter {
    private IUserView iUserView;
    private UserModel userModel;

    public UserPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
        userModel = new UserModel();
    }


    public void getData(String uid, String s) {
        userModel.getDataFrom(uid, s, new UserModel.GetModel() {
            @Override
            public void onSuccess(NickBean nickBean) {
                iUserView.onSuccess(nickBean);
            }

            @Override
            public void onSuccess(FileBean fileBean) {

            }
        });
    }
    public void deach(){
        if (iUserView != null){
            iUserView = null;
        }
    }

    public void getDataFrom(String uid, MultipartBody.Part part) {
        userModel.getData(uid,part, new UserModel.GetModel() {
            @Override
            public void onSuccess(NickBean nickBean) {

            }

            @Override
            public void onSuccess(FileBean fileBean) {
                iUserView.onSuccess(fileBean);
            }
        });
    }
}
