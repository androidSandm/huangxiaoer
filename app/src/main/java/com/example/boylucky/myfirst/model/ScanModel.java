package com.example.boylucky.myfirst.model;

import android.util.Log;

import com.example.boylucky.myfirst.bean.ScanBean;
import com.example.boylucky.myfirst.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoyLucky on 2018/7/11.
 */

public class ScanModel {
    public void getData(final GetModel getModel) {
        RetrofitUtils.getInstance().api()
                .getScan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ScanBean scanBean) {
                        Log.e("tag-----img","---------->"+scanBean.getData().getBanner().size());
                        getModel.onSuccess(scanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag-----img","---------->"+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface GetModel{
        void onSuccess(ScanBean scanBean);
    }
}
