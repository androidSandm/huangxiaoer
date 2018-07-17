package com.example.boylucky.myfirst.model;

import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.NickBean;
import com.example.boylucky.myfirst.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Created by BoyLucky on 2018/7/10.
 */

public class UserModel {

    public void getDataFrom(String uid, String s, final GetModel getModel) {
        RetrofitUtils.getInstance().api()
                .getNickname(uid,s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NickBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NickBean nickBean) {
                        getModel.onSuccess(nickBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getData(String uid, MultipartBody.Part part, final GetModel getModel) {
                RetrofitUtils.getInstance().api()
                        .getFile(uid,part)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<FileBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(FileBean fileBean) {
                                getModel.onSuccess(fileBean);
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
        void onSuccess(NickBean nickBean);

        void onSuccess(FileBean fileBean);
    }
}
