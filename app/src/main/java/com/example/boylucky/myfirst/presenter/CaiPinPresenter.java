package com.example.boylucky.myfirst.presenter;

import com.example.boylucky.myfirst.bean.ShopListBean;
import com.example.boylucky.myfirst.model.CaiPinModel;
import com.example.boylucky.myfirst.view.interfaces.ICaiPinView;

/**
 * Created by BoyLucky on 2018/7/14.
 */

public class CaiPinPresenter {
    private ICaiPinView iCaiPinView;
    private CaiPinModel caiPinModel;

    public CaiPinPresenter(ICaiPinView iCaiPinView) {
        this.iCaiPinView = iCaiPinView;
        caiPinModel = new CaiPinModel();
    }

    public void  getData() {
        caiPinModel.getData(new CaiPinModel.Caipin() {
            @Override
            public void onSuccess(ShopListBean shopListBean) {
                iCaiPinView.onSuccess(shopListBean);
            }
        });
    }
}
