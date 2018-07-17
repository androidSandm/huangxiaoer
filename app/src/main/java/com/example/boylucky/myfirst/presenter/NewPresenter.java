package com.example.boylucky.myfirst.presenter;

import com.example.boylucky.myfirst.bean.NewBean;
import com.example.boylucky.myfirst.model.NewModel;
import com.example.boylucky.myfirst.view.interfaces.INewView;

/**
 * Created by BoyLucky on 2018/7/16.
 */

public class NewPresenter {
    private INewView iNewView;
    private NewModel newModel;

    public NewPresenter(INewView iNewView) {
        this.iNewView = iNewView;
        newModel = new NewModel();
    }

    public void getFile() {
        newModel.getFile(new NewModel.GetModel() {
            @Override
            public void getModel(NewBean newBean) {
                iNewView.onSuccess(newBean);
            }
        });
    }
}
