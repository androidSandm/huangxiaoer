package com.example.boylucky.myfirst.model;

import com.example.boylucky.myfirst.bean.ShopListBean;
import com.example.boylucky.myfirst.utils.RetrofitUtils;
import com.example.boylucky.myfirst.utils.RetrofitUtils2;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoyLucky on 2018/7/14.
 */

public class CaiPinModel {
    public void getData(final Caipin caipin) {
        RetrofitUtils2.getInstance().api()
                .getShopList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopListBean shopListBean) {
                        caipin.onSuccess(shopListBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface Caipin{
        void onSuccess(ShopListBean shopListBean);
    }
}
