package com.example.boylucky.myfirst.view.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.adapter.MyRlvAdapter;
import com.example.boylucky.myfirst.bean.ScanBean;
import com.example.boylucky.myfirst.presenter.ScanPresenter;
import com.example.boylucky.myfirst.utils.SpaceItemDecoration;
import com.example.boylucky.myfirst.view.interfaces.IScanView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BoyLucky on 2018/7/12.
 */

public class NewFrag extends Fragment implements IScanView {
    private View view;
    private Banner banner;
    private ScanPresenter scanPresenter;
    private RecyclerView rlv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_layout, null);
        initData();
        initView(view);
        return view;

    }

    private void initData() {
        scanPresenter = new ScanPresenter(this);
        scanPresenter.getData();
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        rlv = (RecyclerView) view.findViewById(R.id.rlv);
    }

    @Override
    public void onSuccess(ScanBean scanBean) {
        List<ScanBean.DataBean.BannerBean> banner1 = scanBean.getData().getBanner();
        List<ScanBean.DataBean.TuijianBean.ListBeanX> list = scanBean.getData().getTuijian().getList();
        rlv.setLayoutManager(new GridLayoutManager(getContext(),2));
//设置item间距，30dp
        rlv.addItemDecoration(new SpaceItemDecoration(30));
        MyRlvAdapter myRlvAdapter = new MyRlvAdapter(getContext(), list);
        rlv.setAdapter(myRlvAdapter);
        List<String> icon = new ArrayList<>();
        for (int i = 0; i < banner1.size(); i++) {
            icon.add(banner1.get(i).getIcon());
        }

        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setImageURI(Uri.parse((String) path));
            }

            @Override
            public ImageView createImageView(Context context) {
                GenericDraweeHierarchy builder = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        //设置圆角
                        .setRoundingParams(RoundingParams.fromCornersRadius(20)).build();
                SimpleDraweeView simg = new SimpleDraweeView(getContext());
                simg.setHierarchy(builder);
                return simg;
            }
        }).setImages(icon).start();
    }
}
