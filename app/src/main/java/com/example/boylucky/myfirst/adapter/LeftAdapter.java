package com.example.boylucky.myfirst.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.bean.ShopListBean;
import com.example.boylucky.myfirst.view.interfaces.ItemOnClick;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/14.
 */

public class LeftAdapter extends RecyclerView.Adapter {
    List<ShopListBean.DataBean> data;
    private Context context;

    private ItemOnClick itemOnClick;

    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public LeftAdapter(List<ShopListBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.left_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(data.get(position).getName());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewHolder.huo.setVisibility(View.VISIBLE);
                itemOnClick.OnItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView huo;
        TextView tv;
        RelativeLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            huo = itemView.findViewById(R.id.huo);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
