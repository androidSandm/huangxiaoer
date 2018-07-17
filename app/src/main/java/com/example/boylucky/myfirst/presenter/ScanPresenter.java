package com.example.boylucky.myfirst.presenter;

import com.example.boylucky.myfirst.bean.ScanBean;
import com.example.boylucky.myfirst.model.ScanModel;
import com.example.boylucky.myfirst.view.interfaces.IScanView;

/**
 * Created by BoyLucky on 2018/7/11.
 */

public class ScanPresenter {
    private IScanView iScanView;
    private ScanModel scanModel;

    public ScanPresenter(IScanView iScanView) {
        this.iScanView = iScanView;
        scanModel = new ScanModel();
    }
    public void deach(){
        if (iScanView != null){
            iScanView = null;
        }
    }

    public void getData() {
        scanModel.getData(new ScanModel.GetModel() {
            @Override
            public void onSuccess(ScanBean scanBean) {
                iScanView.onSuccess(scanBean);
            }
        });
    }
}
