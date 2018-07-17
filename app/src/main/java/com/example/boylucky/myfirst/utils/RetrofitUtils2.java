package com.example.boylucky.myfirst.utils;

import com.example.boylucky.myfirst.api.MainAPi;
import com.example.boylucky.myfirst.common.Contanx;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BoyLucky on 2018/7/7.
 */

public class RetrofitUtils2 {
    public static MainAPi mainAPi;
    public static RetrofitUtils2 retrofitUtils;

    public RetrofitUtils2() {
        OkHttpClient builder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contanx.URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder)
                .build();
        mainAPi = retrofit.create(MainAPi.class);
    }

    public static RetrofitUtils2 getInstance(){
        if (retrofitUtils == null){
            retrofitUtils = new RetrofitUtils2();
        }
        return retrofitUtils;
    }
    public MainAPi api(){
        return mainAPi;
    }
}
