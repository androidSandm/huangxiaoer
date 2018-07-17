package com.example.boylucky.myfirst.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.bean.ShopListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/16.
 */

public class RightAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ShopListBean.DataBean.SpusBean> list;

    public RightAdapter(Context context, List<ShopListBean.DataBean.SpusBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.shi_name.setText(list.get(position).getName());
            myViewHolder.shi_yue.setText(list.get(position).getMonth_saled_content());
            myViewHolder.shi_price.setText(list.get(position).getSkus().get(0).getPrice());
            myViewHolder.shi_img.setImageURI(Uri.parse(list.get(position).getPic_url()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView shi_img;
        ImageView jian,jia;
        TextView shi_name,shi_yue,shi_price,shi_num;
        public MyViewHolder(View itemView) {
            super(itemView);
            shi_img = itemView.findViewById(R.id.shi_img);
            jian = itemView.findViewById(R.id.jian);
            jia = itemView.findViewById(R.id.jia);
            shi_name = itemView.findViewById(R.id.shi_name);
            shi_yue = itemView.findViewById(R.id.shi_yue);
            shi_price = itemView.findViewById(R.id.shi_price);
            shi_num = itemView.findViewById(R.id.shi_num);
        }
    }
}
