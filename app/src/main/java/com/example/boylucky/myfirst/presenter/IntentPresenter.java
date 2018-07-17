package com.example.boylucky.myfirst.presenter;

import com.example.boylucky.myfirst.bean.YuYueBean;
import com.example.boylucky.myfirst.model.IntentModel;
import com.example.boylucky.myfirst.view.interfaces.IIndentView;

/**
 * Created by BoyLucky on 2018/7/13.
 */

public class IntentPresenter {
    private IIndentView iIndentView;
    private IntentModel intentModel;

    public IntentPresenter(IIndentView iIndentView) {
        this.iIndentView = iIndentView;
        intentModel = new IntentModel();
    }

    public void getData() {
        intentModel.getData(new IntentModel.GetModel() {
            @Override
            public void getModel(YuYueBean yuYueBean) {
                iIndentView.onSuccess(yuYueBean);
            }
        });
    }
}
