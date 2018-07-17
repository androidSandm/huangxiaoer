package com.example.boylucky.myfirst.model;

import com.example.boylucky.myfirst.bean.NewBean;
import com.example.boylucky.myfirst.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoyLucky on 2018/7/16.
 */

public class NewModel {
    public void getFile(final GetModel getModel) {
        RetrofitUtils.getInstance().api()
                .getNew()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewBean newBean) {
                        getModel.getModel(newBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface GetModel{
        void getModel(NewBean newBean);
    }
}
