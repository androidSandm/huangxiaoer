package com.example.boylucky.myfirst.model;

import android.util.Log;

import com.example.boylucky.myfirst.bean.LoginBean;
import com.example.boylucky.myfirst.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoyLucky on 2018/7/7.
 */

public class LoginModel {
    public void getData(String tel, String pwd, final GetModel getModel) {
        RetrofitUtils.getInstance().api()
                .getLogin(tel,pwd)//api 里的方法
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
					//请求成功，返回数据的方法
                    @Override
                    public void onNext(LoginBean loginBean) {
						
                        getModel.onSuccess(loginBean);
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
       void onSuccess(LoginBean loginBean);
    }
}
