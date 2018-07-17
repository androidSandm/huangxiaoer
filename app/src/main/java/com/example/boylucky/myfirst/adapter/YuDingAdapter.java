package com.example.boylucky.myfirst.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.bean.YuYueBean;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/13.
 */

public class YuDingAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<YuYueBean.DataBean> data;

    public YuDingAdapter(Context context, List<YuYueBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item, null);
        return new MyViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolde myViewHolde = (MyViewHolde) holder;
        GenericDraweeHierarchy builder = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                //设置圆角
                .setRoundingParams(RoundingParams.fromCornersRadius(20)).build();
        myViewHolde.s_img.setHierarchy(builder);
        myViewHolde.s_img.setImageURI(Uri.parse(data.get(position).getPic_url()));
        myViewHolde.name_tv.setText(data.get(position).getName());
        myViewHolde.tv.setText(data.get(position).getMonth_sales_tip()+"   评分  "+data.get(position).getDelivery_score());
        myViewHolde.tv2.setText(data.get(position).getAverage_price_tip());
        myViewHolde.tv3.setText(data.get(position).getDistance());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolde extends RecyclerView.ViewHolder {
        SimpleDraweeView s_img;
        ImageView img;
        TextView name_tv,tv,tv2,tv3;
        public MyViewHolde(View itemView) {
            super(itemView);
            s_img = itemView.findViewById(R.id.s_img);
            img = itemView.findViewById(R.id.img);
            name_tv = itemView.findViewById(R.id.name_tv);
            tv = itemView.findViewById(R.id.tv);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
