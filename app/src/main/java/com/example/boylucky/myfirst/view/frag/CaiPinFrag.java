package com.example.boylucky.myfirst.view.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.adapter.LeftAdapter;
import com.example.boylucky.myfirst.adapter.RightAdapter;
import com.example.boylucky.myfirst.bean.ShopListBean;
import com.example.boylucky.myfirst.presenter.CaiPinPresenter;
import com.example.boylucky.myfirst.view.interfaces.ICaiPinView;
import com.example.boylucky.myfirst.view.interfaces.ItemOnClick;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/13.
 */

public class CaiPinFrag extends Fragment implements ICaiPinView {

    private CaiPinPresenter presenter;
    private View view;
    private RecyclerView mRlvLeft;
    private RecyclerView mRlvRight;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cai_item, null);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        presenter = new CaiPinPresenter(this);
        presenter.getData();
    }


    @Override
    public void onSuccess(ShopListBean shopListBean) {
        final List<ShopListBean.DataBean> data = shopListBean.getData();
        mRlvLeft.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        LeftAdapter leftAdapter = new LeftAdapter(data, getContext());
        mRlvLeft.setAdapter(leftAdapter);
        leftAdapter.setItemOnClick(new ItemOnClick() {
            @Override
            public void OnItemClick(View view, int p) {
                List<ShopListBean.DataBean.SpusBean> spus = data.get(p).getSpus();
                mRlvRight.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                RightAdapter rightAdapter = new RightAdapter(getContext(), spus);
                mRlvRight.setAdapter(rightAdapter);

            }
        });
    }

    private void initView(View view) {
        mRlvLeft = (RecyclerView) view.findViewById(R.id.rlv_left);
        mRlvRight = (RecyclerView) view.findViewById(R.id.rlv_right);
    }
}
