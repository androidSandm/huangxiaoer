package com.example.boylucky.myfirst.model;

import com.example.boylucky.myfirst.bean.YuYueBean;
import com.example.boylucky.myfirst.utils.RetrofitUtils;
import com.example.boylucky.myfirst.utils.RetrofitUtils2;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoyLucky on 2018/7/13.
 */

public class IntentModel {

    public void getData(final GetModel getModel) {
        RetrofitUtils2.getInstance().api()
                .getYue()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YuYueBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YuYueBean yuYueBean) {
                        getModel.getModel(yuYueBean);
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
        void getModel(YuYueBean yuYueBean);
    }
}
