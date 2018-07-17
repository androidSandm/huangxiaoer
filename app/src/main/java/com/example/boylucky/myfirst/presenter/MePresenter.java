package com.example.boylucky.myfirst.presenter;

import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.MeBean;
import com.example.boylucky.myfirst.model.MeModel;
import com.example.boylucky.myfirst.view.interfaces.IMeView;

import okhttp3.MultipartBody;

/**
 * Created by BoyLucky on 2018/7/9.
 */

public class MePresenter {
    private IMeView iMeView;
    private MeModel meModel;

    public MePresenter(IMeView iMeView) {
        this.iMeView = iMeView;
        meModel = new MeModel();
    }

    public void getData(String uid){
        meModel.getDataFrom(uid, new MeModel.GetModel() {
            @Override
            public void getModel(MeBean meBean) {
             iMeView.onSuccess(meBean);
            }

        });
    }
    public void deach(){
        if (iMeView != null){
            iMeView = null;
        }
    }

}
