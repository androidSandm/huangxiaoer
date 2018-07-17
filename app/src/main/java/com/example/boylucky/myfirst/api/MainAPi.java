package com.example.boylucky.myfirst.api;


import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.LoginBean;
import com.example.boylucky.myfirst.bean.MeBean;
import com.example.boylucky.myfirst.bean.NewBean;
import com.example.boylucky.myfirst.bean.NickBean;
import com.example.boylucky.myfirst.bean.ScanBean;
import com.example.boylucky.myfirst.bean.ShopListBean;
import com.example.boylucky.myfirst.bean.YuYueBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public interface MainAPi {
    @GET("user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile,@Query("password") String password);
    @GET("user/getUserInfo")
    Observable<MeBean> getUser(@Query("uid") String uid);
    @GET("user/updateNickName")
    Observable<NickBean> getNickname(@Query("uid") String uid, @Query("nickname") String nickname);
    @GET("home/getHome")
    Observable<ScanBean> getScan();
    @GET("6523/restaurants_offset_0_limit_4")
    Observable<YuYueBean> getYue();
    @GET("6523/restaurant-list")
    Observable<ShopListBean> getShopList();
    @GET("quarter/getVersion")
    Observable<NewBean> getNew();
    @POST("file/upload")
    @Multipart
    Observable<FileBean> getFile(@Query("uid") String uid, @Part MultipartBody.Part file);
}
