package com.example.boylucky.myfirst.view.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.adapter.YuDingAdapter;
import com.example.boylucky.myfirst.bean.YuYueBean;
import com.example.boylucky.myfirst.presenter.IntentPresenter;
import com.example.boylucky.myfirst.utils.SpaceItemDecoration;
import com.example.boylucky.myfirst.view.activity.MapActivity;
import com.example.boylucky.myfirst.view.interfaces.IIndentView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/5.
 */

public class IndentFrag extends Fragment implements IIndentView {
    private View view;
    private RecyclerView mXrlv;
    /**
     * 中共中央电视台
     */
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.indent_frag, null);
        initView(view);
        initData();
        EventBus.getDefault().register(this);
        return view;
    }

    private void initData() {
        IntentPresenter intentPresenter = new IntentPresenter(this);
        intentPresenter.getData();
    }

    @Override
    public void onSuccess(YuYueBean yuYueBean) {
        List<YuYueBean.DataBean> data = yuYueBean.getData();
        mXrlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //设置item间距，30dp
        mXrlv.addItemDecoration(new SpaceItemDecoration(20));
        YuDingAdapter yuDingAdapter = new YuDingAdapter(getContext(), data);
        mXrlv.setAdapter(yuDingAdapter);

    }

    private void initView(View view) {
        mXrlv = view.findViewById(R.id.xrlv);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MapActivity.class));
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Subscribe
    public void getDress(String string){
        textView.setText(string);
    }
}
