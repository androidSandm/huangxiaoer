package com.example.boylucky.myfirst.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.bean.ScanBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/12.
 */

public class MyRlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ScanBean.DataBean.TuijianBean.ListBeanX> list;

    public MyRlvAdapter(Context context, List<ScanBean.DataBean.TuijianBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= View.inflate(context, R.layout.item_tuijian, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.class_title.setText(list.get(position).getTitle());
        myViewHolder.class_price.setText(list.get(position).getPrice()+"");
        myViewHolder.class_img.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView class_img;
        ImageView tianjia;
        TextView class_title,class_price;
        public MyViewHolder(View itemView) {
            super(itemView);
            class_img = itemView.findViewById(R.id.class_img);
            tianjia = itemView.findViewById(R.id.tianjia);
            class_title = itemView.findViewById(R.id.class_title);
            class_price = itemView.findViewById(R.id.class_price);
        }
    }
}
