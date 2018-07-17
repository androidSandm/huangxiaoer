package com.example.boylucky.myfirst.model;

import android.util.Log;

import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.MeBean;
import com.example.boylucky.myfirst.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Created by BoyLucky on 2018/7/9.
 */

public class MeModel {
    public void getDataFrom(String uid, final GetModel getModel) {
        RetrofitUtils.getInstance().api()
                .getUser(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MeBean meBean) {
//                        Log.e("img", "++++++***++++" + meBean.getData().getIcon() + "-----" + meBean.getData().getUsername());

                        getModel.getModel(meBean);
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
        void getModel(MeBean meBean);
    }
}
